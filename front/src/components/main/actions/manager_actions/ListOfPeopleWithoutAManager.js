import React from "react";
import Button from "@mui/material/Button";
import Box from "@mui/material/Box";
import PeopleIcon from '@mui/icons-material/People';

function ListOfPeopleWithoutAManager() {

    const handleSubmit = (event) => {
        event.preventDefault();

    };

    return (<div id="people_without_a_manager">
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
                startIcon={<PeopleIcon/>}
                sx={{ mt: 3, mb: 3 }}>People Without &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br/> A Manager</Button>
        </Box>
    </div>)
}

export default ListOfPeopleWithoutAManager