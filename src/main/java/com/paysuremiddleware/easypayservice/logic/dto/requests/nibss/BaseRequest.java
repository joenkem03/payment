package com.paysuremiddleware.easypayservice.logic.dto.requests.nibss;

import java.io.Serializable;

public class BaseRequest implements Serializable {
    private String TransactionId;
    private String ChannelCode;

    public String getTransactionId() {
        return TransactionId;
    }

    public void setTransactionId(String transactionId) {
        TransactionId = transactionId;
    }

    public String getChannelCode() {
        return ChannelCode;
    }

    public void setChannelCode(String channelCode) {
        ChannelCode = channelCode;
    }
}
