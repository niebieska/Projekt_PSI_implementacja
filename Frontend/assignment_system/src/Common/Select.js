import React from "react";
import { Form } from 'react-bootstrap'

export function Select({ options, onChange }) {
    return (
        <Form.Control as="select" onChange={(ev) => onChange(ev.target.value)}>
            {options.map(option => (
                <option key={option}>{option}</option>
            ))}
        </Form.Control>
    )
}
