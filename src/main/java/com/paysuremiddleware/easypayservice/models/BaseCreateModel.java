package com.paysuremiddleware.easypayservice.models;

import javax.persistence.Column;
import java.sql.Date;

public class BaseCreateModel extends BaseModel {

    @Column(name = "created_date", nullable = false)
    private Date CreatedDate;

    public Date getCreatedDate() {
        return CreatedDate;
    }

    public void setCreatedDate(Date createdDate) {
        CreatedDate = createdDate;
    }


}
