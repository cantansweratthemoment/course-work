import React from "react";
import {Grid} from "@mui/material";
import Buildings from "./actions/Buildings";
import Container from "@mui/material/Container";
import AboutMyManager from "./actions/athlete_or_staff_actions/AboutMyManager";
import MyEvents from "./actions/athlete_or_staff_actions/MyEvents";
import Locations from "./actions/Locations";

function AthleteOrStaffActionBox() {
    return (<div id="athlete_action_box">
        <Container maxWidth="lg" sx={{marginTop: 3}}>
            <Grid container spacing={0} >
                <Grid item xs={6}>
                    <AboutMyManager/>
                </Grid>
                <Grid item xs={6}>
                    <MyEvents/>
                </Grid>
                <Grid item xs={6}>
                    <Buildings/>
                </Grid>
                <Grid item xs={6}>
                    <Locations/>
                </Grid>
            </Grid>
        </Container>
    </div>)
}

export default AthleteOrStaffActionBox