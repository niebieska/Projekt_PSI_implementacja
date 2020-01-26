import React, { useEffect, useState } from 'react'
import {Button, Col, Row, Form, Table, Modal, FormControl } from "react-bootstrap";
import {Select} from "../Common/Select";
import './Subject.css'
import { getSubjects } from '../api'

export default function HomeForm() {
    const [kierunek, setKierunek] = useState(1);
    const [specjalnosc, setSpecjalnosc] = useState(1);
    const [rok, setRok] = useState(1);
    const [semestr, setSemestr] = useState(1);
    const [typ, setTyp] = useState("Nowe przedzielenie");
    const [show, setShow] = useState(false);
    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);

    const [subjects, setSubjects] = useState([]);

    useEffect(() => {
        getSubjects().then((subjects) => {
            setSubjects(subjects)
        })
    }, []);

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
                    {subjects.map((sub) => (
                        <tr key={sub.id}>
                            <td>{sub.id}</td>
                            <td>{sub.name}</td>
                            <td>{sub.totalHours}</td>
                            <td>{sub.type}</td>
                            <td>{sub.remainHours}</td>
                            <td>
                                <td>
                                    <p>{sub.mentor}</p>
                                </td>
                                <td> <Button className="round-button" onClick={handleShow}>+</Button></td>
                            </td>
                        </tr>
                    ))}
                    </tbody>
                </Table>

            </Row>
            <Row className="justify-content-end">
                <Button type="submit" className="mr-2">Zapisz wersję roboczą</Button>
                <Button type="submit" onClick={submit}>Zatwierdz</Button>
            </Row>

            <Row>
                <Col md={4} className="report-box">

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

                                <div className="d-flex justify-content-end">
                                    <Button type="submit" className="float-right">Generuj</Button>
                                </div>
                            </div>
                        ))}

                    </Form>
                </Col>
            </Row>


            <Modal show={show} onHide={handleClose}  size="lg" aria-labelledby="contained-modal-title-vcenter"  centered>
                <Modal.Header closeButton>
                    <Modal.Title>Lista dostępnych prowadzących</Modal.Title>
                </Modal.Header>
                <Modal.Body>

                    {['checkbox'].map(type => (
                        <div key={`default-${type}`} className="mb-3" >
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
                            <p><FormControl type="text" placeholder="Wyszukaj" className="mr-sm-2" /></p>
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
                            <Button variant="secondary" className="mr-2" onClick={handleClose}>
                                Close
                            </Button>
                            <Button variant="primary" onClick={handleClose}>
                                Save Changes
                            </Button>
                        </div>
                    </Form.Group>


                </Modal.Body>
            </Modal>

        </Form>
    )
}
