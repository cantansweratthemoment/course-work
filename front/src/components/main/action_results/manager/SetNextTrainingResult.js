import React, {useEffect, useState} from "react";
import BackButton from "../BackButton";
import Typography from "@mui/material/Typography";
import {Alert, FormControl, InputLabel, MenuItem, Select} from "@mui/material";
import TextField from "@mui/material/TextField";
import Button from "@mui/material/Button";
import Box from "@mui/material/Box";
import TimeField from 'react-simple-timefield';

function SetNextTrainingResult(props) {

    const [id, setId] = useState(0);
    const [name, setName] = useState("");
    const type = "training";
    const [beginTime, setBeginTime] = useState('00:00:00');
    const [endTime, setEndTime] = useState('00:00:00');
    const [idLoc, setIdLoc] = useState(0);
    const [athletes, setAthletes] = useState([]);
    const [locations, setLocations] = useState([]);
    const [success, setSuccess] = useState(false);

    const handle = (event) => {
        event.preventDefault();
        setSuccess(false);
        console.log("manager/event/"+id+"/"+name+"/"+type+"/"+beginTime+"/"+endTime+"/"+idLoc);
        fetch("manager/event/"+id+"/"+name+"/"+type+"/"+beginTime+":00/"+endTime+":00/"+idLoc, {
            method: "POST"
        }).then(response => response.json().then(json => {
                if (response.ok) {
                    if (json.state === 200) {
                        setSuccess(true);
                    }
                }
            console.log(json);
            }
        ))
    };

    function createData(id, name) {
        return {id, name};
    }

    useEffect(() => {
        fetch("manager/manageList/0", {
            method: "POST"
        }).then(response => response.json().then(json => {
                if (response.ok) {
                    if (json.state === 200) {
                        let data = json.data;
                        let dataRows = [];
                        console.log(data);
                        data.forEach((one_object) => {
                            let row = createData(one_object.person.id, one_object.person.name);
                            dataRows.push(row);
                        })
                        setAthletes(dataRows);
                    }
                }
            }
        ))
        fetch("loc/getAllLoc", {
            method: "POST"
        }).then(response => response.json().then(json => {
                if (response.ok) {
                    if (json.state === 200) {
                        let data = json.data;
                        let dataRows = [];
                        console.log(data);
                        data.forEach((one_object) => {
                            let row = createData(one_object.id, one_object.name);
                            dataRows.push(row);
                        })
                        setLocations(dataRows);
                    }
                }
            }
        ))
    }, [])

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
                Let's add new training for your athlete!
            </Typography>

            <Box component="form" noValidate sx={{mt: 1}}>
                <FormControl fullWidth>
                    <InputLabel>Athletes</InputLabel>
                    <Select
                        label="Athletes"
                        onChange={(e) => setId(e.target.value)}
                    >
                        {athletes.map((row) => (
                            <MenuItem value={row.id}>{row.name}</MenuItem>
                        ))}
                    </Select>
                    <TextField
                        margin="normal"
                        required
                        fullWidth
                        name="name"
                        label="Enter event name"
                        value={name}
                        onChange={(e) => setName(e.target.value)}
                    />
                    <TimeField
                        value={beginTime}
                        onChange={(e, v) => setBeginTime(v)}
                     />
                    <TimeField
                        value={endTime}
                        onChange={(e, v) => setEndTime(v)}
                    />
                </FormControl>
                <FormControl fullWidth>
                    <InputLabel>Locations</InputLabel>
                    <Select
                        label="Location"
                        onChange={(e) => setIdLoc(e.target.value)}
                    >
                        {locations.map((row) => (
                            <MenuItem value={row.id}>{row.name}</MenuItem>
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
    )
}

export default SetNextTrainingResult