package com.paysuremiddleware.easypayservice.logic.dto.requests.nibss;

public class FIListRecords {
//    <Record>
//        <InstitutionCode>000002</InstitutionCode>
//        <InstitutionName>MMO XYZ</InstitutionName>
//        <Category>10</Category>
//    </Record>

    private String InstitutionCode;
    private String InstitutionName;
    private String Category;

    public String getInstitutionCode() {
        return InstitutionCode;
    }

    public void setInstitutionCode(String institutionCode) {
        InstitutionCode = institutionCode;
    }

    public String getInstitutionName() {
        return InstitutionName;
    }

    public void setInstitutionName(String institutionName) {
        InstitutionName = institutionName;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }
}
