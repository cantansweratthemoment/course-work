import React from "react";
import Button from "@mui/material/Button";
import Box from "@mui/material/Box";
import WorkIcon from '@mui/icons-material/Work';

function ManageStaff() {

    const handleSubmit = (event) => {
        event.preventDefault();

    };

    return (<div id="manage_staff">
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
                startIcon={<WorkIcon/>}
                sx={{ mt: 3, mb: 3 }}>Manage Staff&nbsp;&nbsp;&nbsp;&nbsp;</Button>
        </Box>
    </div>)
}

export default ManageStaff