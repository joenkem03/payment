package com.paysuremiddleware.easypayservice.logic.dto.requests;

public class BaseFTCreditRequest extends BaseRequest {

    private String NameEnquiryRef;
    private String DestinationInstitutionCode;
    private String SourceInstittioncode;
    private String BeneficiaryAccountName;
    private String BeneficiaryAccountNumber;
    private String BeneficiaryBankVerificationNumber;
    private int BeneficiaryKYCLevel;
    private String OriginatorAccountName;
    private String OriginatorAccountNumber;
    private String OriginatorBankVerificationNumber;
    private int OriginatorKYCLevel;
    private String TransactionLocation;
    private String OriginatorNarration;
    private String BeneficiaryNarration;
    private String PaymentReference;
    private double Amount;
//    private String BillerId;
//    private String MandateReferenceNumber;

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

    public String getOriginatorNarration() {
        return OriginatorNarration;
    }

    public void setOriginatorNarration(String originatorNarration) {
        OriginatorNarration = originatorNarration;
    }

    public String getBeneficiaryNarration() {
        return BeneficiaryNarration;
    }

    public void setBeneficiaryNarration(String beneficiaryNarration) {
        BeneficiaryNarration = beneficiaryNarration;
    }

    public String getSourceInstittioncode() {
        return SourceInstittioncode;
    }

    public void setSourceInstittioncode(String sourceInstittioncode) {
        SourceInstittioncode = sourceInstittioncode;
    }
}
