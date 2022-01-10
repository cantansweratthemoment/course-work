import React from "react";
import Button from "@mui/material/Button";
import EventNoteIcon from '@mui/icons-material/EventNote';
import Box from "@mui/material/Box";

function MyEvents(props) {
    const handleSubmit = (event) => {
        event.preventDefault();
        let information = {
            "login": props.login
        };
        let body = [];
        for (const inf in information) {
            body.push(inf + "=" + information[inf]);
        }
        console.log(body);
        body = "?" + body.join("&");
        fetch("/my_events" + body, {
            method: "POST"
        }).then(response => response.json().then(json => {
                if (response.ok) {
                    console.log(json)
                }
            }
        ))
    };

    return (<div id="my_events">
        <Box onSubmit={handleSubmit}
            sx={{
                marginTop: 3,
                display: 'flex',
                flexDirection: 'column',
                alignItems: 'center',
            }}
        >
        <Button variant="outlined"
                type="submit"
                color="secondary"
                size = "large"
                startIcon={<EventNoteIcon/>}
                sx={{ mt: 3, mb: 3 }}>My Events &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</Button>
        </Box>
    </div>)
}

export default MyEvents