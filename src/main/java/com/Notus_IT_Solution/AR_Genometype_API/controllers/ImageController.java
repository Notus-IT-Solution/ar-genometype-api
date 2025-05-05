package com.Notus_IT_Solution.AR_Genometype_API.controllers;

import com.Notus_IT_Solution.AR_Genometype_API.dto.UploadResponse;
import com.Notus_IT_Solution.AR_Genometype_API.services.ImageService;
import com.google.zxing.WriterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.util.Base64;

@RestController
public class ImageController {

    private final ImageService imageService;

    @Value("${image.upload-dir}")
    private String uploadDir;

    @Autowired
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping("/upload")
    public ResponseEntity<UploadResponse> uploadImage(@RequestParam("file") MultipartFile file) throws IOException, WriterException {
        String savedFilename = imageService.saveImage(file);
        String imageUrl = "http://localhost:8080/download/" + savedFilename;
        byte[] qrCode = imageService.generateQRCode(imageUrl);
        String base64Qr = Base64.getEncoder().encodeToString(qrCode);

        return ResponseEntity.ok(new UploadResponse(imageUrl, base64Qr));
    }

    @GetMapping("/download/{filename:.+}")
    public ResponseEntity<Resource> downloadImage(@PathVariable String filename) throws IOException {
        File file = new File(uploadDir + "/" + filename);
        if (!file.exists()) return ResponseEntity.notFound().build();

        Resource resource = new FileSystemResource(file);
        String contentType = Files.probeContentType(file.toPath());

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .body(resource);
    }
}
