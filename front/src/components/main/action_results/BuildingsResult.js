import React, {useEffect, useState} from "react";
import {
    FormControl,
    InputLabel, MenuItem,
    Select,
    Table,
    TableBody,
    TableCell,
    TableContainer,
    TableHead,
    TableRow
} from "@mui/material";
import Paper from '@mui/material/Paper';
import BackButton from "./BackButton";

function BuildingsResult(props) {
    const [locationRows, setLocationRows] = useState([]);
    const [rows, setRows] = useState([]);

    const handleIdChange = (event) => {
        fetch("loc/"+event.target.value+"/buildings", {
            method: "POST"
        }).then(response => response.json().then(json => {
                if (response.ok) {
                    if (json.state === 200) {
                        let data = json.data;
                        let dataRows = [];
                        data.forEach((one_object) => {
                            let row = createData(one_object.id, one_object.name, one_object.working_time, one_object.end_time);
                            dataRows.push(row);
                        })
                        setRows(dataRows);
                    }
                }
            }
        ))
    };

    useEffect(() => {
        fetch("loc/getAllLoc", {
            method: "POST"
        }).then(response => response.json().then(json => {
                if (response.ok) {
                    if (json.state === 200) {
                        let data = json.data;
                        let dataRows = [];
                        data.forEach((one_object) => {
                            let row = createLocationData(one_object.id, one_object.name);
                            dataRows.push(row);
                        })
                        setLocationRows(dataRows);
                    }
                }
            }
        ))
    }, [])

    function createLocationData(id, name) {
        return {id, name};
    }

    function createData(id, name, workingTime, endTime) {
        return {id, name, workingTime, endTime};
    }

    return (
        <TableContainer component={Paper} sx={{marginTop: 4}}>
            <BackButton setAction={props.setAction}/>
            <FormControl fullWidth>
                <InputLabel id="demo-simple-select-label">Location</InputLabel>
                <Select
                    labelId="demo-simple-select-label"
                    id="demo-simple-select"
                    label="Choose location"
                    onChange={handleIdChange}
                >
                    {locationRows.map((row) => (
                        <MenuItem value={row.id}>{row.name}</MenuItem>
                    ))}
                </Select>
            </FormControl>
            <Table sx={{minWidth: 650}} aria-label="simple table">
                <TableHead>
                    <TableRow>
                        <TableCell>ID</TableCell>
                        <TableCell align="right">Name&nbsp;</TableCell>
                        <TableCell align="right">Working time&nbsp;</TableCell>
                        <TableCell align="right">End time&nbsp;</TableCell>
                    </TableRow>
                </TableHead>
                <TableBody>
                    {rows.map((row) => (
                        <TableRow
                            key={row.name}
                            sx={{'&:last-child td, &:last-child th': {border: 0}}}
                        >
                            <TableCell component="th" scope="row">
                                {row.id}
                            </TableCell>
                            <TableCell align="right">{row.name}</TableCell>
                            <TableCell align="right">{row.workingTime}</TableCell>
                            <TableCell align="right">{row.endTime}</TableCell>
                        </TableRow>
                    ))}
                </TableBody>
            </Table>
        </TableContainer>
    );
}

export default BuildingsResult