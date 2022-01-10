import React, {Component} from 'react';
import '@fontsource/roboto/300.css';
import '@fontsource/roboto/400.css';
import '@fontsource/roboto/500.css';
import '@fontsource/roboto/700.css';

import Main from "./components/main/Main";
import Login from "./components/login/Login";
import ManagerActionBox from "./components/main/ManagerActionBox";

class App extends Component {
  componentDidMount() {
    this.props.store.subscribe(() => {
      this.setState({reduxState: this.props.store.getState()});
    })
  }

  render() {
    return (<div  className="firstPage" style={{
      backgroundColor: "#f1faee",
    }}>
      { console.log(this.props.store.getState().login)}
      {
        <div style={{height:"100vh"}}>
          {this.props.store.getState().login !== null ? <Main role={this.props.store.getState().role} login = {this.props.store.getState().login}/> :<Login/>
             }
        </div>}
    </div>)

  }
}

export default App;