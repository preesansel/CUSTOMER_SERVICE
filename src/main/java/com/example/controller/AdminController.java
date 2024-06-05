package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.exceptions.ResourceNotFoundException;
import com.example.model.Customer;
import com.example.service.AdminService;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/admin")
public class AdminController {

//	@Autowired 
//	RestTemplate rs;

	@Autowired
	AdminService adminService;

//	    @GetMapping("/checkBalance/{id}")
//	    public int adminBal(@PathVariable int id) {
//	    int cust = rs.getForObject("http://localhost:8881/api/customers/balance/" + id,Integer.class);
//		return cust;
//	    }
//
//	    @GetMapping("/all")
//	    public ResponseEntity<List<Customer>> getAllCustomers() {
//	        List<Customer> customers = adminService.getAllCustomers();
//	        return new ResponseEntity<>(customers, HttpStatus.OK);
//	    }
//	    
//	    @GetMapping("/{id}")
//	    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") int id) {
//	        try {
//	            Customer customer = adminService.getOneCustomer(id);
//	            return new ResponseEntity<>(customer, HttpStatus.OK);
//	        } catch (ResourceNotFoundException e) {
//	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//	        }
//	    }
//	    @PostMapping("/add")
//	    public ResponseEntity<Void> addCustomer(@RequestBody Customer customer) {
//	        adminService.addCustomer(customer);
//	        return new ResponseEntity<>(HttpStatus.CREATED);
//	    }
//
//	    @DeleteMapping("/delete/{id}")
//	    public ResponseEntity<Void> deleteCustomer(@PathVariable int id) {
//	        try {
//	            boolean deleted = adminService.deleteCustomer(id);
//	            if (deleted) {
//	                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//	            } else {
//	                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//	            }
//	        } catch (ResourceNotFoundException e) {
//	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//	        }
//	    }

	@GetMapping("/getAll")
	public List<Customer> getAllCustomers() {
		return adminService.getAllCustomers();
	}

	@GetMapping("/getOne/{id}")
	public Customer getCustomerById(@PathVariable int id) {
		return adminService.getOneCustomer(id);

	}

	@PostMapping("/add")
	public void addCustomer(@RequestBody Customer customer) {
		System.out.println("\n"+customer);
		adminService.addCustomer(customer);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteCustomer(@PathVariable int id) {
		
		adminService.deleteCustomer(id);
	}

}
