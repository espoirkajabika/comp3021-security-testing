// Vulnerable JavaScript Code Sample
const express = require('express');
const mysql = require('mysql');
const app = express();

// Hardcoded credentials - SECURITY ISSUE
const dbConfig = {
    host: 'localhost',
    user: 'admin',
    password: 'Password123!',
    database: 'testdb'
};

// SQL Injection vulnerability - SECURITY ISSUE
app.get('/user', (req, res) => {
    const userId = req.query.id;
    const query = `SELECT * FROM users WHERE id = ${userId}`;
    
    connection.query(query, (error, results) => {
        if (error) throw error;
        res.json(results);
    });
});

// XSS vulnerability - SECURITY ISSUE
app.get('/search', (req, res) => {
    const searchTerm = req.query.q;
    res.send(`<h1>Search results for: ${searchTerm}</h1>`);
});

// Command Injection vulnerability - SECURITY ISSUE
const { exec } = require('child_process');
app.get('/ping', (req, res) => {
    const host = req.query.host;
    exec(`ping -c 4 ${host}`, (error, stdout, stderr) => {
        res.send(stdout);
    });
});

// Using eval - SECURITY ISSUE
app.post('/calculate', (req, res) => {
    const expression = req.body.expression;
    const result = eval(expression);
    res.json({ result: result });
});

// Weak cryptography - SECURITY ISSUE
const crypto = require('crypto');
function weakHash(password) {
    return crypto.createHash('md5').update(password).digest('hex');
}

const connection = mysql.createConnection(dbConfig);
app.listen(3000);
