package com.api.book.bootrestbook.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.api.book.bootrestbook.Helper.FileUplodHelper;

@RestController
public class FIleUploadController {
    
    @Autowired
    private FileUplodHelper fileUplodHelper;
   
    @PostMapping("/upload-file")
    public ResponseEntity<String> fileUploading(@RequestParam("file") MultipartFile file){
        // System.out.println(file.getOriginalFilename());
        // System.out.println(file.getSize());
        // System.out.println(file.getContentType());
        // System.out.println(file.getName());

        //Validatation
        try {
            
            if (file.isEmpty()) {
            
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must contain file");
        }

          if (!file.getContentType().equals("image/jpeg")) {
            
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Only JPEG contain Type are allowed");
        }

         //File Upload Code...
         boolean f = fileUplodHelper.uplodFile(file);
         if (f) {
            //return ResponseEntity.ok("File uploaded sucessfully");
            return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(file.getOriginalFilename()).toUriString());
         }

        } catch (Exception e) {
           e.printStackTrace();


        }
        
       return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("something went worng ! Try again");
    }
    
}
