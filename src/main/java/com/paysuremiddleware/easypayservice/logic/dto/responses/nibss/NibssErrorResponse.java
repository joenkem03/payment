package com.paysuremiddleware.easypayservice.logic.dto.responses.nibss;

public class NibssErrorResponse {
//    "400 : \"{\"timestamp\":\"2022-12-02 01:18:36\",\"code\":\"A6\",\"message\":\"Destination Institution Code is required,Destination Institution Code can only be numbers\"}\""
    private String timestamp;
    private String code;
    private String message;
    private String responseCode;

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }
}
