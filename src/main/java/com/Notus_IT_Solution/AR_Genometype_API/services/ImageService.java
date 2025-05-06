package com.Notus_IT_Solution.AR_Genometype_API.services;
import com.Notus_IT_Solution.AR_Genometype_API.entity.ImageFile;
import com.Notus_IT_Solution.AR_Genometype_API.repository.ImageFileRepository;
import com.google.zxing.*;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class ImageService {

    private String uploadDir;
    private final ImageFileRepository imageFileRepository;
    
    @Autowired
    public ImageService(@Value("${image.upload-dir}") String uploadDir, ImageFileRepository imageFileRepository) {
        this.uploadDir = uploadDir;
        this.imageFileRepository = imageFileRepository;
    }
    // public ImageService(ImageFileRepository imageFileRepository) {
    //     this.imageFileRepository = imageFileRepository;
    // }

    public String saveImage(MultipartFile file) throws IOException {
        String originalFilename = StringUtils.cleanPath(file.getOriginalFilename());
        String storedFilename = UUID.randomUUID() + "-" + originalFilename;

        Path uploadPath = Paths.get(uploadDir);
        if (!Files.exists(uploadPath)) Files.createDirectories(uploadPath);

        Path filePath = uploadPath.resolve(storedFilename);
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        String downloadUrl = "http://203.154.105.81:10000/download/" + storedFilename;

        ImageFile imageFile = new ImageFile(
                originalFilename,
                storedFilename,
                downloadUrl,
                LocalDateTime.now()
        );
        imageFileRepository.save(imageFile);

        return storedFilename;
    }

    public byte[] generateQRCode(String url) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix matrix = qrCodeWriter.encode(url, BarcodeFormat.QR_CODE, 300, 300);
        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            MatrixToImageWriter.writeToStream(matrix, "PNG", out);
            return out.toByteArray();
        }
    }
}