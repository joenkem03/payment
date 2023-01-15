package com.paysuremiddleware.easypayservice.logic.dto.responses.nibss;

public class BalanceEnquiryResponse extends BaseResponse {
//    <SessionID>000001100913103301000000000001</SessionID>
//<DestinationInstitutionCode>000002</DestinationInstitutionCode>
//<ChannelCode>7</ChannelCode>
//<AuthorizationCode>xxxxxxxxxxxxxxx</AuthorizationCode>
//    <TargetAccountName>Ajibade Oluwasegun</TargetAccountName>
//<TargetBankVerificationNumber>1033000442</TargetBankVerificationNumber>
//<TargetAccountNumber>2222002345</TargetAccountNumber>
//<AvailableBalance>1000.00</AvailableBalance>
//<ResponseCode>00</ResponseCode>

//    {
//        "responseCode": "00",
//            "sessionID": "999999220608140828280645462287",
//            "transactionId": "000034220608140800123456789012",
//            "channelCode": "1",
//            "destinationInstitutionCode": "999998",
//            "authorizationCode": "NIPMINI1/1647351897985",
//            "targetAccountName": "vee Test",
//            "targetBankVerificationNumber": "33333333333",
//            "targetAccountNumber": "0112345678",
//            "availableBalance": "561100555602.82"
//    }
//
//    {\"responseCode\":\"00\",\"sessionID\":\"999999221202041732295304194125\",\"transactionId\":\"000168221202041732669745602706\",\"channelCode\":1,\"destinationInstitutionCode\":\"999998\",\"authorizationCode\":\"NIPMINI1/1647351897985\",\"targetAccountName\":\"vee Test\",\"targetBankVerificationNumber\":\"33333333333\",\"targetAccountNumber\":\"0112345678\",\"availableBalance\":561127999568.92}"

    private String DestinationInstitutionCode;
    private String AuthorizationCode;
    private String TargetAccountName;
    private String TargetBankVerificationNumber;
    private String TargetAccountNumber;
    private double AvailableBalance;

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

    public double getAvailableBalance() {
        return AvailableBalance;
    }

    public void setAvailableBalance(double availableBalance) {
        AvailableBalance = availableBalance;
    }
}
