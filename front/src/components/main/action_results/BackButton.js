import React from "react";
import ArrowBackIcon from '@mui/icons-material/ArrowBack';
import {IconButton} from "@mui/material";

function BackButton(props) {
    const back = e => {
        props.setAction("none");
    }
    return (<IconButton color="secondary" size="large" onClick={back}><ArrowBackIcon/></IconButton>
    )
}

export default BackButton