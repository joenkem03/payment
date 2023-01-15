package com.paysuremiddleware.easypayservice.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "institution_category")
public class FinancialInstitutionsCategory {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "code", length = 2)
    private String Code;
    @Column(name = "name", length = 64)
    private String Category;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }
}
