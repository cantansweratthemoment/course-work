import React from "react";
import Button from "@mui/material/Button";
import EventNoteIcon from '@mui/icons-material/EventNote';
import Box from "@mui/material/Box";

function MyEvents(props) {
    const handleSubmit = (event) => {
        props.setAction("my_events");
    };

    return (<div id="my_events">
        <Box
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
                onClick={handleSubmit}
                startIcon={<EventNoteIcon/>}
                sx={{ mt: 3, mb: 3 }}>My Events &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</Button>
        </Box>
    </div>)
}

export default MyEvents