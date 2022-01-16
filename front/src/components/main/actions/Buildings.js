import React from "react";
import Button from "@mui/material/Button";
import Box from "@mui/material/Box";
import ApartmentIcon from '@mui/icons-material/Apartment';

function Buildings(props) {

    const handleSubmit = (event) => {
        props.setAction("buildings");
    };

    return (<div id="buildings">
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
                startIcon={<ApartmentIcon/>}
                sx={{ mt: 3, mb: 3 }}>Buildings&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</Button>
        </Box>
    </div>)
}

export default Buildings