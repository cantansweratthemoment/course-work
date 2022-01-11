import React, {useEffect, useState} from "react";
import Header from "./Header";
import Logout from "./Logout";
import Manager from "./Manager";
import StaffOrAthlete from "./StaffOrAthlete";

function Main(props) {
    return (<div id="maindiv">
        <Logout/>
        <Header/>
        {props.role === '2' ? <Manager login = {props.login} role = {props.role}/> :<StaffOrAthlete login = {props.login} role = {props.role}/>}
    </div>)
}
export default Main