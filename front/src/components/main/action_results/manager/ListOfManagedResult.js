import React, {useEffect, useState} from "react";
import {
    FormControlLabel, Stack,
    styled,
    Switch,
    Table,
    TableBody,
    TableCell,
    TableContainer,
    TableHead,
    TableRow
} from "@mui/material";
import Paper from '@mui/material/Paper';
import BackButton from "../BackButton";
import Typography from "@mui/material/Typography";
import * as PropTypes from "prop-types";

function GreenSwitch(props) {
    return null;
}

let switchValue = 0;

GreenSwitch.propTypes = {defaultChecked: PropTypes.bool};

function ListOfManagedResult(props) {

    const [rows0, setRows0] = useState([]);
    const [rows1, setRows1] = useState([]);
    const [meow, setMeow] = useState("");

    const handleSwitchChange = e => {
        if (switchValue) {
            switchValue = 0;
        } else {
            switchValue = 1;
        }
        setMeow([]);
    }

    function createData(id, name) {
        return {id, name};
    }

    useEffect(() => {
        fetch("manager/manageList/0", {
            method: "POST"
        }).then(response => response.json().then(json => {
                if (response.ok) {
                    if (json.state === 200) {
                        console.log(json);
                        let ddata = json.data;
                        let dataRows = [];
                        let data = ddata.filter(function (e) {
                            return e != null;
                        });
                        console.log(data);
                        data.forEach((one_object) => {
                            let row = createData(one_object.id, one_object.person.name);
                            dataRows.push(row);
                        })
                        setRows0(dataRows);
                    }
                }
            }
        ))
        fetch("manager/manageList/1", {
            method: "POST"
        }).then(response => response.json().then(json => {
                if (response.ok) {
                    if (json.state === 200) {
                        console.log(json);
                        let ddata = json.data;
                        let dataRows = [];
                        let data = ddata.filter(function (e) {
                            return e != null;
                        });
                        console.log(data);
                        data.forEach((one_object) => {
                            let row = createData(one_object.id, one_object.person.name);
                            dataRows.push(row);
                        })
                        setRows1(dataRows);
                    }
                }
            }
        ))
    }, [])

    if (switchValue) {
        return (
            <TableContainer component={Paper} sx={{marginTop: 4}}>
                <BackButton setAction={props.setAction}/>
                <Stack direction="row" spacing={1} alignItems="center">
                    <Typography>Athletes</Typography>
                    <Switch onChange={handleSwitchChange} defaultChecked/>
                    <Typography>Staff</Typography>
                </Stack>
                <Table sx={{minWidth: 650}} aria-label="simple table">
                    <TableHead>
                        <TableRow>
                            <TableCell>ID</TableCell>
                            <TableCell align="right">Name&nbsp;</TableCell>
                        </TableRow>
                    </TableHead>
                    <TableBody>
                        {rows1.map((row) => (
                            <TableRow
                                key={row.name}
                                sx={{'&:last-child td, &:last-child th': {border: 0}}}
                            >
                                <TableCell component="th" scope="row">
                                    {row.id}
                                </TableCell>
                                <TableCell align="right">{row.name}</TableCell>
                            </TableRow>
                        ))}
                    </TableBody>
                </Table>
            </TableContainer>
        );
    } else {
        return (
            <TableContainer component={Paper} sx={{marginTop: 4}}>
                <BackButton setAction={props.setAction}/>
                <Stack direction="row" spacing={1} alignItems="center">
                    <Typography>Athletes</Typography>
                    <Switch onChange={handleSwitchChange} defaultChecked/>
                    <Typography>Staff</Typography>
                </Stack>
                <Table sx={{minWidth: 650}} aria-label="simple table">
                    <TableHead>
                        <TableRow>
                            <TableCell>ID</TableCell>
                            <TableCell align="right">Name&nbsp;</TableCell>
                        </TableRow>
                    </TableHead>
                    <TableBody>
                        {rows0.map((row) => (
                            <TableRow
                                key={row.name}
                                sx={{'&:last-child td, &:last-child th': {border: 0}}}
                            >
                                <TableCell component="th" scope="row">
                                    {row.id}
                                </TableCell>
                                <TableCell align="right">{row.name}</TableCell>
                            </TableRow>
                        ))}
                    </TableBody>
                </Table>
            </TableContainer>
        );
    }
}

export default ListOfManagedResult