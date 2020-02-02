import React, { useState } from "react";
import { Button, FormGroup, FormControl, FormLabel } from "react-bootstrap";
import "./Login.css";
import {useHistory} from "react-router";
import {loginEndpoint} from "../api";
import toast from 'toasted-notes'
import 'toasted-notes/src/styles.css'

export function LoginForm(props) {
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const history = useHistory()
    console.log({ email, password })

    function validateForm() {
        return email.length > 0 && password.length > 0;
    }

    function handleSubmit(event) {
        event.preventDefault();
    }

    function onSubmit() {
        console.log('submitted')
        let user = {
            email: email,
            password: password
        }
        loginEndpoint(user).then((response) => {
            if(response.data.token)
            {
                localStorage.setItem("token", response.data.token);
            }
            history.push('/home')
        }).catch((error) =>{
            toast.notify("Zły login lub hasło")
        })

    }

    return (
        <div className="Login">
            <form onSubmit={handleSubmit}>
                <FormGroup controlId="email">
                    <FormLabel>Email</FormLabel>
                    <FormControl
                        autoFocus
                        type="email"
                        value={email}
                        onChange={e => setEmail(e.target.value)}
                    />
                </FormGroup>
                <FormGroup controlId="password">
                    <FormLabel>Hasło</FormLabel>
                    <FormControl
                        value={password}
                        onChange={e => setPassword(e.target.value)}
                        type="password"
                    />
                </FormGroup>
                <Button block disabled={!validateForm()} type="submit" onClick={onSubmit}>
                    Login
                </Button>
            </form>
        </div>
    );
}