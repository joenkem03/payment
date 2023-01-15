package com.paysuremiddleware.easypayservice.logic.dto.responses;

import java.io.Serializable;

public class AccountEnquiryResponse extends BaseResponse implements Serializable {
//    private String SessionID;
    private String DestinationInstitutionCode;
    private int ChannelCode;
    private String AccountName;
    private String AccountNumber;
    private String BankVerificationNumber;
    private int KycLevel;

    public String getDestinationInstitutionCode() {
        return DestinationInstitutionCode;
    }

    public void setDestinationInstitutionCode(String destinationInstitutionCode) {
        DestinationInstitutionCode = destinationInstitutionCode;
    }

//    @Override
//    public int getChannelCode() {
//        return ChannelCode;
//    }
//
//    @Override
//    public void setChannelCode(int channelCode) {
//        ChannelCode = channelCode;
//    }

    public String getAccountName() {
        return AccountName;
    }

    public void setAccountName(String accountName) {
        AccountName = accountName;
    }

    public String getBankVerificationNumber() {
        return BankVerificationNumber;
    }

    public void setBankVerificationNumber(String bankVerificationNumber) {
        BankVerificationNumber = bankVerificationNumber;
    }

    public int getKycLevel() {
        return KycLevel;
    }

    public void setKycLevel(int kycLevel) {
        this.KycLevel = kycLevel;
    }

    public String getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        AccountNumber = accountNumber;
    }
}
