import React from "react";
import ListOfManaged from "./actions/manager_actions/ListOfManaged";
import SetNextTraining from "./actions/manager_actions/SetNextTraining";
import Buildings from "./actions/Buildings";
import ListOfPeopleWithoutAManager from "./actions/manager_actions/ListOfPeopleWithoutAManager";
import Locations from "./actions/Locations";
import ManageNewPerson from "./actions/manager_actions/ManageNewPerson";
import ManageStaff from "./actions/manager_actions/ManageStaff";
import SetEvent from "./actions/manager_actions/SetEvent";
import {Grid} from "@mui/material";
import Container from "@mui/material/Container";

function ManagerActionBox() {
    return (<div id="manager_action_box">
        <Container maxWidth="lg" sx={{marginTop: 3}}>
        <Grid container spacing={0} >
            <Grid item xs={6}>
                <ListOfManaged/>
            </Grid>
            <Grid item xs={6}>
                <SetNextTraining/>
            </Grid>
            <Grid item xs={6}>
                <Buildings/>
            </Grid>
            <Grid item xs={6}>
                <ListOfPeopleWithoutAManager/>
            </Grid>
        </Grid>
        <Grid container spacing={0}>
            <Grid item xs={6}>
                <Locations/>
            </Grid>
            <Grid item xs={6}>
                <ManageNewPerson/>
            </Grid>
            <Grid item xs={6}>
                <ManageStaff/>
            </Grid>
            <Grid item xs={6}>
                <SetEvent/>
            </Grid>
        </Grid>
        </Container>
    </div>)
}

export default ManagerActionBox