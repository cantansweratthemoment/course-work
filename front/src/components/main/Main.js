import React, {useEffect, useState} from "react";
import store from "../../app/store";
import Header from "./Header";
import ManagerActionBox from "./ManagerActionBox";
import AthleteOrStaffActionBox from "./AthleteOrStaffActionBox";
import Logout from "./Logout";

function Main(props) {
    return (<div id="maindiv">
        <Logout/>
        <Header/>
        {props.role === 2 ? <ManagerActionBox login = {props.login} role = {props.role}/> :<AthleteOrStaffActionBox login = {props.login} role = {props.role}/>}
    </div>)
}
export default Main