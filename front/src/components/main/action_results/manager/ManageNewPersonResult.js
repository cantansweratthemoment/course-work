import React, {useEffect, useState} from "react";
import {
    Alert, FormControl,
    FormControlLabel, FormLabel, InputLabel, MenuItem, Radio, RadioGroup, Select, Stack,
    styled,
    Switch,
    Table,
    TableBody,
    TableCell,
    TableContainer,
    TableHead,
    TableRow
} from "@mui/material";
import Typography from "@mui/material/Typography";
import Box from "@mui/material/Box";
import Button from "@mui/material/Button";
import BackButton from "../BackButton";

function ManageNewPersonResult(props) {
    const [notManagedPeopleRows, setNotManagedPeopleRows] = useState([]);
    const [login, setLogin] = useState("");
    const [success, setSuccess] = useState(false);

    const handleIdChange = (event) => {
        setLogin(event.target.value);
    };

    const handle = (event) => {
        event.preventDefault();
        setSuccess(false);
        fetch("manager/managePerson/"+login, {
            method: "POST"
        }).then(response => response.json().then(json => {
                if (response.ok) {
                    if (json.state === 200) {
                        setSuccess(true);
                    }
                }
            }
        ))
    }

    useEffect(() => {
        fetch("manager/noManagerInfo", {
            method: "POST"
        }).then(response => response.json().then(json => {
                if (response.ok) {
                    if (json.state === 200) {
                        console.log(json);
                        let data = json.data;
                        let dataRows = [];
                        data.forEach((one_object) => {
                            let row = createData(one_object.login, one_object.person.name);
                            dataRows.push(row);
                        })
                        console.log(dataRows);
                        setNotManagedPeopleRows(dataRows);
                    }
                }
            }
        ))
    }, [])

    function createData(login, name) {
        return {login, name};
    }

    return (
        <Box
            sx={{
                marginTop: 8,
                display: 'flex',
                flexDirection: 'column',
                alignItems: 'center',
            }}
        >
            <BackButton setAction={props.setAction}/>
            <Typography component="h4" variant="h10">
                Who do you want to manage?
            </Typography>

            <Box component="form" noValidate sx={{mt: 1}}>
                <FormControl fullWidth>
                    <InputLabel id="demo-simple-select-label">Not Managed People</InputLabel>
                    <Select
                        labelId="demo-simple-select-label"
                        id="demo-simple-select"
                        label="Location"
                        onChange={handleIdChange}
                    >
                        {notManagedPeopleRows.map((row) => (
                            <MenuItem value={row.login}>{row.name}</MenuItem>
                        ))}
                    </Select>
                </FormControl>
                <Button
                    color="primary"
                    variant="outlined"
                    fullWidth
                    sx={{mt: 3, mb: 2}}
                    onClick={handle}
                >
                    Ok!
                </Button>
                {success ? <Alert severity="success">Success!</Alert> : ''}
            </Box>
        </Box>
    );
}

export default ManageNewPersonResult