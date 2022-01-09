import React from "react";
import Button from "@mui/material/Button";
import InfoIcon from '@mui/icons-material/Info';
import Box from "@mui/material/Box";

function AboutMyManager() {

    const handleSubmit = (event) => {
        event.preventDefault();

    };

    return (<div id="about_my_manager">
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
                startIcon={<InfoIcon/>}
                sx={{ mt: 3, mb: 3 }}>About My &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br/> Manager &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</Button>
        </Box>
    </div>)
}

export default AboutMyManager