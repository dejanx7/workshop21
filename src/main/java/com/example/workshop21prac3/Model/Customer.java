package com.example.workshop21prac3.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    private String first_name;
    private String last_name;
    private String job_title;
    private Integer id; 


    
}
