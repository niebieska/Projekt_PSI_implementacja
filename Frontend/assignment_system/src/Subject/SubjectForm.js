import React, { Component } from 'react';
import {Button, Col, Row, Form, Table, Modal, FormControl } from "react-bootstrap";
import {Select} from "../Common/Components/Select";
import './Subject.css'
import {getOptions, getSubjectData, getEntrustPlan, saveEntrustPlan, getStaff, saveEntrust} from '../api'


class HomeForm extends Component{

    constructor(props) {
        super(props)
        this.state = {
            kierunekStudiow : [],
        specjalnosc : [],
        rok : [],
        numerSemestru : [],
            wybKierunek : null,
            wybRok : null,
            wybSpecjalnosc : null,
            wybSemestr : null,
            kurses : [],
            mergedKurses: [],
            show : false,
            entrustPlans :[],
            selectedPlan :{},
            name: '',
            prowadzacy: [],
            updatedProwadzacy: [],
            selectedKurs: {},
        }
        this.handleChangeRok = this.handleChangeRok.bind(this);
        this.handleChangeKierunek = this.handleChangeKierunek.bind(this);
        this.handleChangeSpecjalnosc = this.handleChangeSpecjalnosc.bind(this);
        this.handleChangeSemestr = this.handleChangeSemestr.bind(this);
        this.loadData = this.loadData.bind(this);
        this.handleClose = this.handleClose.bind(this)
        this.handleShow = this.handleShow.bind(this)
        this.handleChangeEntrustPlan = this.handleChangeEntrustPlan.bind(this)
        this.handleCreateNewPlan = this.handleCreateNewPlan.bind(this)
        this.handleNumberOfHours = this.handleNumberOfHours.bind(this)
    }

    typ = "Nowe przedzielenie";
    show = false;
    toUpdate = [];
    handleClose = (save) => {
        this.setState({show: false});
        if (save) {
            this.toUpdate.map((obj) => {
                let powierzenieId = this.state.selectedPlan.powierzenia.find(x => x.prowadzacy.id === obj.id && x.kurs.id === this.state.selectedKurs.id);
                if(powierzenieId != undefined)
                {
                    powierzenieId = powierzenieId.id;
                }else{
                    powierzenieId = 0;
                }
                    let plan = {
                        "powierzenia": [
                            {
                                "id" : powierzenieId,
                                "prowadzacy": {
                                    "id": obj.id
                                },
                                "kurs": {
                                    "id": this.state.selectedKurs.id
                                },
                                "liczbaGodzin":obj.value,
                            }],
                        "nazwa": this.state.selectedPlan.nazwa,
                        "identyfikatorSemestru": {
                            "cyklKsztalcenia": this.state.wybRok,
                            "kierunekStudiow": this.state.wybKierunek,
                            "specjalnosc": this.state.wybSpecjalnosc,
                            "numerSemestru": this.state.wybSemestr
                        },
                        "id" : this.state.selectedPlan.id
                }
                saveEntrust(plan).then((response) => {
                    if(response.status === 201)
                    {
                        getEntrustPlan({
                            "cyklKsztalcenia": this.state.wybRok,
                            "kierunekStudiow": this.state.wybKierunek,
                            "specjalnosc": this.state.wybSpecjalnosc,
                            "numerSemestru": this.state.wybSemestr
                        }).then((response) => {
                            this.setState({entrustPlans : response.data})
                            this.state.selectedPlan = response.data.find(x => x.nazwa === this.state.selectedPlan.nazwa);
                            this.mergeBothPlans();
                        })
                    }
                })
            })
        }
        this.toUpdate = [];
    }

    handleShow = (kurs) =>  {
        this.setState({show : true});
        this.setState({selectedKurs: kurs});
    }
    allInformation = [];
    kurses = [];

    handleChangeRok(event) {
        this.calculateOptions('rok', event)
    }

    handleNumberOfHours(event, id) {
        this.toUpdate[id] = {
            "id": id,
            "value" : event
        };
        if(event === undefined || event === '')
        {
            this.toUpdate[id] = {};
        }
    }

