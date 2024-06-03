const Service = require('../Models/serviceModel');

const createService = async (req, res) => {
    try {
        // Extract service data from request body
        const {name, email, contact, v_name, v_model, v_brand, v_reg_no } = req.body;

        // Validate input
        if (!name || !email || !contact || !v_name || !v_model || !v_brand || !v_reg_no) {
            return res.status(400).json({
                message: 'All fields are required'
            });
        }

        // Create new Service instance
        const newService = new Service({ name, email, contact, v_name, v_model, v_brand, v_reg_no});

        // Save issue to database
        const savedService = await newService.save();

        // console.log('Received service issue:');        
               
        // Return success response
        res.status(201).json({
            message: 'Service requested successfully', savedService
        });
    } catch (error) {
        console.error(error);
        res.status(500).json({
            message: "Error occurred..."
        })
    }
}


module.exports = createService;