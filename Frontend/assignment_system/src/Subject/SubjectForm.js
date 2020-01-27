import React, { Component } from 'react';
import {Button, Col, Row, Form, Table, Modal, FormControl } from "react-bootstrap";
import {Select} from "../Common/Select";
import './Subject.css'
import { getOptions, getSubjectData } from '../api'

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
            wybSemestr : null
        }
        this.handleChangeRok = this.handleChangeRok.bind(this);
        this.handleChangeKierunek = this.handleChangeKierunek.bind(this);
        this.handleChangeSpecjalnosc = this.handleChangeSpecjalnosc.bind(this);
        this.handleChangeSemestr = this.handleChangeSemestr.bind(this);
    }
    typ = "Nowe przedzielenie";
    show = false;
    handleClose = () => this.show = false;
    handleShow = () => this.show = true;
    allInformation = [];
    kurses = [];

    handleChangeRok(event) {
        this.calculateOptions('rok', event)
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
        }
    }

    getIfUndefine(obj1, obj2) {
        return obj1 || obj2;
    }

    componentDidMount() {
        this.allInformation = getOptions;

        let choosenRok = this.getAllCyklKsztalcenia(this.allInformation);


        this.setState({rok : [...new Set(choosenRok)]})

        this.calculateOptions('rok', choosenRok[0]);

        //this.setState({kierunek: this.getAllKierunek(this.allInformation, choosenRok[0])})
        getSubjectData().then((response) => {
            const {
                identyfikatorSemestru: {
                    cyklKsztalcenia,
                    kierunekStudiow,
                    specjalnosc,
                    numerSemestru,
                },
                modulDto,
            } = response

            this.kurses = modulDto.reduce((result, item) => result.concat(
                item.kursy.map(kurs => ({
                    id: kurs.id,
                    nazwa: kurs.nazwa,
                    liczbaGodzin: kurs.liczbaGodzin,
                    formaZajec: kurs.formaZajec,
                    liczbaGrup: kurs.liczbaGrup,
                }))
            ), [])

            /*this.rok = cyklKsztalcenia;
            setKierunek(kierunekStudiow)
            setSpecjalnosc(specjalnosc)
            setSemestr(numerSemestru)
            setKurses(kurses)*/
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
                            <Select options={["Nowe przedzielenie", "Plan studiów wersja 1"]} onChange={x => 2}/>
                        </div>
                    </Form.Group>
                </Col>
                <Col md={2}>
                    Nazwa planu powierzeń
                </Col>
                <Col md={5}>
                    <Form.Control/>
                </Col>
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
                    {this.kurses.map((kurs) => (
                        <tr key={kurs.id}>
                            <td>{kurs.id}</td>
                            <td>{kurs.nazwa}</td>
                            <td>{kurs.liczbaGodzin}</td>
                            <td>{kurs.formaZajec}</td>
                            <td>{kurs.liczbaGrup}</td>
                            <td>
                                <td>
                                    <p>EMPTY</p>
                                </td>
                                <td><Button className="round-button" onClick={this.handleShow}>+</Button></td>
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


            <Modal show={this.show} onHide={this.handleClose} size="lg" aria-labelledby="contained-modal-title-vcenter" centered>
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
                                    <th>Pozostawy pensum do przedzielenia</th>
                                    <th>Proponowana liczba godzin</th>

                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td>1</td>
                                    <td>Mykhailo Stavniichuk</td>
                                    <td>150</td>
                                    <td><FormControl type="text" className="mr-sm-2"/></td>
                                </tr>
                                </tbody>
                            </Table>
                        </Col>
                    </Row>

                    <Form.Group className="d-flex justify-content-between ">

                        <p> Pozostała liczba godzin do pezedzielenia - 25 </p>

                        <div>
                            <Button variant="secondary" className="mr-2" onClick={this.handleClose}>
                                Close
                            </Button>
                            <Button variant="primary" onClick={this.handleClose}>
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