const admin = require('firebase-admin');
const serviceAccount = require('../serviceAccountKey.json');

admin.initializeApp({
    credentials: admin.credentials.cert(serviceAccount)
});

console.log('Firebase connected successfully');

module.exports = admin;