    handleCreateNewPlan(){
        saveEntrustPlan({
            "powierzenia": [],
            "nazwa": this.state.name,
            "identyfikatorSemestru": {
                "cyklKsztalcenia": this.state.wybRok,
                "kierunekStudiow": this.state.wybKierunek,
                "specjalnosc": this.state.wybSpecjalnosc,
                "numerSemestru": this.state.wybSemestr
            },
            "zatwierdzony": false,
            "id": 0
        }).then(() => {
            getEntrustPlan({
                "cyklKsztalcenia": this.state.wybRok,
                "kierunekStudiow": this.state.wybKierunek,
                "specjalnosc": this.state.wybSpecjalnosc,
                "numerSemestru": this.state.wybSemestr
            }).then((response) => {
                this.setState({entrustPlans : response.data})
            })

        })
    }
    handleChangeEntrustPlan(event){
        let plan = this.state.entrustPlans.find(x => x.nazwa === event);
        this.setState({selectedPlan : plan});
        this.state.selectedPlan = plan;
        this.mergeBothPlans();
    }
    handleChangeKierunek(event) {
        this.calculateOptions('kierunek', event)
    }
    handleChangeSpecjalnosc(event) {
        this.calculateOptions('specjalnosc', event)
    }
    handleChangeSemestr(event) {
        this.calculateOptions('semestr', event)
    }

    mergeBothPlans() {
        this.state.mergedKurses = JSON.parse(JSON.stringify(this.state.kurses));
        this.state.updatedProwadzacy = JSON.parse(JSON.stringify(this.state.prowadzacy));
        for (let i = 0; i < this.state.kurses.length; i++) {
            for (let j = 0; j < this.state.selectedPlan.powierzenia.length; j++) {
                if (this.state.kurses[i].nazwa === this.state.selectedPlan.powierzenia[j].kurs.nazwa && this.state.kurses[i].formaZajec === this.state.selectedPlan.powierzenia[j].kurs.formaZajec) {
                    this.state.mergedKurses[i].liczbaGrup -= this.state.selectedPlan.powierzenia[j].liczbaGodzin
                    let prow = this.state.selectedPlan.powierzenia[j].prowadzacy
                    prow.occupiedTime = this.state.selectedPlan.powierzenia[j].liczbaGodzin;
                    this.state.mergedKurses[i].prowadzacy.push(prow)
                    this.state.updatedProwadzacy.find(x => x.email === prow.email).pozostaloPensum -= this.state.selectedPlan.powierzenia[j].liczbaGodzin;
                }
            }
        }
        this.setState({mergedKurses : this.state.mergedKurses});
    }

    calculateOptions(option, value){
        let temp = 0;
        let temp_value = {};
        if(option === 'rok') {
            temp_value.rok = value;
            temp_value.kierunek = this.getAllKierunek(this.allInformation, value);
            temp = [...new Set(temp_value.kierunek)].length;
            this.setState({wybRok: value});
            this.setState({kierunekStudiow: [...new Set(temp_value.kierunek)]});
            temp_value.kierunek = temp_value.kierunek[0];
            this.state.wybRok = value
            this.setState({wybKierunek: ''})
            this.setState({specjalnosc: []})
            this.setState({wybSpecjalnosc: ''})
            this.setState({numerSemestru: []})
            this.state.wybKierunek = '';
            this.state.wybSpecjalnosc = '';
			this.state.wybSemestr = '';
        }

        if(temp === 1)
        {
            temp = 0;
            option = 'kierunek'
            value = temp_value.kierunek;
        }
        if(option === 'kierunek') {
            temp_value.specjalnosc = this.getAllSpecjalnosc(this.allInformation, this.getIfUndefine(this.state.wybRok, temp_value.rok), value);
            temp = [...new Set(temp_value.specjalnosc)].length;
            this.setState({wybKierunek: value})
            this.setState({specjalnosc: [...new Set(temp_value.specjalnosc)] })
            this.setState({wybSpecjalnosc: ''})
            this.setState({numerSemestru: []})
            this.state.wybSpecjalnosc = '';
			this.state.wybSemestr = '';
        }
        if(temp === 1)
        {
            temp = 0;
            option = 'specjalnosc'
            value = temp_value.specjalnosc[0];
        }
        if(option === 'specjalnosc') {
            let sem = this.getAllSemester(this.allInformation, this.getIfUndefine(this.state.wybRok, temp_value.rok), this.getIfUndefine(this.state.wybKierunek, temp_value.kierunek), value)
            this.setState({wybSpecjalnosc: value})
            this.setState({numerSemestru: [...new Set(sem)]})
            temp = [...new Set(sem)].length;
            temp_value.semestr = [...new Set(sem)][0];
			this.state.wybSemestr = '';
        }
        if(temp === 1)
        {
            temp = 0;
            option = 'semestr'
            value = temp_value.semestr;
        }
        if(option === 'semestr') {
            this.setState({wybSemestr: value})
        }
    }

