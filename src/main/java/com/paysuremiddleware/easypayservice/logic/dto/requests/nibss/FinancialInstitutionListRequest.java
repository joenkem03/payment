package com.paysuremiddleware.easypayservice.logic.dto.requests.nibss;

import java.util.List;

public class FinancialInstitutionListRequest {
//    <Header>
//        <BatchNumber>000001100911000000000001</BatchNumber>
//        <NumberOfRecords>5</NumberOfRecords>
//        <ChannelCode>1</ChannelCode>
//        <TransactionLocation>6.4300747,3.4110715</TransactionLocation>
//    </Header>
//    <Record>
//     <InstitutionCode>000001</InstitutionCode>
//        <InstitutionName>Bank ABC</InstitutionName>
//        <Category>2</Category>
//    </Record>
//    <Record>
//        <InstitutionCode>000002</InstitutionCode>
//        <InstitutionName>MMO XYZ</InstitutionName>
//        <Category>10</Category>
//    </Record>
//    <Record>
//        <InstitutionCode>000003</InstitutionCode>
//        <InstitutionName>Bank XYZ</InstitutionName>
//        <Category>2</Category>
//    </Record>
//    <Record>
//        <InstitutionCode>000004</InstitutionCode>
//        <InstitutionName>PMB X</InstitutionName>
//        <Category>6</Category>
//    </Record>
//    <Record>
//        <InstitutionCode>000005</InstitutionCode>
//        <InstitutionName>Merchant Bank XYZ</InstitutionName>
//        <Category>2</Category>
//    </Record>
    private FILisReqtHeader Header;
    private List<FIListRecords> Record;

    public FILisReqtHeader getHeader() {
        return Header;
    }

    public void setHeader(FILisReqtHeader header) {
        Header = header;
    }

    public List<FIListRecords> getRecord() {
        return Record;
    }

    public void setRecord(List<FIListRecords> record) {
        Record = record;
    }
}
