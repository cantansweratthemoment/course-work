import React from "react";
import Button from "@mui/material/Button";
import InfoIcon from '@mui/icons-material/Info';
import Box from "@mui/material/Box";

function AboutMyManager(props) {

    const handleSubmit = (event) => {
        props.setAction("about_my_manager");
    };

    return (<div id="about_my_manager">
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
                onClick = {handleSubmit}
                startIcon={<InfoIcon/>}
                sx={{ mt: 3, mb: 3 }}>About My &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br/> Manager &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</Button>
        </Box>
    </div>)
}

export default AboutMyManager