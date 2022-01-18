import React, {Component} from 'react';
import '@fontsource/roboto/300.css';
import '@fontsource/roboto/400.css';
import '@fontsource/roboto/500.css';
import '@fontsource/roboto/700.css';

import Main from "./components/main/Main";
import Login from "./components/login/Login";
import {createTheme} from '@mui/material/styles';
import {ThemeProvider} from "@emotion/react";
import {IconButton} from "@mui/material";
import Brightness4Icon from '@mui/icons-material/Brightness4';
import Brightness7Icon from '@mui/icons-material/Brightness7';

const lightTheme = createTheme({
    palette: {
        mode: 'light',
        primary: {
            main: '#009639',
            light: '#81dca7',
            dark: '#006419',
        },
        secondary: {
            main: '#cf3783',
            light: '#e46fb0',
            dark: '#a23273',
        },
    },
});

const darkTheme = createTheme({
    palette: {
        mode: 'dark',
        primary: {
            main: '#009639',
            light: '#81dca7',
            dark: '#006419',
        },
        secondary: {
            main: '#cf3783',
            light: '#e46fb0',
            dark: '#a23273',
        },
    },
});

class App extends Component {

    constructor(props) {
        super(props);
        this.state = {theme: 'light'};
    }


    componentDidMount() {
        this.props.store.subscribe(() => {
            this.setState({
                reduxState: this.props.store.getState(),
            });
        })
    };

    render() {
        return (<div className="firstPage">
                <ThemeProvider theme={(
                    this.state.theme === 'dark' ? darkTheme : lightTheme
                )
                }>
                    <IconButton sx={{ml: 1}} onClick={() => {
                        if (this.state.theme === 'dark') {
                            this.setState({theme: 'light'});
                        } else {
                            this.setState({theme: 'dark'});
                        }
                    }} color="inherit">
                        {this.state.theme === 'dark' ? <Brightness7Icon/> : <Brightness4Icon/>}
                    </IconButton>
                    <div style={{height: "100vh"}}>
                        {this.props.store.getState().login !== null ?
                            <Main role={this.props.store.getState().role}
                                  login={this.props.store.getState().login}/> :
                            <Login/>
                        }
                    </div>
                </ThemeProvider>
            </div>
        )
    }
}

export default App;