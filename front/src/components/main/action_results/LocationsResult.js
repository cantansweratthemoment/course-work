import React, {useState} from "react";
import {Table, TableBody, TableCell, TableContainer, TableHead, TableRow} from "@mui/material";
import Paper from '@mui/material/Paper';
import BackButton from "./BackButton";

function LocationsResult(props) {
    const [rows, setRows] = useState([]);

    function createData(id, name, description) {
        return {id, name, description};
    }

    fetch("loc/getAllLoc", {
        method: "POST"
    }).then(response => response.json().then(json => {
            if (response.ok) {
                if (json.state === 200) {
                    console.log(json);
                    let data = json.data;
                    let dataRows = [];
                    data.forEach((one_object) => {
                        let row = createData(one_object.id, one_object.name, one_object.description);
                        dataRows.push(row);
                    })
                    console.log(dataRows);
                    setRows(dataRows);
                }
            }
        }
    ))

    return (
            <TableContainer component={Paper} sx={{marginTop: 4}}>
                <BackButton setAction = {props.setAction}/>
                <Table sx={{minWidth: 650}} aria-label="simple table">
                    <TableHead>
                        <TableRow>
                            <TableCell>ID</TableCell>
                            <TableCell align="right">Name&nbsp;</TableCell>
                            <TableCell align="right">Description&nbsp;</TableCell>
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
                                <TableCell align="right">{row.description}</TableCell>
                            </TableRow>
                        ))}
                    </TableBody>
                </Table>
            </TableContainer>
    );
}

export default LocationsResult