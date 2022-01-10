import {createStore} from "redux";

const initialState = {
    login: null,
    role: sessionStorage.getItem("role")
};

function reducer(state, action) {
    switch (action.type) {
        case "change_login":
            sessionStorage.setItem("login", action.value)
            return {login: action.value, role: sessionStorage.getItem("role")};
        case "change_role":
            sessionStorage.setItem("role", action.value)
            return {login: sessionStorage.getItem("login"), role: action.value};
        default:
            return state;
    }
}

const store = createStore(reducer, initialState);
export default store;