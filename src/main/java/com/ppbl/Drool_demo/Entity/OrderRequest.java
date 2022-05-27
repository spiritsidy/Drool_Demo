package com.ppbl.Drool_demo.Entity;

import lombok.Data;

@Data
public class OrderRequest {

    private String customerNumber;
    private Integer age;
    private Integer amount;
    private CustomerType customerType;
}
