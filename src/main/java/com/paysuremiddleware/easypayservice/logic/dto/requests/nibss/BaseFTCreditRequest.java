package com.paysuremiddleware.easypayservice.logic.dto.requests.nibss;

public class BaseFTCreditRequest extends BaseBillerRequest {

//    {
//            "sourceInstittioncode": "999998",
//            "amount": "100",
//            "beneficiaryAccountName": "Ake Mobolaji Temabor",
//            "beneficiaryAccountNumber": "'0112345678'",
//            "beneficiaryBankVerificationNumber": "22222222226",
//            "beneficiaryKYCLevel": "1",
//            "channelCode": "1",
//            "originatorAccountName": "vee Test",
//            "originatorAccountNumber": "112345678",
//            "originatorBankVerificationNumber": "33333333333",
//            "originatorKYCLevel": "1",
//            "destinationInstitutionCode": "'999998'",
//            "mandateReferenceNumber": "MA-0112345678-2022315-53097",
//            "nameEnquiryRef": "999999191106195503191106195503",
//            "originatorNarration": "Payment from 0112345678 to 1780004070",
//            "paymentReference": "1/999999191106195503191106195503/6015007956/0231116887",
//            "transactionId": "'000034220608111630100001000001'",
//            "transactionLocation": "1.38716,3.05117",
//            "beneficiaryNarration": "Payment to 0112345678 from 1780004070",
//            "billerId": "ADC19BDC-7D3A-4C00-4F7B-08DA06684F59"
//    }

    private String NameEnquiryRef;
    private String DestinationInstitutionCode;
    private String SourceInstitutionCode;
    private String BeneficiaryAccountName;
    private String BeneficiaryAccountNumber;
    private String BeneficiaryBankVerificationNumber;
    private String BeneficiaryKYCLevel;
    private String OriginatorAccountName;
    private String OriginatorAccountNumber;
    private String OriginatorBankVerificationNumber;
    private String OriginatorKYCLevel;
    private String TransactionLocation;
    private String OriginatorNarration;
    private String BeneficiaryNarration;
    private String PaymentReference;
    private double Amount;
//    private String BillerId;
    private String MandateReferenceNumber;



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

    public String getSourceInstitutionCode() {
        return SourceInstitutionCode;
    }

    public void setSourceInstitutionCode(String sourceInstitutionCode) {
        SourceInstitutionCode = sourceInstitutionCode;
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

    public String getBeneficiaryKYCLevel() {
        return BeneficiaryKYCLevel;
    }

    public void setBeneficiaryKYCLevel(String beneficiaryKYCLevel) {
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

    public String getOriginatorKYCLevel() {
        return OriginatorKYCLevel;
    }

    public void setOriginatorKYCLevel(String originatorKYCLevel) {
        OriginatorKYCLevel = originatorKYCLevel;
    }

    public String getTransactionLocation() {
        return TransactionLocation;
    }

    public void setTransactionLocation(String transactionLocation) {
        TransactionLocation = transactionLocation;
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


    public String getMandateReferenceNumber() {
        return MandateReferenceNumber;
    }

    public void setMandateReferenceNumber(String mandateReferenceNumber) {
        MandateReferenceNumber = mandateReferenceNumber;
    }
}
