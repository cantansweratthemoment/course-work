import React, {useEffect, useState} from "react";
import {Table, TableBody, TableCell, TableContainer, TableHead, TableRow} from "@mui/material";
import Paper from '@mui/material/Paper';
import BackButton from "../BackButton";

function MyEventsResult(props) {
    const [rows, setRows] = useState([]);

    useEffect(() => {
        fetch("normal/showEvent", {
            method: "POST"
        }).then(response => response.json().then(json => {
                if (response.ok) {
                    if (json.state === 200) {
                        console.log(json);
                        let data = json.data;
                        let dataRows = [];
                        data.forEach((one_object) => {
                            let row = createData(one_object.name, one_object.type, one_object.begin_time, one_object.end_time, one_object.location.name);
                            dataRows.push(row);
                        })

                        console.log(dataRows);
                        setRows(dataRows);
                    }
                }
            }
        ))
    }, [])

    function createData(name, type, beginTime, endTime, locationName) {
        return {name, type, beginTime, endTime, locationName};
    }

    return (
        <TableContainer component={Paper} sx={{marginTop: 4}}>
            <BackButton setAction={props.setAction}/>
            <Table sx={{minWidth: 650}} aria-label="simple table">
                <TableHead>
                    <TableRow>
                        <TableCell>Name</TableCell>
                        <TableCell align="right">Type&nbsp;</TableCell>
                        <TableCell align="right">Begin time&nbsp;</TableCell>
                        <TableCell align="right">End time&nbsp;</TableCell>
                        <TableCell align="right">Location&nbsp;</TableCell>
                    </TableRow>
                </TableHead>
                <TableBody>
                    {rows.map((row) => (
                        <TableRow
                            key={row.name}
                            sx={{'&:last-child td, &:last-child th': {border: 0}}}
                        >
                            <TableCell component="th" scope="row">
                                {row.name}
                            </TableCell>
                            <TableCell align="right">{row.type}</TableCell>
                            <TableCell align="right">{row.beginTime}</TableCell>
                            <TableCell align="right">{row.endTime}</TableCell>
                            <TableCell align="right">{row.locationName}</TableCell>
                        </TableRow>
                    ))}
                </TableBody>
            </Table>
        </TableContainer>
    );
}

export default MyEventsResult