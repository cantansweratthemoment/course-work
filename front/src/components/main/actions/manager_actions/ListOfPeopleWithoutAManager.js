import React from "react";
import Button from "@mui/material/Button";
import Box from "@mui/material/Box";
import PeopleIcon from '@mui/icons-material/People';

function ListOfPeopleWithoutAManager(props) {

    const handleSubmit = (event) => {
        props.setAction("list_of_people_without_a_manager");
    };

    return (<div id="people_without_a_manager">
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
                startIcon={<PeopleIcon/>}
                sx={{ mt: 3, mb: 3 }}>People Without &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br/> A Manager</Button>
        </Box>
    </div>)
}

export default ListOfPeopleWithoutAManager