package com.paysuremiddleware.easypayservice.logic.dto.requests.nibss;

import java.io.Serializable;

public class BaseBillerRequest extends BaseRequest implements Serializable {
    private String BillerId;

    public String getBillerId() {
        return BillerId;
    }

    public void setBillerId(String billerId) {
        BillerId = billerId;
    }
}
