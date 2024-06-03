const mongoose = require('mongoose')

const Schema =  mongoose.Schema;

const serviceSchema = new Schema(
    {
      name:{
        type: String,
        required: true
      },
      email:{
        type: String,
        required: true,
        unique: true
      },
      contact:{
        type: String,
        required:true
      },
      v_name:{
        type:String,
        required: true
      },
      v_model:{
        type:String,
        required: true        
      },
      v_brand:{
        type:String,
        required: true
      },
      v_reg_no:{
        type:String,
        required: true
      },
    },{timestamp:true});

const serviceModel = mongoose.model("serviceModel",serviceSchema);

module.exports = serviceModel;