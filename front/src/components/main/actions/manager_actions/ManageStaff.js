import React from "react";
import Button from "@mui/material/Button";
import Box from "@mui/material/Box";
import WorkIcon from '@mui/icons-material/Work';

function ManageStaff(props) {

    const handleSubmit = (event) => {
        props.setAction("manage_staff");
    };

    return (<div id="manage_staff">
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
                startIcon={<WorkIcon/>}
                sx={{ mt: 3, mb: 3 }}>Manage Staff&nbsp;&nbsp;&nbsp;&nbsp;</Button>
        </Box>
    </div>)
}

export default ManageStaff