package com.paysuremiddleware.easypayservice.logic.dto.requests;

public class BalanceEnquiry extends BaseRequest{
//    <SessionID>000001100913103301000000000001</SessionID>
//<DestinationInstitutionCode>000002</DestinationInstitutionCode>
//<ChannelCode>7</ChannelCode>
//    <AuthorizationCode>xxxxxxxxxxxxxxx</AuthorizationCode>
//    <TargetAccountName>Ajibade Oluwasegun</TargetAccountName>
//<TargetBankVerificationNumber>1033000442</TargetBankVerificationNumber>
//<TargetAccountNumber>2222002345</TargetAccountNumber>


    private String DestinationInstitutionCode;
    private String AuthorizationCode;
    private String TargetAccountName;
    private String TargetBankVerificationNumber;
    private String TargetAccountNumber;



    public String getDestinationInstitutionCode() {
        return DestinationInstitutionCode;
    }

    public void setDestinationInstitutionCode(String destinationInstitutionCode) {
        DestinationInstitutionCode = destinationInstitutionCode;
    }

    public String getAuthorizationCode() {
        return AuthorizationCode;
    }

    public void setAuthorizationCode(String authorizationCode) {
        AuthorizationCode = authorizationCode;
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
}
