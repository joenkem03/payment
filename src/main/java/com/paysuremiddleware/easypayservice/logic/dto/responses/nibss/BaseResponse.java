package com.paysuremiddleware.easypayservice.logic.dto.responses.nibss;

public class BaseResponse {
    private String SessionID;
    private int ChannelCode;
    private String ResponseCode;
    private String TransactionId;



    public String getSessionID() {
        return SessionID;
    }

    public void setSessionID(String sessionID) {
        SessionID = sessionID;
    }

    public int getChannelCode() {
        return ChannelCode;
    }

    public void setChannelCode(int channelCode) {
        ChannelCode = channelCode;
    }

    public String getResponseCode() {
        return ResponseCode;
    }

    public void setResponseCode(String responseCode) {
        ResponseCode = responseCode;
    }

    public String getTransactionId() {
        return TransactionId;
    }

    public void setTransactionId(String transactionId) {
        TransactionId = transactionId;
    }
}
