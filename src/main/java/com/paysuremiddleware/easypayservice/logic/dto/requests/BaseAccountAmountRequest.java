package com.paysuremiddleware.easypayservice.logic.dto.requests;

public class BaseAccountAmountRequest extends BaseRequest{

    private String DestinationInstitutionCode;
    private String TargetAccountName;
    private String TargetBankVerificationNumber;
    private String TargetAccountNumber;


    private String ReferenceCode;
    private String ReasonCode;
    private String Narration;

    private boolean IsBlocked;


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

    public boolean isBlocked() {
        return IsBlocked;
    }

    public void setBlocked(boolean blocked) {
        IsBlocked = blocked;
    }
}
