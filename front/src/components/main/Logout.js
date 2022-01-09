import React from "react";
import store from "../../app/store";
import LogoutIcon from '@mui/icons-material/Logout';
import {IconButton} from "@mui/material";

function Logout() {
    const logout = e => {
        store.dispatch({type: "change", value: null});
        console.log(store.getState());
    }
    return ( <IconButton aria-label="logout" onClick={logout}><LogoutIcon/></IconButton>
    )
}
export default Logout