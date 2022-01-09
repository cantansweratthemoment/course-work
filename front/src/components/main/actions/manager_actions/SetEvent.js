import React from "react";
import Button from "@mui/material/Button";
import Box from "@mui/material/Box";
import EventIcon from '@mui/icons-material/Event';

function SetEvent() {

    const handleSubmit = (event) => {
        event.preventDefault();

    };

    return (<div id="set_event">
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
                startIcon={<EventIcon/>}
                sx={{ mt: 3, mb: 3 }}>&nbsp;&nbsp;&nbsp;&nbsp;Set Event&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</Button>
        </Box>
    </div>)
}

export default SetEvent