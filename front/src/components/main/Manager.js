import React, {useState} from "react";
import ManagerActionBox from "./ManagerActionBox";
import LocationsResult from "./action_results/LocationsResult";
import Container from "@mui/material/Container";
import ListOfManagedResult from "./action_results/manager/ListOfManagedResult";
import PeopleWithoutAManagerResult from "./action_results/manager/PeopleWithoutAManagerResult";
import BuildingsResult from "./action_results/BuildingsResult";
import ManageNewPersonResult from "./action_results/manager/ManageNewPersonResult";
import ManageStaffResult from "./action_results/manager/ManageStaffResult";
import SetEventResult from "./action_results/manager/SetEventResult";

function Manager(props) {
    const [action, setAction] = useState("none");
    switch (action) {
        case 'none':
            return (<ManagerActionBox login={props.login} role={props.role} setAction={setAction}/>);
        case 'locations':
            return (<Container><LocationsResult login={props.login} role={props.role} setAction={setAction}/></Container>);
        case 'list_of_managed':
            return (<Container><ListOfManagedResult login={props.login} role={props.role} setAction={setAction}/></Container>)
        case 'list_of_people_without_a_manager':
            return (<Container><PeopleWithoutAManagerResult login={props.login} role={props.role} setAction={setAction}/></Container>)
        case 'buildings':
            return (<Container><BuildingsResult login={props.login} role={props.role} setAction={setAction}/></Container>)
        case 'manage_new_person':
            return (<Container><ManageNewPersonResult login={props.login} role={props.role} setAction={setAction}/></Container>)
        case 'manage_staff':
            return (<Container><ManageStaffResult login={props.login} role={props.role} setAction={setAction}/></Container>)
        case 'set_event':
            return (<Container><SetEventResult login={props.login} role={props.role} setAction={setAction}/></Container>)
        default:
            return;
    }
}

export default Manager