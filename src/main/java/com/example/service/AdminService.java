package com.example.service;


import com.example.model.Customer;

import java.util.List;

public interface AdminService {
	    List<Customer> getAllCustomers();
	    Customer getOneCustomer(int id);
	    void addCustomer(Customer customer);
	    boolean deleteCustomer(int id);
}