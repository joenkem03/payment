package com.paysuremiddleware.easypayservice.logic.dto.responses;

public class BaseResponse {
//    private String TransactionId;
    private String SessionID;
    private String RequestId;
//    private int ChannelCode;
    private String ResponseCode;



    public String getSessionID() {
        return SessionID;
    }

    public void setSessionID(String sessionID) {
        SessionID = sessionID;
    }

//    public int getChannelCode() {
//        return ChannelCode;
//    }
//
//    public void setChannelCode(int channelCode) {
//        ChannelCode = channelCode;
//    }

    public String getResponseCode() {
        return ResponseCode;
    }

    public void setResponseCode(String responseCode) {
        ResponseCode = responseCode;
    }

    public String getRequestId() {
        return RequestId;
    }

    public void setRequestId(String requestId) {
        RequestId = requestId;
    }

//    public String getTransactionId() {
//        return TransactionId;
//    }
//
//    public void setTransactionId(String transactionId) {
//        TransactionId = transactionId;
//    }
}
