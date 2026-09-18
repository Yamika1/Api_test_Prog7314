const admin = require('firebase-admin');
const serviceAccount = require('../serviceAccountKey.json');

admin.initializeApp({
    credentials: admin.credentials.cert(serviceAccount)
});

module.exports = admin;