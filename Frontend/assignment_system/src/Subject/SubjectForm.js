import React, {useState} from "react";
import {Button, Col, Row, Form } from "react-bootstrap";
import {Select} from "../Common/Select";


export default function HomeForm() {
    const [spec, setSpec] = useState(1);
    const [second, setSecond] = useState(1);

    function submit(event) {
        event.preventDefault();

        console.log({ spec })
    }

    return (
        <Form onSubmit={submit}>
            <Row>
                <Col>
                    <Form.Group className="d-flex justify-content-between">
                        <p>TextTextTextTextText</p>
                        <Button variant="primary">Logout</Button>
                    </Form.Group>
                </Col>
            </Row>
            <Row>
                <Col md={3}>
                    <Form.Group>
                        <Form.Control as="select">
                            <option>1</option>
                            <option>2</option>
                            <option>3</option>
                            <option>4</option>
                            <option>5</option>
                        </Form.Control>
                    </Form.Group>
                </Col>
                <Col md={2}>
                    Text
                </Col>
                <Col md={5}>
                    <Form.Control />
                </Col>
            </Row>
            <Row>
                <Col md={10}>
                    <Form.Group className="selects-row">
                        <div>
                            <Form.Label>Text</Form.Label>
                            <Select options={[1,2,3,4,5]} onChange={setSpec} />
                        </div>
                        <div>
                            <Form.Label>Text</Form.Label>
                            <Select options={[1,2,3,4,5]} />
                        </div>
                        <div>
                            <Form.Label>Text</Form.Label>
                            <Select options={[1,2,3,4,5]} />
                        </div>
                        <div>
                            <Form.Label>Text</Form.Label>
                            <Select options={[1,2,3,4,5]} />
                        </div>
                    </Form.Group>
                </Col>
            </Row>
            <Row>
                <Button type="submit" onClick={submit}>Submit</Button>
            </Row>
        </Form>
    )
}
