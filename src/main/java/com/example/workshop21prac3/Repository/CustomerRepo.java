package com.example.workshop21prac3.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.workshop21prac3.Model.Customer;
import com.example.workshop21prac3.Model.Order;

@Repository
public class CustomerRepo {

    @Autowired
    JdbcTemplate template;


    // private String getAllCustomers = "select *  from customers";
    private String getAllCustomersLimitOffset = "select *  from customers limit ? offset ?";
    private String getCustomerById = "select * from customers where id = ?";
    private String getOrderByCustomerId = "select * from orders where customer_id = ?";

    public List<Customer> getAllCustomers(Integer offset, Integer limit){

        return template.query(getAllCustomersLimitOffset, BeanPropertyRowMapper.newInstance(Customer.class), limit, offset);
    }

    public Customer getCustomerById(String id){

        return template.queryForObject(getCustomerById, BeanPropertyRowMapper.newInstance(Customer.class), id);

    }

    public List<Order> getOrdersByCustomerId(String id){
        

        return template.query(getOrderByCustomerId, BeanPropertyRowMapper.newInstance(Order.class), id);
    }
    
}
