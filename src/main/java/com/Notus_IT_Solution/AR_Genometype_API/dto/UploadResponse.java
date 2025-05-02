package com.Notus_IT_Solution.AR_Genometype_API.dto;

public class UploadResponse {

    private String imageUrl;
    private String qrCodeBase64;

    public UploadResponse(String imageUrl, String qrCodeBase64) {
        this.imageUrl = imageUrl;
        this.qrCodeBase64 = qrCodeBase64;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getQrCodeBase64() {
        return qrCodeBase64;
    }

    public void setQrCodeBase64(String qrCodeBase64) {
        this.qrCodeBase64 = qrCodeBase64;
    }
}
