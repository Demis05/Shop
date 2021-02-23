const AWS = require('aws-sdk');
AWS.config.update({accessKeyId: 'AKIA35Y2MPKISBLUGXWU', secretAccessKey: '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',
region: 'us-east-2'});
const s3 = new AWS.S3();

var getParams = {
 Bucket: 'exadel.shop.bucket',
Key: 'storeFiles/images/default_image.jpeg' // path to the object you're looking for
}

//IMAGE_FOLDER_PATH = "storeFiles/images/";
function testing(path){
console.log(path)

//s3.listObjects(params, function (err, data) {
// if(err)throw err;
// console.log(data);
//});

}