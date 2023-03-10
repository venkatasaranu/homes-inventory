package com.sumeer.homes.inventory.controller;

import com.sumeer.homes.inventory.domain.ResponseMessage;
import com.sumeer.homes.inventory.service.FileUploadService;
import com.sumeer.homes.inventory.util.ExcelHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Venkata Saranu
 */
@Controller
@CrossOrigin
@RequestMapping("/inventory/excel")
public class HomeInventoryUploadController {
    @Autowired
    private FileUploadService fileUploadService;
    @PostMapping("/upload")
    public ResponseMessage uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";
        if (ExcelHelper.hasExcelFormat(file)) {
            try {
                fileUploadService.save(file);
                message = "Uploaded the file successfully: " + file.getOriginalFilename();
                return new ResponseMessage(message);
            } catch (Exception e) {
                message = "Could not upload the file: " + file.getOriginalFilename() + "!";
                return new ResponseMessage(message);
            }
        }
        message = "Please upload an excel file!";
        return new ResponseMessage(message);
    }
}
