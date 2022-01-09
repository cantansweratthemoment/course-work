import React from "react";
import Button from "@mui/material/Button";
import Box from "@mui/material/Box";
import PersonAddIcon from '@mui/icons-material/PersonAdd';

function ManageNewPerson() {

    const handleSubmit = (event) => {
        event.preventDefault();

    };

    return (<div id="manage_new_person">
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
                startIcon={<PersonAddIcon/>}
                sx={{ mt: 3, mb: 3 }}>Manage New Person</Button>
        </Box>
    </div>)
}

export default ManageNewPerson