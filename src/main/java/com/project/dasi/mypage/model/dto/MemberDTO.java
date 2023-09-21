package com.project.dasi.mypage.model.dto;

public class MemberDTO implements java.io.Serializable {
    private String userCode;
    private String userId;
    private String userPwd;
    private String userName;
    private String birthDate;
    private String email;
    private String tel;
    private String gender;
    private String marketingStatus;
    private String joinDate;
    private String withdrawStatus;
    private String withdrawDate;

    public MemberDTO() {
    }

    public MemberDTO(String userCode, String userId, String userPwd, String userName, String birthDate, String email, String tel, String gender, String marketingStatus, String joinDate, String withdrawStatus, String withdrawDate) {
        this.userCode = userCode;
        this.userId = userId;
        this.userPwd = userPwd;
        this.userName = userName;
        this.birthDate = birthDate;
        this.email = email;
        this.tel = tel;
        this.gender = gender;
        this.marketingStatus = marketingStatus;
        this.joinDate = joinDate;
        this.withdrawStatus = withdrawStatus;
        this.withdrawDate = withdrawDate;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMarketingStatus() {
        return marketingStatus;
    }

    public void setMarketingStatus(String marketingStatus) {
        this.marketingStatus = marketingStatus;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public String getWithdrawStatus() {
        return withdrawStatus;
    }

    public void setWithdrawStatus(String withdrawStatus) {
        this.withdrawStatus = withdrawStatus;
    }

    public String getWithdrawDate() {
        return withdrawDate;
    }

    public void setWithdrawDate(String withdrawDate) {
        this.withdrawDate = withdrawDate;
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "userCode='" + userCode + '\'' +
                ", userId='" + userId + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", userName='" + userName + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", email='" + email + '\'' +
                ", tel='" + tel + '\'' +
                ", gender='" + gender + '\'' +
                ", marketingStatus='" + marketingStatus + '\'' +
                ", joinDate='" + joinDate + '\'' +
                ", withdrawStatus='" + withdrawStatus + '\'' +
                ", withdrawDate='" + withdrawDate + '\'' +
                '}';
    }
}