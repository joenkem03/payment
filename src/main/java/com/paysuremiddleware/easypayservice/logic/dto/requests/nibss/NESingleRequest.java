package com.paysuremiddleware.easypayservice.logic.dto.requests.nibss;

import java.io.Serializable;

public class NESingleRequest extends BaseRequest implements Serializable {

//    {
//        "accountNumber": "'0112345678'",
//            "channelCode": "1",
//            "destinationInstitutionCode": "'999998'",
//            "transactionId": "'000034220608111630100001000001'"
//    }
//    <SessionID>000001100913103301000000000001</SessionID>
//<DestinationInstitutionCode>000002</DestinationInstitutionCode>
//<ChannelCode>1</ChannelCode>
//<AccountNumber>2222000000012345</AccountNumber>

    private String DestinationInstitutionCode;
    private String AccountNumber;



    public String getDestinationInstitutionCode() {
        return DestinationInstitutionCode;
    }

    public void setDestinationInstitutionCode(String destinationInstitutionCode) {
        DestinationInstitutionCode = destinationInstitutionCode;
    }

    public String getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        AccountNumber = accountNumber;
    }

//    @Override
//    public String getTransactionId() {
//        return super.getTransactionId();
//    }
//
//    @Override
//    public void setTransactionId(String transactionId) {
//        super.setTransactionId(transactionId);
//    }
//
//    @Override
//    public String getChannelCode() {
//        return super.getChannelCode();
//    }
//
//    @Override
//    public void setChannelCode(String channelCode) {
//        super.setChannelCode(channelCode);
//    }

//    @Override
//    public String toString() {
//        return "NESingleRequest{" +
//                "DestinationInstitutionCode='" + DestinationInstitutionCode + '\'' +
//                ", AccountNumber='" + AccountNumber + '\'' +
//                '}';
//    }
}
