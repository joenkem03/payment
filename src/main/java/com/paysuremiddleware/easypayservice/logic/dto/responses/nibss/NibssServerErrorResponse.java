package com.paysuremiddleware.easypayservice.logic.dto.responses.nibss;

public class NibssServerErrorResponse {
//    {\"responseCode\":\"96\",\"sessionID\":\"999999221203004013746119205566\",\"transactionId\":\"000168221203004013994560840901\",\"channelCode\":1,\"nameEnquiryRef\":\"999999221203004013746119205566\",\"destinationInstitutionCode\":\"999998\",\"debitAccountName\":\"vee Test\",\"debitAccountNumber\":\"0112345678\",\"debitBankVerificationNumber\":\"33333333333\",\"debitKYCLevel\":1,\"beneficiaryAccountName\":\"Ake Mobolaji Temabo\",\"beneficiaryAccountNumber\":\"1780004070\",\"beneficiaryBankVerificationNumber\":\"22222222226\",\"beneficiaryKYCLevel\":1,\"transactionLocation\":\"1.38716,3.05117\",\"narration\":\"Payment from 0112345678 to 1780004070\",\"paymentReference\":\"NIPMINI/999999191106195503191106195503/6015007956/0231116887\",\"mandateReferenceNumber\":\"MA-0112345678-2022315-53097\",\"transactionFee\":0,\"amount\":100.0}
    private String responseCode;
    private String nameEnquiryRef;
    private String destinationInstitutionCode;
    private String debitAccountName;
    private String debitAccountNumber;
    private String debitBankVerificationNumber;
    private String debitKYCLevel;


    private String beneficiaryAccountName;
    private String beneficiaryAccountNumber;
    private String beneficiaryBankVerificationNumber;



    private String beneficiaryKYCLevel;
    private String transactionLocation;
    private String narration;

    private String paymentReference;
    private String transactionFee;
    private String amount;

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getNameEnquiryRef() {
        return nameEnquiryRef;
    }

    public void setNameEnquiryRef(String nameEnquiryRef) {
        this.nameEnquiryRef = nameEnquiryRef;
    }

    public String getDestinationInstitutionCode() {
        return destinationInstitutionCode;
    }

    public void setDestinationInstitutionCode(String destinationInstitutionCode) {
        this.destinationInstitutionCode = destinationInstitutionCode;
    }

    public String getDebitAccountName() {
        return debitAccountName;
    }

    public void setDebitAccountName(String debitAccountName) {
        this.debitAccountName = debitAccountName;
    }

    public String getDebitAccountNumber() {
        return debitAccountNumber;
    }

    public void setDebitAccountNumber(String debitAccountNumber) {
        this.debitAccountNumber = debitAccountNumber;
    }

    public String getDebitBankVerificationNumber() {
        return debitBankVerificationNumber;
    }

    public void setDebitBankVerificationNumber(String debitBankVerificationNumber) {
        this.debitBankVerificationNumber = debitBankVerificationNumber;
    }

    public String getDebitKYCLevel() {
        return debitKYCLevel;
    }

    public void setDebitKYCLevel(String debitKYCLevel) {
        this.debitKYCLevel = debitKYCLevel;
    }

    public String getBeneficiaryAccountName() {
        return beneficiaryAccountName;
    }

    public void setBeneficiaryAccountName(String beneficiaryAccountName) {
        this.beneficiaryAccountName = beneficiaryAccountName;
    }

    public String getBeneficiaryAccountNumber() {
        return beneficiaryAccountNumber;
    }

    public void setBeneficiaryAccountNumber(String beneficiaryAccountNumber) {
        this.beneficiaryAccountNumber = beneficiaryAccountNumber;
    }

    public String getBeneficiaryBankVerificationNumber() {
        return beneficiaryBankVerificationNumber;
    }

    public void setBeneficiaryBankVerificationNumber(String beneficiaryBankVerificationNumber) {
        this.beneficiaryBankVerificationNumber = beneficiaryBankVerificationNumber;
    }

    public String getBeneficiaryKYCLevel() {
        return beneficiaryKYCLevel;
    }

    public void setBeneficiaryKYCLevel(String beneficiaryKYCLevel) {
        this.beneficiaryKYCLevel = beneficiaryKYCLevel;
    }

    public String getTransactionLocation() {
        return transactionLocation;
    }

    public void setTransactionLocation(String transactionLocation) {
        this.transactionLocation = transactionLocation;
    }

    public String getNarration() {
        return narration;
    }

    public void setNarration(String narration) {
        this.narration = narration;
    }

    public String getPaymentReference() {
        return paymentReference;
    }

    public void setPaymentReference(String paymentReference) {
        this.paymentReference = paymentReference;
    }

    public String getTransactionFee() {
        return transactionFee;
    }

    public void setTransactionFee(String transactionFee) {
        this.transactionFee = transactionFee;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
