package com.ohgiraffers.thymeleafspringboot.board.dto;

import com.ohgiraffers.thymeleafspringboot.member.dto.MemberDTO;

import java.sql.Date;

public class ReplyDTO {
    private Long no;
    private Long refBoardNo;
    private String body;
    private Long writerMemberNo;
    private MemberDTO writer;		            // MemberTable과 join하는 경우 1:1 조인이 될 것이기 때문에 MemberDTO 타입으로 생성
    private String status;

    private Date createdDate;

    public ReplyDTO() {
    }

    public ReplyDTO(Long no, Long refBoardNo, String body, Long writerMemberNo, MemberDTO writer, String status, Date createdDate) {
        this.no = no;
        this.refBoardNo = refBoardNo;
        this.body = body;
        this.writerMemberNo = writerMemberNo;
        this.writer = writer;
        this.status = status;
        this.createdDate = createdDate;
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

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Long getWriterMemberNo() {
        return writerMemberNo;
    }

    public void setWriterMemberNo(Long writerMemberNo) {
        this.writerMemberNo = writerMemberNo;
    }

    public MemberDTO getWriter() {
        return writer;
    }

    public void setWriter(MemberDTO writer) {
        this.writer = writer;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "ReplyDTO{" +
                "no=" + no +
                ", refBoardNo=" + refBoardNo +
                ", body='" + body + '\'' +
                ", writerMemberNo=" + writerMemberNo +
                ", writer=" + writer +
                ", status='" + status + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }
}
