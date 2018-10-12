package net.test.controllers;

import org.apache.tomcat.util.http.fileupload.disk.DiskFileItem;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

@RestController
public class FileUploadController {

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public String Upload(HttpServletRequest request) throws IOException {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession()
                .getServletContext());
        if (multipartResolver.isMultipart(request)) {

            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;

            Iterator<String> iter = multiRequest.getFileNames();
            while (iter.hasNext()) {

                MultipartFile multipartFile = multiRequest.getFile(iter.next());
                if (multipartFile != null) {
                    String fileName = multipartFile.getOriginalFilename();
                    if (fileName.trim() != null && fileName.trim().length() > 0) {
//                        CommonsMultipartFile cf = (CommonsMultipartFile) multipartFile;
//                        DiskFileItem fi = (DiskFileItem) cf.getFileItem();
//                        File tempFile = fi.getStoreLocation();
                        byte[] buffer=multipartFile.getBytes();
                        return String.valueOf(buffer.length);

                    }
                }
            }
        }
       return "---";
    }
}
