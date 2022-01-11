import React, {useState} from "react";
import ManagerActionBox from "./ManagerActionBox";
import LocationsResult from "./action_results/LocationsResult";
import Container from "@mui/material/Container";
import ListOfManagedResult from "./action_results/manager/ListOfManagedResult";


function Manager(props) {
    const [action, setAction] = useState("none");
    switch (action) {
        case 'none':
            return (<ManagerActionBox login={props.login} role={props.role} setAction={setAction}/>);
        case 'locations':
            return (<Container><LocationsResult login={props.login} role={props.role} setAction={setAction}/></Container>);
        case 'list_of_managed':
            return (<Container><ListOfManagedResult login={props.login} role={props.role} setAction={setAction}/></Container>)
        default:
            return;
    }
}

export default Manager