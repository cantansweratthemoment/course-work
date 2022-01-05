import store from "../../../app/store";

function clicked(e, r, setChecks, checks) {
    let r_val = parseFloat(r)
    if (isNaN(r_val)) {
        r_val = 1
    }
    let maslo = document.getElementById('canvas');
    let width = maslo.getAttribute("width");
    let height = maslo.getAttribute("height");
    console.log(width);
    console.log(height);
    let event_x = e.pageX - maslo.offsetLeft;
    let event_y = e.pageY - maslo.offsetTop;
    let x = (event_x - width/2) * r / (width/5*2);
    let y = (height/2 - event_y) * r / (height/5*2);
    const checkNumbers = (q, a, b) => {
        return ((q > a) && (q < b));
    }
    if (checkNumbers(r_val, 0, 3) && checkNumbers(x, -3, 3) && checkNumbers(y, -3, 3)) {
        let information = {
            "login": store.getState().login,
            "x": x,
            "y": y,
            "r": r_val
        };
        let body = [];
        for (const inf in information) {
            body.push(inf + "=" + information[inf]);
        }
        console.log(body);
        body = "?" + body.join("&");
        fetch("/point" + body, {
            method: "POST"
        }).then(response => response.text().then(text => {
            console.log(JSON.parse(text));
            setChecks(JSON.parse(text));
            //props.showChecks();
        }))
    }
}

function drawCanvas(context, r, checks) {
    let maslo = document.getElementById('canvas');
    context.canvas.width = context.canvas.offsetWidth;
    context.canvas.height = context.canvas.offsetHeight;
    let width = context.canvas.width;
    let height = context.canvas.height;
    let r_text = r + "";
    let rhalf_text = r / 2 + "";
    context.clearRect(0, 0, width, height);
    context.fillStyle = "#E8D7FF";
    context.fillRect(width / 5 * 1.5, height / 10, width / 5, height / 5 * 2);
    context.beginPath();
    context.moveTo(width / 2, height / 2);
    context.lineTo(width / 5 * 3.5, height / 5 * 2.5);
    context.lineTo(width / 2, height / 10);
    context.fill();
    context.moveTo(width / 2, height / 2);
    context.arc(width / 2, width / 2, width / 5, Math.PI / 2, Math.PI);
    context.fill();
    context.beginPath();
    context.strokeStyle = "#FF47A0";
    context.lineWidth = 2;
    context.moveTo(0, width / 2);
    context.lineTo(width, height / 2);
    context.stroke();
    context.beginPath();
    context.strokeStyle = "#FF47A0";
    context.lineWidth = 2;
    context.moveTo(width / 2, height);
    context.lineTo(width / 2, 0);
    context.stroke();
    context.strokeText(rhalf_text, width / 5 * 3.5, height / 2);
    context.strokeText(r_text, width / 5 * 4.5, height / 2);
    context.strokeText(rhalf_text, width / 2, height / 5 * 3.5);
    context.strokeText(r_text, width / 2, height / 5 * 4.5);
    context.strokeText(rhalf_text, width / 5 * 1.5, height / 2);
    context.strokeText(rhalf_text, width / 2, height / 5 * 1.5);
    context.strokeText(r_text, width / 2, height / 10);
    context.strokeText(rhalf_text, width / 5 * 3.5, height / 2);
    context.strokeText(r_text, width / 10, height / 2);
    context.strokeText("Y", width / 2, height / 10);
    context.strokeText("X", width / 50 * 49, height / 2);
    drawPoints(r_text, checks, context);
}

function drawPoint(x, y, r, result, rval, context) {
    if ((x !== undefined) && (y !== undefined) && (rval !== undefined) && (r !== undefined)) {
        x = x.replace(",", ".");
        y = y.replace(",", ".");
        rval = rval.replace(",", ".");
        r = r.replace(",", ".")
    }
    let r_valValue = parseFloat(rval);
    let x_Value = parseFloat(x);
    let y_Value = parseFloat(y);
    let r_Value = parseFloat(r);
    let width = context.canvas.width;
    let height = context.canvas.height;
    let finalX = width/2 + x_Value * (width / 5 * 2) / r_valValue;
    let finalY = height/2 - y_Value * (height / 5 * 2) / r_valValue;
    if (result === "false") {
        context.fillStyle = "#FF2A1F";
    } else {
        context.fillStyle = "#5FFF33";
    }
    if (r_Value === r_valValue) {
        context.beginPath();
        context.arc(finalX, finalY, 5, 0, 2 * Math.PI);
        context.fill();
        context.stroke();
        context.closePath();
    }
}

function drawPoints(r, checks, context) {
    if (checks === null) {
        return;
    }
    let coordinates = checks;
    if (coordinates.length === 0) {
        return
    }
    for (let i = 0; i < coordinates.length; i++) {
        drawPoint(coordinates[i]['x'],
            coordinates[i]['y'],
            coordinates[i]['r'], coordinates[i]['result'], r, context);
    }
}

export {drawCanvas, clicked};