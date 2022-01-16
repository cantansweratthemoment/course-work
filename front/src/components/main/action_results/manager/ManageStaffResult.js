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

function ManageStaffResult(props) {
    const [managedStaff, setManagedStaff] = useState([]);
    const [staffId, setStaffId] = useState("");
    const [success, setSuccess] = useState(false);
    const [locations, setLocations] = useState([]);
    const [locId, setLocId] = useState([]);

    const handleIdChange = (event) => {
        setStaffId(event.target.value);
    };

    const handleLocChange = (event) => {
        setLocId(event.target.value);
    };

    const handle = (event) => {
        event.preventDefault();
        setSuccess(false);
        fetch("setLBId/"+staffId+"/"+locId+"//test", {
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
        fetch("manager/manageList/1", {
            method: "POST"
        }).then(response => response.json().then(json => {
                if (response.ok) {
                    if (json.state === 200) {
                        console.log(json);
                        let data = json.data;
                        let dataRows = [];
                        data.forEach((one_object) => {
                            let row = createStaffData(one_object.id, one_object.person.name);
                            dataRows.push(row);
                        })
                        console.log(dataRows);
                        setManagedStaff(dataRows);
                    }
                }
            }
        ))
        fetch("loc/getAllLoc", {
            method: "POST"
        }).then(response => response.json().then(json => {
                if (response.ok) {
                    if (json.state === 200) {
                        console.log(json);
                        let data = json.data;
                        let dataRows = [];
                        data.forEach((one_object) => {
                            let row = createLocationsData(one_object.id, one_object.name);
                            dataRows.push(row);
                        })
                        console.log(dataRows);
                        setLocations(dataRows);
                    }
                }
            }
        ))
    }, [])

    function createStaffData(id, name) {
        return {id, name};
    }

    function createLocationsData(id, name) {
        return {id, name};
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
            <Typography component="h4" variant="h10">
                Who do you want to manage?
            </Typography>

            <Box component="form" noValidate sx={{mt: 1}}>
                <FormControl fullWidth>
                    <InputLabel id="demo-simple-select-label">My Staff</InputLabel>
                    <Select
                        labelId="demo-simple-select-label"
                        id="demo-simple-select"
                        label="Location"
                        onChange={handleIdChange}
                    >
                        {managedStaff.map((row) => (
                            <MenuItem value={row.id}>{row.name}</MenuItem>
                        ))}
                    </Select>
                    <Select
                        labelId="demo-simple-select-label"
                        id="demo-simple-select"
                        label="Location"
                        onChange={handleLocChange}
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
    );
}

export default ManageStaffResult