    loadData(){
        getSubjectData({
            "cyklKsztalcenia": this.state.wybRok,
            "kierunekStudiow": this.state.wybKierunek,
            "specjalnosc": this.state.wybSpecjalnosc,
            "numerSemestru": this.state.wybSemestr
        }).then((response) => {
            const {
                identyfikatorSemestru: {
                    cyklKsztalcenia,
                    kierunekStudiow,
                    specjalnosc,
                    numerSemestru,
                },
                modulDto,
            } = response.data

            this.setState({kurses:  modulDto.reduce((result, item) => result.concat(
                    item.kursy.map(kurs => ({
                        id: kurs.id,
                        nazwa: kurs.nazwa,
                        liczbaGodzin: kurs.liczbaGodzin,
                        formaZajec: kurs.formaZajec,
                        liczbaGrup: kurs.liczbaGodzin,
                        prowadzacy : [],
                    }))
                ), [])})

            getEntrustPlan({
                "cyklKsztalcenia": this.state.wybRok,
                "kierunekStudiow": this.state.wybKierunek,
                "specjalnosc": this.state.wybSpecjalnosc,
                "numerSemestru": this.state.wybSemestr
            }).then((response) => {
                this.setState({entrustPlans : response.data})
                this.state.selectedPlan = response.data[0]
                this.setState({selectedPlan:response.data[0]})
                this.mergeBothPlans()
            })

        });
    }

    getIfUndefine(obj1, obj2) {
        return obj1 || obj2;
    }

    componentDidMount() {
        getOptions().then(res => {
            this.allInformation = res.data;
            let choosenRok = this.getAllCyklKsztalcenia(this.allInformation);


            this.setState({rok : [...new Set(choosenRok)]})

            this.calculateOptions('rok', choosenRok[0]);
        });
        getStaff().then((response) => {
            this.setState({prowadzacy : response.data})
        })

    };

    getAllCyklKsztalcenia = (obj) => {
        return obj.map(x => x.cyklKsztalcenia)
    }
    getAllKierunek = (obj, cykl) => {
        return obj.filter(x => x.cyklKsztalcenia === cykl).map(x => x.kierunekStudiow)
    }
    getAllSpecjalnosc = (obj, cykl, kierunek) => {
        return obj.filter(x => x.cyklKsztalcenia === cykl).filter(x => x.kierunekStudiow === kierunek).map(x => x.specjalnosc)
    }
    getAllSemester = (obj, cykl, kierunek, specjalnosc) => {
        return obj.filter(x => x.cyklKsztalcenia === cykl).filter(x => x.kierunekStudiow === kierunek).filter(x => x.specjalnosc === specjalnosc).map(x => x.numerSemestru)
    }


    submit(event){
        event.preventDefault();

        console.log( this.kierunekStudiow );
        console.log( this.specjalnosc );
        console.log( this.rok );
        console.log( this.numerSemestru );
        console.log( this.typ );
    };

