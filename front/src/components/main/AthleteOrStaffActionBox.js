import React from "react";
import {Grid} from "@mui/material";
import Buildings from "./actions/Buildings";
import Container from "@mui/material/Container";
import AboutMyManager from "./actions/athlete_or_staff_actions/AboutMyManager";
import MyEvents from "./actions/athlete_or_staff_actions/MyEvents";
import Locations from "./actions/Locations";

function AthleteOrStaffActionBox(props) {
    return (<div id="athlete_action_box">
        <Container maxWidth="lg" sx={{marginTop: 3}}>
            <Grid container spacing={0} >
                <Grid item xs={6}>
                    <AboutMyManager login = {props.login} role = {props.role} setAction={props.setAction}/>
                </Grid>
                <Grid item xs={6}>
                    <MyEvents login = {props.login} role = {props.role} setAction={props.setAction}/>
                </Grid>
                <Grid item xs={6}>
                    <Buildings login = {props.login} role = {props.role} setAction={props.setAction}/>
                </Grid>
                <Grid item xs={6}>
                    <Locations login = {props.login} role = {props.role} setAction={props.setAction}/>
                </Grid>
            </Grid>
        </Container>
    </div>)
}

export default AthleteOrStaffActionBox