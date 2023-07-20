package com.example.workshop21prac3.Model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private Integer customer_id;
    private Date order_date;
    private String ship_name;
    private String ship_address;

    
    
}
