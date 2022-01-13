import * as React from 'react';
import Button from '@mui/material/Button';
import CssBaseline from '@mui/material/CssBaseline';
import TextField from '@mui/material/TextField';
import Box from '@mui/material/Box';
import Typography from '@mui/material/Typography';
import Container from '@mui/material/Container';
import {createTheme, ThemeProvider} from '@mui/material/styles';
import {useState} from "react";
import store from "../../app/store";
import {Alert, FormControl, FormControlLabel, FormLabel, Radio, RadioGroup} from "@mui/material";

const theme = createTheme();

export default function Login() {
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [role, setRole] = useState("0");
    const [realName, setRealName] = useState("");
    const [loginError, setLoginError] = useState(false);
    const [signUpError, setSignUpError] = useState(false);
    const handleLogIn = (event) => {
        setLoginError(false);
        event.preventDefault();
        console.log({
            email: username,
            password: password,
            role: role
        });
        let information = {
            "username": username, "password": password
        };
        let body = [];
        for (const inf in information) {
            body.push("/" + information[inf]);
        }
        console.log(body);
        body = body.join("");
        console.log(body);
        fetch("users/login" + body, {
            method: "POST"
        }).then(response => response.json().then(json => {
                if (response.ok) {
                    console.log(json)
                    if (json.state === 200) {
                        store.dispatch({type: "change_login", value: json.data.username});
                        store.dispatch({type: "change_role", value: json.data.role});
                    } else {
                        setLoginError(true);
                    }
                } else {
                    setLoginError(true);
                }
            }
        ))
    };

    const handleSignUp = (event) => {
        setSignUpError(false);
        event.preventDefault();
        console.log({
            email: username,
            password: password,
            role: role,
            name: "placeholder"
        });
        let information = {
            "login": username, "password": password, "role": role, "realName" : realName
        };
        let body = [];
        for (const inf in information) {
            body.push("/" + information[inf]);
        }
        console.log(body);
        body = body.join("");
        console.log(body);
        fetch("users/reg" + body, {
            method: "POST"
        }).then(response => response.json().then(json => {
                if (response.ok) {
                    console.log(json)
                    if (json.state === 200) {
                        store.dispatch({type: "change_login", value: json.data.username});
                        store.dispatch({type: "change_role", value: json.data.role});

                    } else {
                        setSignUpError(true);
                    }
                } else {
                    setSignUpError(true);
                }
            }
        ))
    };

    return (
        <ThemeProvider theme={theme}>
            <Container component="main" maxWidth="xs">
                <CssBaseline/>
                <Box
                    sx={{
                        marginTop: 8,
                        display: 'flex',
                        flexDirection: 'column',
                        alignItems: 'center',
                    }}
                >
                    <Typography component="h1" variant="h5">
                        Welcome back
                    </Typography>
                    <Typography component="h4" variant="h10">
                        Enter your credentials to access your account.
                    </Typography>

                    <Box component="form" noValidate sx={{mt: 1}}>
                        <TextField
                            margin="normal"
                            required
                            fullWidth
                            id="username"
                            label="Enter your username"
                            name="username"
                            autoComplete="username"
                            autoFocus
                            value={username}
                            onChange={(e) => setUsername(e.target.value)}
                        />
                        <TextField
                            margin="normal"
                            required
                            fullWidth
                            name="password"
                            label="Enter your password"
                            type="password"
                            id="password"
                            autoComplete="current-password"
                            value={password}
                            onChange={(e) => setPassword(e.target.value)}
                        />
                        <Button
                            color="primary"
                            variant="outlined"
                            fullWidth
                            onClick={handleLogIn}
                            sx={{mt: 3, mb: 2}}
                        >
                            Log In
                        </Button>
                        {loginError ? <Alert severity="error">You cannot log in - wrong info!</Alert> : ''}
                        <Typography component="h4" variant="h10">
                            Don't have an account?
                        </Typography>
                        <TextField
                            margin="normal"
                            required
                            fullWidth
                            name="realName"
                            label="Enter your real name"
                            id="realName"
                            autoComplete="current-password"
                            value={realName}
                            onChange={(e) => setRealName(e.target.value)}
                        />
                        <FormControl component="fieldset">
                            <FormLabel component="legend">Who are you?</FormLabel>
                            <RadioGroup row aria-label="role" name="row-radio-buttons-group" value={role}
                                        onChange={(e) => setRole(e.target.value)}>
                                <FormControlLabel value="2" control={<Radio/>} label="Manager"/>
                                <FormControlLabel value="0" control={<Radio/>} label="Athlete"/>
                                <FormControlLabel value="1" control={<Radio/>} label="Staff"/>
                            </RadioGroup>
                        </FormControl>
                        <Button
                            color="primary"
                            variant="outlined"
                            fullWidth
                            sx={{mt: 3, mb: 2}}
                            onClick={handleSignUp}
                        >
                            Sign Up
                        </Button>
                        {signUpError ? <Alert severity="error">You cannot sign up!</Alert> : ''}
                    </Box>
                </Box>
            </Container>
        </ThemeProvider>
    );
}