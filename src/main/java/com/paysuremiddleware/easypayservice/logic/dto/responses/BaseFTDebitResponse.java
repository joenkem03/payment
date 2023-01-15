package com.paysuremiddleware.easypayservice.logic.dto.responses;

public class BaseFTDebitResponse extends BaseResponse{
    private String NameEnquiryRef;
    private String DestinationInstitutionCode;
    private String DebitAccountName;
    private String DebitAccountNumber;
    private String DebitBankVerificationNumber;
    private int DebitKYCLevel;
    private String BeneficiaryAccountName;
    private String BeneficiaryAccountNumber;
    private String BeneficiaryBankVerificationNumber;
    private int BeneficiaryKYCLevel;
    private String TransactionLocation;
    private String Narration;
    private String PaymentReference;
    private String MandateReferenceNumber;
    private double TransactionFee;
    private double Amount;


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

    public String getDebitAccountName() {
        return DebitAccountName;
    }

    public void setDebitAccountName(String debitAccountName) {
        DebitAccountName = debitAccountName;
    }

    public String getDebitAccountNumber() {
        return DebitAccountNumber;
    }

    public void setDebitAccountNumber(String debitAccountNumber) {
        DebitAccountNumber = debitAccountNumber;
    }

    public String getDebitBankVerificationNumber() {
        return DebitBankVerificationNumber;
    }

    public void setDebitBankVerificationNumber(String debitBankVerificationNumber) {
        DebitBankVerificationNumber = debitBankVerificationNumber;
    }

    public int getDebitKYCLevel() {
        return DebitKYCLevel;
    }

    public void setDebitKYCLevel(int debitKYCLevel) {
        DebitKYCLevel = debitKYCLevel;
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

    public String getMandateReferenceNumber() {
        return MandateReferenceNumber;
    }

    public void setMandateReferenceNumber(String mandateReferenceNumber) {
        MandateReferenceNumber = mandateReferenceNumber;
    }

    public double getTransactionFee() {
        return TransactionFee;
    }

    public void setTransactionFee(double transactionFee) {
        TransactionFee = transactionFee;
    }

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double amount) {
        Amount = amount;
    }
}
