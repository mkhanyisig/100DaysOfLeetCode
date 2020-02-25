/**
    Mkhanyisi Gamedze
    Kumba Africa
    Cloud Functions task
    Langauage: Typescript
    
    Writing three different Cloud functions
    
    07 Feb 2020
**/

// Imports
import * as functions from 'firebase-functions';

import * as Storage from '@google-cloud/storage';
const gcs = Storage();

import { tmpdir } from 'os';
import { join, dirname, basename } from 'path';

import * as sharp from 'sharp';
import * as fs from 'fs-extra';

import { request } from 'http';
import sizeOf from 'image-size';



// Cloud function
// triggered in response to the uploading, updating, or deleting of a file
export const generateThumbs = functions.storage
  .object()  // Alternatively for specific bucket: .bucket('bucketName')
    .onFinalize(async object => { // Only triggered when new object is succesfully created in bucket

    // bucket detail and filepath detail
    const bucket = gcs.bucket(object.bucket); // The Storage bucket that contains the file.
    const filePath = object.name;
    const fileName = filePath.split('/').pop(); // only get last path, filename
    const contentType = object.contentType; // File content type.
    const bucketDir = dirname(filePath);

    // temporary directory
    const workingDir = join(tmpdir(), 'thumbs');
    // copy file into working directory
    const tmpFilePath = join(workingDir, 'source.png');

    if (fileName.includes('thumb@') || !object.contentType.includes('image')) {
      console.log('exiting function: conditions not met');
      return false;
    }

    /**
        Main code to do resizing within directory
    **/


    // 1. Ensure thumbnail dir exists
    await fs.ensureDir(workingDir);

    // 2. Download Source File
    await bucket.file(filePath).download({
      destination: tmpFilePath
    });

    // 3. Resize the images and define an array of upload promises
        // ***** SPECIFY DIMENSIONS HERE
        const sizes = [[90,90],[128,128],[256,256]];

    const uploadPromises = sizes.map(async size => {
    const thumbName = `thumb@${size}_${fileName}`;
    const thumbPath = join(workingDir, thumbName);

    // Resize source image
    await sharp(tmpFilePath)
        .resize(size[0], size[1])
        .toFile(thumbPath);

      // Upload to GCS
      return bucket.upload(thumbPath, {
        destination: join(bucketDir, thumbName)
      });
    });

    // 4. Run the upload operations
    await Promise.all(uploadPromises);

    // 5. Cleanup remove the tmp/thumbs from the filesystem
    return fs.remove(workingDir);
  });


/*
	Mkhanyisi
		**  Modification 2.0 **
	** Take advantage of firebase extensions for Cloud functions
	
	Specifications (Ayyoob 02/09 Kumba)
		> image returned in specific format upon request, return download link
		> specify dimensions
		> given download URL
		> function triggered upon request
		> Quality: check if it exists in dimensions, if not, create new image and create new link
		> 

*/

  
// Inspired by this link
// https://stackoverflow.com/questions/56370606/how-to-get-the-dimensions-of-an-image-from-firebase-storage-in-firebase-function


// bucket directory (will be modified)
const FIRE = 'https://firebasestorage.googleapis.com/file....'
// filename
const FILE = 'file.jpg';

// original function code
request.head(FIRE, (err, res, body) => {
        request(FIRE)
            .pipe(fs.createWriteStream(FILE))
            .on('close', () => {
                sizeOf(FILE, (err1, dimensions) => {
                    const result = {
                        "width": dimensions.width,
                        "height": dimensions.height
                    }
                    console.log(dimensions.width, dimensions.height);
                    // do processing here on request
                    fs.unlinkSync(FILE);
                    response.setHeader('Content-Type', 'application/json');
                    const responseData = {
                        'Error': false,
                        'Message': "result : " + result
                    };
                    response.send(JSON.stringify(responseData));
                })
            })
})
  
// modified Code


// resize function in TS
// User Input   => conditions handled here
// morning => link methods above and right buckets to meet specifics
function resizeImage(file:File, maxWidth:number, maxHeight:number):Promise<Blob> {
    return new Promise((resolve, reject) => {
        let image = new Image();
        
        // get url
        
        image.src = URL.createObjectURL(file);
        image.onload = () => {
            let width = image.width;
            let height = image.height;
            
            if (width <= maxWidth && height <= maxHeight) {
                resolve(file);
            }

            let newWidth;
            let newHeight;

            if (width > height) {
                newHeight = height * (maxWidth / width);
                newWidth = maxWidth;
            } else {
                newWidth = width * (maxHeight / height);
                newHeight = maxHeight;
            }

            let canvas = document.createElement('canvas');
            canvas.width = newWidth;
            canvas.height = newHeight;

            let context = canvas.getContext('2d');

            context.drawImage(image, 0, 0, newWidth, newHeight);

            canvas.toBlob(resolve, file.type);
        };
        image.onerror = reject;
    });
}


// Modified Cloud function to be exported Code
// main function inputs, needs to be modified then code reviewed  
const link = "https://www.kumbafrica.co/images/aboutus/selfie1.jpg";
const filename=link.split('/').pop();
const rawfilename=filename.split('.').pop();
reqWidth = 120;
reqHeight = 120;

/*  Main function  untested */  
/*
	




*/



// Second function triggered on request, export to Firebase
export const req = request.head(link, (err, res, body) => {
        request(link)
            .pipe(fs.createWriteStream(filename))
            .on('close', () => {
            
            Promise<Blob>{ 
            	return new Promise((resolve, reject) => {
            	
            	
            	// The Storage bucket that contains the file.
            	const bucket = gcs.bucket(link.split('/').shift());  // get link to bucket directory in GCS
        		// bucket name
        		const bucketDir = dirname(link);
            	
            	const bucket = gcs.bucket(object.bucket); 
            	
            	
            	// Resizing
            	let image = new Image();
            	
            	image.src = URL.createObjectURL(link);
            	
            	image.onload = () => {
					let width = image.width;
					let height = image.height;
					
					// if file exists in size within bucket
					// bucket contains filename in this size
					if (fileName.includes('@{reqWidth}') && fileName.includes('@{reqHeight}')) {
      					console.log('exiting function: file already in that size');
      					return false;
    				}
    				else{
    					resolve(link); // resize
    				}
					// create new filename
					let prefix= filename.split("_").shift();   // assuming filenames will be in format [name_ width x height]
					let thumbName = prefix+"_ @{reqWidth}x@{reqHeight}";

					let canvas = document.createElement('canvas');
					canvas.width = reqWidth;
					canvas.height = reqHeight;

					let context = canvas.getContext('2d');
					
					// draw new image and resizes
					context.drawImage(image, 0, 0, reqWidth, reqHeight);
					// resolve image to blob
					canvas.toBlob(resolve, link.type);
					
					
					// return link to file
					// add image to bukcet in new dimensions
					return bucket.upload(thumbPath, {
						bucketDir: join(bucketDir, thumbName)
					});
        		};
        		image.onerror = reject;
                
                }
                }
            })
})



