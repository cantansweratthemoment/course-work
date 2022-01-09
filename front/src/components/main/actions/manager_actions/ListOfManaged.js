import React from "react";
import Button from "@mui/material/Button";
import Box from "@mui/material/Box";
import RecordVoiceOverIcon from '@mui/icons-material/RecordVoiceOver';

function ListOfManaged() {

    const handleSubmit = (event) => {
        event.preventDefault();

    };

    return (<div id="list_of_managed">
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
                startIcon={<RecordVoiceOverIcon/>}
                sx={{ mt: 3, mb: 3 }}>List Of Managed</Button>
        </Box>
    </div>)
}

export default ListOfManaged