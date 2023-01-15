package com.paysuremiddleware.easypayservice.logic.dto.requests.nibss;

public class TSQuerySingleRequest {

//    <SourceInstitutionCode>000002</SourceInstitutionCode>
//<ChannelCode>1</ChannelCode>
//<SessionID>000001100913103301000000000001</SessionID>

//    private String SourceInstitutionCode;
//    private int ChannelCode;
    private String TransactionId;

    public String getTransactionId() {
        return TransactionId;
    }

    public void setTransactionId(String transactionId) {
        TransactionId = transactionId;
    }
}
