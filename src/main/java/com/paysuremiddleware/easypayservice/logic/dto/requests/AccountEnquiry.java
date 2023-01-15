package com.paysuremiddleware.easypayservice.logic.dto.requests;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class AccountEnquiry extends BaseRequest implements Serializable {

    private String DestinationInstitutionCode;

    private String AccountNumber;



    public String getDestinationInstitutionCode() {
        return DestinationInstitutionCode;
    }

    public void setDestinationInstitutionCode(String destinationInstitutionCode) {
        DestinationInstitutionCode = destinationInstitutionCode;
    }

    public String getAccountNumber() {
        return AccountNumber;
    }

    @NotNull
    @NotBlank
    @Length(min = 10, max = 10, message = "required")
    public void setAccountNumber(String accountNumber) {
        AccountNumber = accountNumber;
    }
}
