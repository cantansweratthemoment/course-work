import React from "react";
import {DataTable} from "primereact/datatable";
import {Column} from "primereact/column";
import {Button} from "primereact/button";
import 'primereact/resources/themes/md-light-deeppurple/theme.css';

function Resulttable(props) {

    return (
        <DataTable id="resultTable" value={props.checks}>
            < Column header="X" field="x"/>
            <Column header="Y" field="y"/>
            <Column header="R" field="r"/>
            <Column header="Hit or miss?" field="result"/>
        </DataTable>
    )
}

export default Resulttable;