import React from "react";
import store from "../../../app/store";

function Logout() {
    const logout = e => {
        store.dispatch({type: "change", value: null});
        console.log(store.getState());
    }
    return (<div>
            <button id="but" type="button" onClick={logout}>logout</button>
        </div>
    )
}
export default Logout