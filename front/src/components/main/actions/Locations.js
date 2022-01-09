import React from "react";
import Button from "@mui/material/Button";
import Box from "@mui/material/Box";
import LocationOnIcon from '@mui/icons-material/LocationOn';

function Locations() {

    const handleSubmit = (event) => {
        event.preventDefault();

    };

    return (<div id="locations">
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
                startIcon={<LocationOnIcon/>}
                sx={{ mt: 3, mb: 3 }}>Locations &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</Button>
        </Box>
    </div>)
}

export default Locations