package com.paysuremiddleware.easypayservice.logic.dto.responses.nibss;

public class MandateAdviceResponse extends BaseResponse {
//<SessionID>000001100913103301000000000001</SessionID>
//<DestinationInstitutionCode>000002</DestinationInstitutionCode>
//<ChannelCode>7</ChannelCode>
//<MandateReferenceNumber>xxxxxxxxxxxxxxx</MandateReferenceNumber>
//<Amount>1000.00</Amount>
//    <DebitAccountName>Ajibade Oluwasegun</DebitAccountName>
//<DebitAccountNumber>2222000000012345</DebitAccountNumber>
//<DebitBankVerificationNumber>1033000442</DebitBankVerificationNumber>
//<DebitKYCLevel>1</DebitKYCLevel>
//    <BeneficiaryAccountName>Sarah Hassan Emeka</BeneficiaryAccountName>
//<BeneficiaryAccountNumber>2222002345</BeneficiaryAccountNumber>
//<BeneficiaryBankVerificationNumber>1033000442</BeneficiaryBankVerificationNumber>
//<BeneficiaryKYCLevel>1</BeneficiaryKYCLevel>
//<ResponseCode>00</ResponseCode>


    private String DestinationInstitutionCode;
    private String DebitAccountName;
    private String DebitAccountNumber;
    private String DebitBankVerificationNumber;
    private int DebitKYCLevel;
    private String BeneficiaryAccountName;
    private String BeneficiaryAccountNumber;
    private String BeneficiaryBankVerificationNumber;
    private int BeneficiaryKYCLevel;
    private String MandateReferenceNumber;
    private double Amount;
}
