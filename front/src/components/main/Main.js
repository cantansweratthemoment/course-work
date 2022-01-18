import React, {useEffect, useState} from "react";
import Header from "./Header";
import Logout from "./Logout";
import Manager from "./Manager";
import StaffOrAthlete from "./StaffOrAthlete";
import Box from "@mui/material/Box";
import Container from "@mui/material/Container";
import CssBaseline from "@mui/material/CssBaseline";

function Main(props) {
    return (
        <Container component="main">
            <Box>
                <CssBaseline/>
                <Logout/>
                <Header/>
                {props.role === '2' ? <Manager login={props.login} role={props.role}/> :
                    <StaffOrAthlete login={props.login} role={props.role}/>}
            </Box>
        </Container>
    )
}

export default Main