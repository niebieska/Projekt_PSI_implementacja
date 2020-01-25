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
                    <p className="float-left">Jesteś zalogowany jako koordynator powierzeń</p>
                    <Button variant="primary" className="float-right">Wyloguj</Button>
                </Col>
            </Row>
            <Row className="mb-3">
                <Col>
                    <Button className="float-left" onClick={onClickToSub}>Przedzielanie powierzeń dla modułów obowiązkowych</Button>
                </Col>
            </Row>
            <Row>
                <Col>
                    <Button className="float-left">Przedzielanie powierzeń dla modułów wybieralnych</Button>
                </Col>

            </Row>
        </>
    )
}
