package com.paysuremiddleware.easypayservice.logic.dto.requests;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class BaseRequest {

    private String RequestId;
//    private int ChannelCode;
//
    public String getRequestId() {
        return RequestId;
    }

    @NotNull
    @NotBlank
    @Length(min = 8, max = 30, message = "required")
    public void setRequestId(String requestId) {
        RequestId = requestId;
    }

//    public int getChannelCode() {
//        return ChannelCode;
//    }
//
//    @Min(value = 1, message = "min 1")
//    @Max(value = 6, message = "max 6")
//    public void setChannelCode(int channelCode) {
//        ChannelCode = channelCode;
//    }
}
