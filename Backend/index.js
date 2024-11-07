require("dotenv").config();
const express = require('express');

const port = process.env.port;
const app = express();


// Endpoint
app.get('/status', (req, res) => {
    res.status(200).json({ 
        success: true,
        message: "server is running",
        payload: "test"
    });
});


app.listen(port, () => {
    console.log("🚀 Server is running and listening on port", port);
});