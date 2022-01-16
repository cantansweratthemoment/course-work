import React, {useState} from "react";
import AthleteOrStaffActionBox from "./AthleteOrStaffActionBox";
import Container from "@mui/material/Container";
import LocationsResult from "./action_results/LocationsResult";
import BuildingsResult from "./action_results/BuildingsResult";
import AboutMyManagerResult from "./action_results/athlete_or_staff/AboutMyManagerResult";
import MyEventsResult from "./action_results/athlete_or_staff/MyEventsResult";


function StaffOrAthlete(props) {
    const [action, setAction] = useState("none");
    switch (action) {
        case 'none':
            return (<AthleteOrStaffActionBox login={props.login} role={props.role} setAction={setAction}/>);
        case 'locations':
            return (<Container><LocationsResult login={props.login} role={props.role} setAction={setAction}/></Container>);
        case 'buildings':
            return (<Container><BuildingsResult login={props.login} role={props.role} setAction={setAction}/></Container>);
        case 'about_my_manager':
            return (<Container><AboutMyManagerResult login={props.login} role={props.role} setAction={setAction}/></Container>);
        case 'my_events':
            return (<Container><MyEventsResult login={props.login} role={props.role} setAction={setAction}/></Container>);
        default:
            return;
    }
}

export default StaffOrAthlete