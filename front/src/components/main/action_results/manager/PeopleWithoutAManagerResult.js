import React, {useEffect, useState} from "react";
import {Table, TableBody, TableCell, TableContainer, TableHead, TableRow} from "@mui/material";
import Paper from '@mui/material/Paper';
import BackButton from "../BackButton";

function PeopleWithoutAManagerResult(props) {
    const [rows, setRows] = useState([]);

    useEffect(() => {
        fetch("manager/noManagerInfo", {
            method: "POST"
        }).then(response => response.json().then(json => {
                if (response.ok) {
                    if (json.state === 200) {
                        let data = json.data;
                        let dataRows = [];
                        data.forEach((one_object) => {
                            let type = "Staff";
                            if (one_object.role === 0) {
                                type = "Athlete";
                            }
                            let row = createData(one_object.person.id, one_object.person.name, type);
                            dataRows.push(row);
                        })
                        setRows(dataRows);
                    }
                }
            }
        ))
    }, [])

    function createData(id, name, type) {
        return {id, name, type};
    }

    return (
        <TableContainer component={Paper} sx={{marginTop: 4}}>
            <BackButton setAction={props.setAction}/>
            <Table sx={{minWidth: 650}} aria-label="simple table">
                <TableHead>
                    <TableRow>
                        <TableCell>ID</TableCell>
                        <TableCell align="right">Name&nbsp;</TableCell>
                        <TableCell align="right">Type&nbsp;</TableCell>
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
                            <TableCell align="right">{row.type}</TableCell>
                        </TableRow>
                    ))}
                </TableBody>
            </Table>
        </TableContainer>
    );
}

export default PeopleWithoutAManagerResult