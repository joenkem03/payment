package com.paysuremiddleware.easypayservice.logic.dto;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "nibss")
@Configuration("nibssConfigParam")
@Component
public class NibssConfig {

    private String base_url;
    private String token_url;
    private String grant_type;
    private String client_secret;
    private String client_id;
    private String scope;
    private String client_code;
    private String biller_id;
    private String auth_code;
    private String inst_code;
    private String inst_account;
    private String inst_account_name;
    private String bvn;
    private String kyc;


    public String getBase_url() {
        return base_url;
    }

    public void setBase_url(String base_url) {
        this.base_url = base_url;
    }

    public String getToken_url() {
        return token_url;
    }

    public void setToken_url(String token_url) {
        this.token_url = token_url;
    }

    public String getGrant_type() {
        return grant_type;
    }

    public void setGrant_type(String grant_type) {
        this.grant_type = grant_type;
    }

    public String getClient_secret() {
        return client_secret;
    }

    public void setClient_secret(String client_secret) {
        this.client_secret = client_secret;
    }

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getClient_code() {
        return client_code;
    }

    public void setClient_code(String client_code) {
        this.client_code = client_code;
    }

    public String getBiller_id() {
        return biller_id;
    }

    public void setBiller_id(String biller_id) {
        this.biller_id = biller_id;
    }

    public String getAuth_code() {
        return auth_code;
    }

    public void setAuth_code(String auth_code) {
        this.auth_code = auth_code;
    }

    public String getInst_code() {
        return inst_code;
    }

    public void setInst_code(String inst_code) {
        this.inst_code = inst_code;
    }

    public String getInst_account() {
        return inst_account;
    }

    public void setInst_account(String inst_account) {
        this.inst_account = inst_account;
    }

    public String getInst_account_name() {
        return inst_account_name;
    }

    public void setInst_account_name(String inst_account_name) {
        this.inst_account_name = inst_account_name;
    }

    public String getBvn() {
        return bvn;
    }

    public void setBvn(String bvn) {
        this.bvn = bvn;
    }

    public String getKyc() {
        return kyc;
    }

    public void setKyc(String kyc) {
        this.kyc = kyc;
    }
}
