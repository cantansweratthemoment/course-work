import React from "react";

export default function Heading() {
    const styles = {
        h2: {
            fontFamily: "Roboto",
            fontWeight: "Bold",
            fontSize: "100%",
            color: "black",
            backgroundColor: "#f1faee"
        }
    }
    return (
        <h2 style={styles.h2} align="center" id="authors">Mike Lavlinskiy and Olga Ilinskaya production, var. 67125, P3214</h2>
    )
}