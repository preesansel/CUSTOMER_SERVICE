package com.example.service;



import com.example.exceptions.ResourceNotFoundException;
import com.example.model.Customer;

import com.example.repository.CustomerRepository;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	 CustomerRepository customerRepository;

	    @Override
	    public List<Customer> getAllCustomers() {
	        return customerRepository.findAll();
	    }

	    @Override
	    public Customer getOneCustomer(int id) {
	        return customerRepository.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with ID: " + id));
	    }

	    @Override
	    public void addCustomer(Customer customer) {
	        customerRepository.save(customer);
	    }

	    @Override
	    public boolean deleteCustomer(int id) {
	    	
	        if (customerRepository.existsById(id)) {
	            customerRepository.deleteById(id);
	            return true;
	        } else {
	            throw new ResourceNotFoundException("Customer not found with ID: " + id);
	        }
	    }


  
}


