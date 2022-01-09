import React from "react";
import Button from "@mui/material/Button";
import Box from "@mui/material/Box";
import ApartmentIcon from '@mui/icons-material/Apartment';

function Buildings() {

    const handleSubmit = (event) => {
        event.preventDefault();

    };

    return (<div id="buildings">
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
                startIcon={<ApartmentIcon/>}
                sx={{ mt: 3, mb: 3 }}>Buildings&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</Button>
        </Box>
    </div>)
}

export default Buildings