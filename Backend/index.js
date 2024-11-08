require("dotenv").config();
const express = require('express');

const accountRepo = require('./repositories/repository.account');

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

// Account
app.post('/register', accountRepo.registerAccount);
app.post('/login', accountRepo.loginAccount);
app.put('/editAccount', accountRepo.editAccount);
app.get('/getAccounts', accountRepo.getAccounts);
app.post('/getAccountById', accountRepo.getAccountById);
app.delete('/deleteAccount', accountRepo.deleteAccount);


app.listen(port, () => {
    console.log("🚀 Server is running and listening on port", port);
});