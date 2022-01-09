import React from "react";
import Button from "@mui/material/Button";
import EventNoteIcon from '@mui/icons-material/EventNote';
import Box from "@mui/material/Box";

function MyEvents() {

    const handleSubmit = (event) => {
        event.preventDefault();

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