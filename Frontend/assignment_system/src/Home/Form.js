import React from "react";
import {Button, Col, Row} from "react-bootstrap";
import {useHistory} from "react-router";


export default function HomeForm() {
    const history = useHistory()

    function onClickToSub() {
        history.push('/subject')
    }


    return (
        <>
            <Row>
                <Col>
                    <p className="float-left">TextTextTextTextText</p>
                    <Button variant="primary" className="float-right">Logout</Button>
                </Col>
            </Row>
            <Row className="mb-3">
                <Col>
                    <Button className="float-left" onClick={onClickToSub}>TetTetText</Button>
                </Col>
            </Row>
            <Row>
                <Col>
                    <Button className="float-left">TetTetText</Button>
                </Col>

            </Row>
        </>
    )
}
