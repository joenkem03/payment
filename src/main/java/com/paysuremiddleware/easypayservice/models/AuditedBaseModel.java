package com.paysuremiddleware.easypayservice.models;

import javax.persistence.Column;
import java.sql.Date;

public class AuditedBaseModel extends BaseCreateModel{

    @Column(name = "created_by")
    private long CreatedBy;
    @Column(name = "modified_by")
    private long ModifiedBy;
    @Column(name = "modified_date")
    private Date ModifiedDate;

    public long getCreatedBy() {
        return CreatedBy;
    }

    public void setCreatedBy(long createdBy) {
        CreatedBy = createdBy;
    }

    public long getModifiedBy() {
        return ModifiedBy;
    }

    public void setModifiedBy(long modifiedBy) {
        ModifiedBy = modifiedBy;
    }

    public Date getModifiedDate() {
        return ModifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        ModifiedDate = modifiedDate;
    }
}
