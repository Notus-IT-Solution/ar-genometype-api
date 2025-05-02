package com.Notus_IT_Solution.AR_Genometype_API.dto;

public class UploadResponse {
    public String imageUrl;
    public String qrCodeBase64;

    public UploadResponse(String imageUrl, String qrCodeBase64) {
        this.imageUrl = imageUrl;
        this.qrCodeBase64 = qrCodeBase64;
    }
}