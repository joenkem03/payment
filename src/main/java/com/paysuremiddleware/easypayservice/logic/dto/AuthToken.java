package com.paysuremiddleware.easypayservice.logic.dto;

public class AuthToken {
//    {
//        "token_type": "Bearer",
//        "expires_in": 3599,
//        "ext_expires_in": 3599,
//        "access_token": "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImtpZCI6IjJaUXBKM1VwYmpBWVhZR2FYRUpsOGxWMFRPSSJ9.eyJhdWQiOiI1OGY0NTRjNS04ZGEwLTRlN2YtOWVlYy0zZWMyNDRlOTU0YjciLCJpc3MiOiJodHRwczovL2xvZ2luLm1pY3Jvc29mdG9ubGluZS5jb20vMjc5YzdiMWItYmEwNi00MjdiLWE2ODEtYzhhNTQ5MmQyOTNkL3YyLjAiLCJpYXQiOjE2Njk5MjkzMjEsIm5iZiI6MTY2OTkyOTMyMSwiZXhwIjoxNjY5OTMzMjIxLCJhaW8iOiJFMlpnWU5qRzc3QW02SFprdlhiWWltODNEeVU1QWdBPSIsImF6cCI6IjU4ZjQ1NGM1LThkYTAtNGU3Zi05ZWVjLTNlYzI0NGU5NTRiNyIsImF6cGFjciI6IjEiLCJyaCI6IjAuQVlJQUczdWNKd2E2ZTBLbWdjaWxTUzBwUGNWVTlGaWdqWDlPbnV3LXdrVHBWTGVDQUFBLiIsInRpZCI6IjI3OWM3YjFiLWJhMDYtNDI3Yi1hNjgxLWM4YTU0OTJkMjkzZCIsInV0aSI6Im8wMThVU05zYlV1MExnTXdjVjd1QVEiLCJ2ZXIiOiIyLjAifQ.Ut7bwrcg5NAwKIcu0IAuWeDbf7a49WO1GOPii5c4Wk2d5A4Sm1K5ykaKQTN5k5WjLJkcZQz6Egn91lvrvyY2haRlOh9HYOLZKf-gqPYxViikDpsxH-pFFVLQd5KQeL1OjWzNemrUalxmG85dki1p9R3--pAwHPsVXX2OdtDIs0e-wNxac7Jry6l2N8dFpLw_xbCySUtErAXh2K-y8_CVsQ7Qr7gDwSD3P5y-w95I8XllobyEhXZJLYQK979uMcLPc1q4eemWhjZG9swqH2AUH4bNcyfyyo8tccqo9B6fRyyhIE-oubsiCtQL6Mv8YEOQWM9sPEzdZBPc1XRo9cz9xA"
//    }
    private String token_type;
    private String expires_in;
    private String ext_expires_in;
    private String access_token;

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public String getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(String expires_in) {
        this.expires_in = expires_in;
    }

    public String getExt_expires_in() {
        return ext_expires_in;
    }

    public void setExt_expires_in(String ext_expires_in) {
        this.ext_expires_in = ext_expires_in;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }
}
