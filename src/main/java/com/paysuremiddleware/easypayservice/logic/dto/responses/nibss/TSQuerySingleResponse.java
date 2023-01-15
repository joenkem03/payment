package com.paysuremiddleware.easypayservice.logic.dto.responses.nibss;

public class TSQuerySingleResponse extends BaseResponse {

    private String SourceInstitutionCode;

    public String getSourceInstitutionCode() {
        return SourceInstitutionCode;
    }

    public void setSourceInstitutionCode(String sourceInstitutionCode) {
        SourceInstitutionCode = sourceInstitutionCode;
    }
}
