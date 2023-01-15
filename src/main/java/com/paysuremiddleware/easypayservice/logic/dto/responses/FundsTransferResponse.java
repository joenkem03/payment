package com.paysuremiddleware.easypayservice.logic.dto.responses;

public class FundsTransferResponse extends BaseResponse {

//    private String NameEnquiryRef;
//    private String DestinationInstitutionCode;
//    private String BeneficiaryAccountName;
//    private String BeneficiaryAccountNumber;
//    private String BeneficiaryBankVerificationNumber;
//    private int BeneficiaryKYCLevel;
//    private String OriginatorAccountName;
//    private String OriginatorAccountNumber;
//    private String OriginatorBankVerificationNumber;
//    private int OriginatorKYCLevel;
//    private String TransactionLocation;
//    private String Narration;
//    private String PaymentReference;
//    private double Amount;


    private String NameEnquiryRef;
    private String DestinationInstitutionCode;
    private String BeneficiaryAccountName;
    private String BeneficiaryAccountNumber;
    private String BeneficiaryBankVerificationNumber;
    private int BeneficiaryKYCLevel;
    private String OriginatorAccountName;
    private String OriginatorAccountNumber;
    private String OriginatorBankVerificationNumber;
    private int OriginatorKYCLevel;
    private String TransactionLocation;
    private String Narration;
    private String PaymentReference;
    private double Amount;

    private String TransactionId;

    public String getNameEnquiryRef() {
        return NameEnquiryRef;
    }

    public void setNameEnquiryRef(String nameEnquiryRef) {
        NameEnquiryRef = nameEnquiryRef;
    }

    public String getDestinationInstitutionCode() {
        return DestinationInstitutionCode;
    }

    public void setDestinationInstitutionCode(String destinationInstitutionCode) {
        DestinationInstitutionCode = destinationInstitutionCode;
    }

    public String getBeneficiaryAccountName() {
        return BeneficiaryAccountName;
    }

    public void setBeneficiaryAccountName(String beneficiaryAccountName) {
        BeneficiaryAccountName = beneficiaryAccountName;
    }

    public String getBeneficiaryAccountNumber() {
        return BeneficiaryAccountNumber;
    }

    public void setBeneficiaryAccountNumber(String beneficiaryAccountNumber) {
        BeneficiaryAccountNumber = beneficiaryAccountNumber;
    }

    public String getBeneficiaryBankVerificationNumber() {
        return BeneficiaryBankVerificationNumber;
    }

    public void setBeneficiaryBankVerificationNumber(String beneficiaryBankVerificationNumber) {
        BeneficiaryBankVerificationNumber = beneficiaryBankVerificationNumber;
    }

    public int getBeneficiaryKYCLevel() {
        return BeneficiaryKYCLevel;
    }

    public void setBeneficiaryKYCLevel(int beneficiaryKYCLevel) {
        BeneficiaryKYCLevel = beneficiaryKYCLevel;
    }

    public String getOriginatorAccountName() {
        return OriginatorAccountName;
    }

    public void setOriginatorAccountName(String originatorAccountName) {
        OriginatorAccountName = originatorAccountName;
    }

    public String getOriginatorAccountNumber() {
        return OriginatorAccountNumber;
    }

    public void setOriginatorAccountNumber(String originatorAccountNumber) {
        OriginatorAccountNumber = originatorAccountNumber;
    }

    public String getOriginatorBankVerificationNumber() {
        return OriginatorBankVerificationNumber;
    }

    public void setOriginatorBankVerificationNumber(String originatorBankVerificationNumber) {
        OriginatorBankVerificationNumber = originatorBankVerificationNumber;
    }

    public int getOriginatorKYCLevel() {
        return OriginatorKYCLevel;
    }

    public void setOriginatorKYCLevel(int originatorKYCLevel) {
        OriginatorKYCLevel = originatorKYCLevel;
    }

    public String getTransactionLocation() {
        return TransactionLocation;
    }

    public void setTransactionLocation(String transactionLocation) {
        TransactionLocation = transactionLocation;
    }

    public String getNarration() {
        return Narration;
    }

    public void setNarration(String narration) {
        Narration = narration;
    }

    public String getPaymentReference() {
        return PaymentReference;
    }

    public void setPaymentReference(String paymentReference) {
        PaymentReference = paymentReference;
    }

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double amount) {
        Amount = amount;
    }

    public String getTransactionId() {
        return TransactionId;
    }

    public void setTransactionId(String transactionId) {
        TransactionId = transactionId;
    }
}
