package com.paysuremiddleware.easypayservice.models;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "funds_transfer_entry")
public class AccountTransactionEntry implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "request_id", length = 32, unique = true)
    private String requestId;
    @Column(name = "transaction_id", length = 32, unique = true)
    private String transactionId;
    @Column(name = "session_id", length = 32, unique = true)
    private String sessionId;
    @Column(name = "created_date", nullable = false)
    private Timestamp createdDate;
    @Column(name = "account_number", length = 16)
    private String accountNumber;
    @Column(name = "account_alt", length = 16)
    private String accountBvn;
    @Column(name = "account_name", length = 32)
    private String accountName;
    @Column(name = "account_kyc", length = 32)
    private String accountKyc;
    @Column(name = "mandate_id", length = 32)
    private String mandateId;
//    @Column(name = "action", length = 16)
//    private String Action;
    @Column(name = "status", length = 16)
    private String status;
    @Column(name = "amount")
    private double amount;
    @Column(name = "source_balance_at_transfer")
    private double balanceAtTransfer;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

//    public String getAction() {
//        return Action;
//    }
//
//    public void setAction(String action) {
//        Action = action;
//    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getAccountBvn() {
        return accountBvn;
    }

    public void setAccountBvn(String accountBvn) {
        this.accountBvn = accountBvn;
    }

    public String getAccountKyc() {
        return accountKyc;
    }

    public void setAccountKyc(String accountKyc) {
        this.accountKyc = accountKyc;
    }

    public String getMandateId() {
        return mandateId;
    }

    public void setMandateId(String mandateId) {
        this.mandateId = mandateId;
    }

    public double getBalanceAtTransfer() {
        return balanceAtTransfer;
    }

    public void setBalanceAtTransfer(double balanceAtTransfer) {
        this.balanceAtTransfer = balanceAtTransfer;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
