const express = require('express')
const createService = require('../Controllers/serviceController')

//create router
const router = express.Router();

router.post('/create', createService)

router.get('/')


//export
module.exports = router