    render () {
        return (
        <Form onSubmit={this.submit}>
            <Row>
                <Col>
                    <Form.Group className="d-flex justify-content-between">
                        <p>Przedzielanie powierzeń dla modułów obowiązkowych</p>
                        <Button variant="primary">Wyloguj</Button>
                    </Form.Group>
                </Col>
            </Row>
            <Row>
                <Col md={3}>
                    <Form.Group>
                        <div>
                            <Select options={this.state.entrustPlans.map(x => x.nazwa)} onChange={this.handleChangeEntrustPlan}/>
                        </div>
                    </Form.Group>
                </Col>
                <Col md={2}>
                    Nazwa planu powierzeń
                </Col>
                <Col md={5}>
                    <Form.Control as="input" ref={this.state.name} onChange={(ev) => this.setState({"name":ev.target.value})}/>
                </Col>
                <Col>
                    <div>
                        <Button onClick={this.handleCreateNewPlan}>Create new plan</Button>
                    </div>
                </Col>>
            </Row>
            <Row>
                <Col md={10}>
                    <Form.Group className="selects-row">
                        <div>
                            <Form.Label>Rok</Form.Label>
                            <Select options={this.state.rok} onChange={this.handleChangeRok}/>
                        </div>
                        <div>
                            <Form.Label>Kierunek</Form.Label>
                            <Select options={this.state.kierunekStudiow} onChange={this.handleChangeKierunek}/>
                        </div>
                        <div>
                            <Form.Label>Specjalność</Form.Label>
                            <Select options={this.state.specjalnosc} onChange={this.handleChangeSpecjalnosc}/>
                        </div>
                        <div>
                            <Form.Label>Semestr</Form.Label>
                            <Select options={this.state.numerSemestru} onChange={this.handleChangeSemestr}/>
                        </div>
                            <div>
                                <Button onClick={this.loadData} style={{"margin-top": "30px"}}>Submit</Button>
                            </div>
                    </Form.Group>
                </Col>
            </Row>
            <Row>
                <Table striped bordered hover>
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>Kurs</th>
                        <th>Liczba godzin</th>
                        <th>Typ zajeć</th>
                        <th>Pozostała liczba godzin do przedzienia</th>
                        <th>Prowadzący</th>
                    </tr>
                    </thead>
                    <tbody>
                    {this.state.mergedKurses.map((kurs) => (
                        <tr key={kurs.id}>
                            <td>{kurs.id}</td>
                            <td>{kurs.nazwa}</td>
                            <td>{kurs.liczbaGodzin}</td>
                            <td>{kurs.formaZajec}</td>
                            <td>{kurs.liczbaGrup}</td>
                            <td>
                                {kurs.prowadzacy.map((prow, index) => (
                                    <tr key={index}> {prow.imie + " " + prow.nazwisko + "(" + prow.occupiedTime + ")"} </tr>
                                ))}
                                <td><Button className="round-button" onClick={() => this.handleShow(kurs)}>+</Button></td>
                            </td>
                        </tr>
                    ))}
                    </tbody>
                </Table>

            </Row>
            <Row className="justify-content-end">
                <Button type="submit" className="mr-2">Zapisz wersję roboczą</Button>
                <Button type="submit" onClick={this.submit}>Zatwierdz</Button>
            </Row>

            <Row>
                <Col md={4} className="report-box">

                    <Form>
                        <p className="d-flex">Raporty</p>
                        {['checkbox'].map(type => (
                            <div key={`default-${type}`} className="mb-3">
                                <Form.Check
                                    type={type}
                                    id={`1-${type}`}
                                    label={`Zajęcia bez obsady`}
                                    className="d-flex"
                                />

                                <Form.Check
                                    type={type}
                                    id={`2-${type}`}
                                    label={`Aktualne powierzenia pracowników`}
                                    className="d-flex"
                                />

                                <div className="d-flex justify-content-end">
                                    <Button type="submit" className="float-right">Generuj</Button>
                                </div>
                            </div>
                        ))}

                    </Form>
                </Col>
            </Row>


            <Modal show={this.state.show} onHide={this.handleClose} size="lg" aria-labelledby="contained-modal-title-vcenter" centered>
                <Modal.Header closeButton>
                    <Modal.Title>Lista dostępnych prowadzących</Modal.Title>
                </Modal.Header>
                <Modal.Body>

                    {['checkbox'].map(type => (
                        <div key={`default-${type}`} className="mb-3">
                            <Row>
                                <Col>
                                    <Form.Check
                                        type={type}
                                        id={`1-${type}`}
                                        label={`Historyczna  obsada`}
                                        className="d-flex"
                                    />
                                </Col>
                                <Col>
                                    <Form.Check
                                        type={type}
                                        id={`2-${type}`}
                                        label={`Preferencja prowadzącego`}
                                        className="d-flex"
                                    />
                                </Col>
                            </Row>
                        </div>
                    ))}
                    <Row>
                        <Col>
                            <p><FormControl type="text" placeholder="Wyszukaj" className="mr-sm-2"/></p>
                        </Col>
                    </Row>

                    <Row>
                        <Col>
                            <Table striped bordered hover>
                                <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Prowadzący</th>
                                    <th>Pozostałe pensum do przedzielenia</th>
                                    <th>Proponowana liczba godzin</th>

                                </tr>
                                </thead>
                                <tbody>
                                { this.state.updatedProwadzacy.map((prow) => (
                                    <tr>
                                        <td>{prow.id}</td>
                                        <td>{prow.imie + " " + prow.nazwisko}</td>
                                        <td>{prow.pozostaloPensum}</td>
                                        <td><FormControl defaultValue={this.state.selectedPlan.powierzenia.filter(x => x.prowadzacy.id === prow.id && x.kurs.id === this.state.selectedKurs.id).map(x => x.liczbaGodzin).reduce( (x, y) => x + y, 0)} type="text" className="mr-sm-2" onChange={(eve) => this.handleNumberOfHours(eve.target.value, prow.id)}/></td>
                                    </tr>
                                ))}
                                </tbody>
                            </Table>
                        </Col>
                    </Row>

                    <Form.Group className="d-flex justify-content-between ">

                        <p> Pozostała liczba godzin do przydzielenia - {this.state.selectedKurs.liczbaGrup} </p>

                        <div>
                            <Button variant="secondary" className="mr-2" onClick={() => this.handleClose(false)}>
                                Close
                            </Button>
                            <Button variant="primary" onClick={() => this.handleClose(true)}>
                                Save Changes
                            </Button>
                        </div>
                    </Form.Group>


                </Modal.Body>
            </Modal>

        </Form>
        )}
}
export default HomeForm;