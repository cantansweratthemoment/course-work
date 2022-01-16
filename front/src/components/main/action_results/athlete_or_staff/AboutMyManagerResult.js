import React, {useEffect, useState} from "react";
import {Table, TableBody, TableCell, TableContainer, TableHead, TableRow} from "@mui/material";
import Paper from '@mui/material/Paper';
import BackButton from "../BackButton";

function AboutMyManagerResult(props) {
    const [rows, setRows] = useState([]);

    useEffect(() => {
        fetch("normal/showManager", {
            method: "POST"
        }).then(response => response.json().then(json => {
                if (response.ok) {
                    if (json.state === 200) {
                        console.log(json);
                        let data = json.data;
                        let dataRows = [];
                        let row = createData(data.id, data.name);
                        dataRows.push(row);
                        console.log(dataRows);
                        setRows(dataRows);
                    }
                }
            }
        ))
    }, [])

    function createData(id, name) {
        return {id, name};
    }

    return (
        <TableContainer component={Paper} sx={{marginTop: 4}}>
            <BackButton setAction={props.setAction}/>
            <Table sx={{minWidth: 650}} aria-label="simple table">
                <TableHead>
                    <TableRow>
                        <TableCell>ID</TableCell>
                        <TableCell align="right">Name&nbsp;</TableCell>
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
                        </TableRow>
                    ))}
                </TableBody>
            </Table>
        </TableContainer>
    );
}

export default AboutMyManagerResult