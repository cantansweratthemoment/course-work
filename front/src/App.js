import React, {Component} from 'react';

import Heading from "./components/Heading";
import Loginpage from "./components/login/Loginpage";
import Mainpageexample from "./components/main/niggawhydoyouexist/Mainpageexample";
import Login from "./components/login/Login";
import Mainpage from "./components/main/Mainpage";

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
      {//this.props.store.getState().login !== null ? <Mainpageexample/> :
        //<Loginpage/>
        <Mainpage/>}
    </div>)

  }
}

export default App;