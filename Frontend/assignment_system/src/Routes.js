import React from "react";
import { Route, Switch } from "react-router-dom";
import {LoginForm} from "./Auth/LogginForm";
import HomeForm from "./Home/Form";
import SubjectForm from "./Subject/SubjectForm";

export default function Routes() {
    return (
        <Switch>
            <Route path="/" exact component={LoginForm} />
            <Route path="/home" exact component={HomeForm} />
            <Route path="/subject" exact component={SubjectForm} />
        </Switch>
    );
}
