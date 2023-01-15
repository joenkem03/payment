package com.paysuremiddleware.easypayservice.logic.dto.responses.nibss;

public class BaseAccountAmountResponse extends BaseResponse {
    private String DestinationInstitutionCode;
    private String TargetAccountName;
    private String TargetBankVerificationNumber;
    private String TargetAccountNumber;


    private String ReferenceCode;
    private String ReasonCode;
    private String Narration;
//    private double Amount;


    public String getDestinationInstitutionCode() {
        return DestinationInstitutionCode;
    }

    public void setDestinationInstitutionCode(String destinationInstitutionCode) {
        DestinationInstitutionCode = destinationInstitutionCode;
    }

    public String getTargetAccountName() {
        return TargetAccountName;
    }

    public void setTargetAccountName(String targetAccountName) {
        TargetAccountName = targetAccountName;
    }

    public String getTargetBankVerificationNumber() {
        return TargetBankVerificationNumber;
    }

    public void setTargetBankVerificationNumber(String targetBankVerificationNumber) {
        TargetBankVerificationNumber = targetBankVerificationNumber;
    }

    public String getTargetAccountNumber() {
        return TargetAccountNumber;
    }

    public void setTargetAccountNumber(String targetAccountNumber) {
        TargetAccountNumber = targetAccountNumber;
    }

    public String getReferenceCode() {
        return ReferenceCode;
    }

    public void setReferenceCode(String referenceCode) {
        ReferenceCode = referenceCode;
    }

    public String getReasonCode() {
        return ReasonCode;
    }

    public void setReasonCode(String reasonCode) {
        ReasonCode = reasonCode;
    }

    public String getNarration() {
        return Narration;
    }

    public void setNarration(String narration) {
        Narration = narration;
    }
}
