import React from "react";
import Button from "@mui/material/Button";
import Box from "@mui/material/Box";
import LocationOnIcon from '@mui/icons-material/LocationOn';

function Locations(props) {

    const handleSubmit = (event) => {
        props.setAction("locations");
    };

    return (<div id="locations">
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
                startIcon={<LocationOnIcon/>}
                sx={{ mt: 3, mb: 3 }}>Locations &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</Button>
        </Box>
    </div>)
}

export default Locations