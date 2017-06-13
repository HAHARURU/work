package com.jz.xd.model;

/**
 * Created by HARU on 2017/5/19.
 */
public class SendVerificationResult {
    private String resultCode;
    private String sendId;
    private String verificationCode;

    public SendVerificationResult(String resultCode, String sendId, String verificationCode) {
        this.resultCode = resultCode;
        this.sendId = sendId;
        this.verificationCode = verificationCode;
    }

    public String getResultCode() {
        return this.resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getSendId() {
        return this.sendId;
    }

    public void setSendId(String sendId) {
        this.sendId = sendId;
    }

    public String getVerificationCode() {
        return this.verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public String toString() {
        return "SendVerificationResult{resultCode=\'" + this.resultCode + '\'' + ", sendId=\'" + this.sendId + '\'' + ", verificationCode=\'" + this.verificationCode + '\'' + '}';
    }
}
