import React, {useState} from "react";
import AthleteOrStaffActionBox from "./AthleteOrStaffActionBox";


function StaffOrAthlete(props) {
    const [action, setAction] = useState("none");
    switch (action) {
        case 'none':
            return (<AthleteOrStaffActionBox login={props.login} role={props.role} setAction={setAction}/>);
        default:
            return;
    }
}

export default StaffOrAthlete