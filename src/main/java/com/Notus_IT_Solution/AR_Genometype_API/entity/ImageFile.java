package com.Notus_IT_Solution.AR_Genometype_API.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ImageFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String originalFilename;
    private String storedFilename;
    private String downloadUrl;
    private LocalDateTime uploadedAt;

    public ImageFile() {}

    public ImageFile(String originalFilename, String storedFilename, String downloadUrl, LocalDateTime uploadedAt) {
        this.originalFilename = originalFilename;
        this.storedFilename = storedFilename;
        this.downloadUrl = downloadUrl;
        this.uploadedAt = uploadedAt;
    }

    // --- Getters and Setters ---

    public Long getId() { return id; }

    public String getOriginalFilename() { return originalFilename; }

    public void setOriginalFilename(String originalFilename) { this.originalFilename = originalFilename; }

    public String getStoredFilename() { return storedFilename; }

    public void setStoredFilename(String storedFilename) { this.storedFilename = storedFilename; }

    public String getDownloadUrl() { return downloadUrl; }

    public void setDownloadUrl(String downloadUrl) { this.downloadUrl = downloadUrl; }

    public LocalDateTime getUploadedAt() { return uploadedAt; }

    public void setUploadedAt(LocalDateTime uploadedAt) { this.uploadedAt = uploadedAt; }
}