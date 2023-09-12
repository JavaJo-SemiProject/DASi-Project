package com.ohgiraffers.thymeleafspringboot.board.dto;

public class AttachmentDTO {
    private Long no;
    private Long refBoardNo;
    private String originalName;
    private String savedName;
    private String savePath;
    private String fileType;
    private String thumbnailPath;
    private String status;

    public AttachmentDTO() {
    }

    public AttachmentDTO(Long no, Long refBoardNo, String originalName, String savedName, String savePath, String fileType, String thumbnailPath, String status) {
        this.no = no;
        this.refBoardNo = refBoardNo;
        this.originalName = originalName;
        this.savedName = savedName;
        this.savePath = savePath;
        this.fileType = fileType;
        this.thumbnailPath = thumbnailPath;
        this.status = status;
    }

    public Long getNo() {
        return no;
    }

    public void setNo(Long no) {
        this.no = no;
    }

    public Long getRefBoardNo() {
        return refBoardNo;
    }

    public void setRefBoardNo(Long refBoardNo) {
        this.refBoardNo = refBoardNo;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public String getSavedName() {
        return savedName;
    }

    public void setSavedName(String savedName) {
        this.savedName = savedName;
    }

    public String getSavePath() {
        return savePath;
    }

    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getThumbnailPath() {
        return thumbnailPath;
    }

    public void setThumbnailPath(String thumbnailPath) {
        this.thumbnailPath = thumbnailPath;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "AttachmentDTO{" +
                "no=" + no +
                ", refBoardNo=" + refBoardNo +
                ", originalName='" + originalName + '\'' +
                ", savedName='" + savedName + '\'' +
                ", savePath='" + savePath + '\'' +
                ", fileType='" + fileType + '\'' +
                ", thumbnailPath='" + thumbnailPath + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
