import React, {useState} from "react";
import {Button, Col, Row, Form, Table } from "react-bootstrap";
import {Select} from "../Common/Select";




export default function HomeForm() {
    const [kierunek, setKierunek] = useState(1);
    const [specjalnosc, setSpecjalnosc] = useState(1);
    const [rok, setRok] = useState(1);
    const [semestr, setSemestr] = useState(1);
    const [typ, setTyp] = useState("Nowe przedzielenie");

    function submit(event) {
        event.preventDefault();

        console.log({ kierunek })
        console.log({ specjalnosc })
        console.log({ rok })
        console.log({ semestr })
        console.log({ typ })
    }

    return (
        <Form onSubmit={submit}>
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
                            <Select options={["Nowe przedzielenie","Plan studiów wersja 1"]} onChange={setTyp} />
                        </div>
                    </Form.Group>
                </Col>
                <Col md={2}>
                    Nazwa planu powierzeń
                </Col>
                <Col md={5}>
                    <Form.Control />
                </Col>
            </Row>
            <Row>
                <Col md={10}>
                    <Form.Group className="selects-row">
                        <div>
                            <Form.Label>Kierunek</Form.Label>
                            <Select options={[1,2,3,4,5]} onChange={setKierunek} />
                        </div>
                        <div>
                            <Form.Label>Specjalność</Form.Label>
                            <Select options={[1,2,3,4,5]} onChange={setSpecjalnosc} />
                        </div>
                        <div>
                            <Form.Label>Rok</Form.Label>
                            <Select options={[1,2,3,4,5]} onChange={setRok} />
                        </div>
                        <div>
                            <Form.Label>Semestr</Form.Label>
                            <Select options={[1,2,3,4,5]} onChange={setSemestr} />
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
                    <tr>
                        <td>1</td>
                        <td>Projektowanie systemów informatycznych</td>
                        <td>15</td>
                        <td>Wykład</td>
                        <td>0</td>
                        <td>
                            <td>
                                <p>Mykhailo Stavniichuk</p>
                            </td>
                            <td> <Button style={{borderRadius: 100 + '%'}}>+</Button></td>
                        </td>
                    </tr>

                    <tr>
                        <td>2</td>
                        <td>Projektowanie systemów informatycznych</td>
                        <td>30</td>
                        <td>Projekt</td>
                        <td>15</td>
                        <td>
                            <td> <p>Mykhailo Stavniichuk</p></td>
                            <td> <Button style={{borderRadius: 100 + '%'}}>+</Button></td>
                        </td>
                    </tr>
                    </tbody>
                </Table>

            </Row>
            <Row>
                <Button type="submit" style={{marginRight: 0.5 + 'rem'}}>Zapisz wersję roboczą</Button>
                <Button type="submit" onClick={submit}>Zatwierdz</Button>
            </Row>

            <Row>
                <Col md={4} style={{borderColor: 'black', borderStyle: 'solid', marginTop: 1 + 'rem', height: 140 +'px'}}>

                    <Form >
                        <p className="d-flex">Raporty</p>
                        {['checkbox'].map(type => (
                            <div key={`default-${type}`} className="mb-3" >
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
                                <Button type="submit" style={{float: 'right'}}>Generuj</Button>
                            </div>
                        ))}

                    </Form>


                </Col>
            </Row>
        </Form>
    )
}
