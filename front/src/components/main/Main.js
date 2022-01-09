import React, {useEffect, useState} from "react";
import store from "../../app/store";
import Header from "./Header";
import ManagerActionBox from "./ManagerActionBox";
import AthleteOrStaffActionBox from "./AthleteOrStaffActionBox";
import Logout from "./Logout";

function Main() {
    return (<div id="maindiv">
        <Header/>
        <AthleteOrStaffActionBox/>
        <Logout/>
    </div>)
}
export default Main