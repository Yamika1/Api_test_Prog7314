require('dotenv').config();


const express = require('express');
const cors = require('cors');
const helmet = require('helmet');
const https = require('https');
const fs = require('fs');
const path = require('path');

const firebase =require('./config/firebase');

const authRoutes = require('./routes/authRoutes');
const errorHandler = require('./middleware/errorHandler'); 

const app = express();

const PORT = process.env.PORT || 5000;
const USE_HTTPS = process.env.USE_HTTPS === 'true';
const CLIENT_ORIGIN = process.env.CLIENT_ORIGIN || 'http://localhost:2000';


app.disable('x-powered-by');

app.use(express.json({ limit: '10kb' }));


app.use(
    helmet({
        contentSecurityPolicy: {
            directives: {
                defaultSrc: ["'self'"],
                scriptSrc: ["'self'"],
                styleSrc: ["'self'"],
                imgSrc: ["'self'", 'data:'],
                connectSrc: ["'self'", CLIENT_ORIGIN],
                objectSrc: ["'none'"],
                baseUri: ["'self'"],
                frameAncestors: ["'none'"]
            }
        },
        crossOriginResourcePolicy: {
            policy: 'same-site'
        }
    })
);

app.use(
    cors({
        origin: CLIENT_ORIGIN,
        methods: ['GET', 'POST', 'PUT', 'DELETE'],
        allowedHeaders: ['Content-Type', 'Authorization']
    })
);

app.get('/', (req, res) => {
    res.status(200).json({
        app: process.env.APP_NAME || 'StudyMateApi',
        message: 'API is running securely'
    });
});


app.get('/health', (req, res) => {
    res.status(200).json({
        status: 'OK',
        protocol: USE_HTTPS ? 'HTTPS' : 'HTTP',
        firebase : 'connected'
    });
});


app.use('/api/auth', authRoutes);


app.post('/message', (req, res) => {
    const { message } = req.body;

    res.status(200).json({
        received: message
    });
});


app.use((req, res) => {
    res.status(404).json({
        error: 'Route not found'
    });
});


if (USE_HTTPS) {

const keyPath = path.join(__dirname, 'certs', 'key.pem');
const certPath = path.join(__dirname, 'certs', 'cert.pem');

    const httpsOptions = {
        key: fs.readFileSync(keyPath),
        cert: fs.readFileSync(certPath)
    };

    https.createServer(httpsOptions, app).listen(PORT, () => {
        console.log(`HTTPS server running on port ${PORT}`);
    });

} else {

    app.listen(PORT, () => {
        console.log(`HTTP server running on port ${PORT}`);
    });

}