package com.paysuremiddleware.easypayservice.logic.dto.responses.nibss;

import java.io.Serializable;

public class NESingleResponse extends BaseResponse implements Serializable {
//    private String SessionID;
    private String TransactionId;
    private String DestinationInstitutionCode;
//    private int ChannelCode;
    private String AccountName;
    private String AccountNumber;
    private String BankVerificationNumber;
    private int KycLevel;

    public String getTransactionId() {
        return TransactionId;
    }

    public void setTransactionId(String transactionId) {
        TransactionId = transactionId;
    }

    public String getDestinationInstitutionCode() {
        return DestinationInstitutionCode;
    }

    public void setDestinationInstitutionCode(String destinationInstitutionCode) {
        DestinationInstitutionCode = destinationInstitutionCode;
    }

    public String getAccountName() {
        return AccountName;
    }

    public void setAccountName(String accountName) {
        AccountName = accountName;
    }

    public String getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        AccountNumber = accountNumber;
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
        KycLevel = kycLevel;
    }

    @Override
    public String toString() {
        return "NESingleResponse{" +
                "TransactionId='" + TransactionId + '\'' +
                ", DestinationInstitutionCode='" + DestinationInstitutionCode + '\'' +
                ", AccountName='" + AccountName + '\'' +
                ", AccountNumber='" + AccountNumber + '\'' +
                ", BankVerificationNumber='" + BankVerificationNumber + '\'' +
                ", KycLevel=" + KycLevel +
                '}';
    }
}


//{
//        "responseCode": "00",
//        "sessionID": "999999220608140828280645462287",
//        "transactionId": "000034220608140800123456789012",
//        "channelCode": "1",
//        "destinationInstitutionCode": "999998",
//        "accountNumber": "112345678",
//        "accountName": "vee Test",
//        "bankVerificationNumber": "33333333332",
//        "kycLevel": "1"
//        }
