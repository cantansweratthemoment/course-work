import {createStore} from "redux";

const initialState = {
  login: sessionStorage.getItem("login")
};

function reducer(state, action) {
  switch (action.type) {
    case "change":
      sessionStorage.setItem("login", action.value)
      return {login: action.value};
    default:
      return state;
  }
}

const store = createStore(reducer, initialState);
export default store;
