import React from "react";
import Typography from "@mui/material/Typography";
import Box from "@mui/material/Box";

function Header() {
    return (<div id="mainheader">
        <Box
            sx={{
                marginTop: 8,
                display: 'flex',
                flexDirection: 'column',
                alignItems: 'center',
            }}
        >
            <Typography component="h1" variant="h3">
                Choose your action
            </Typography>
        </Box>
    </div>)
}

export default Header