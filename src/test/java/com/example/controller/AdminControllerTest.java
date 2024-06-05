package com.example.controller;

import com.example.exceptions.ResourceNotFoundException;
import com.example.model.Customer;
import com.example.service.AdminService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class AdminControllerTest {

    @Mock
    private AdminService adminService;

    @InjectMocks
    private AdminController adminController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

//  @Test
//    void testAdminBal() {
//	  int id = 1;
//       int balance = 1000;
//       when(adminService.checkBalance(id)).thenReturn(balance);
//
//       int result = adminController.adminBal(id);
//
//       assertEquals(balance, result);
//        verify(adminService, times(1)).checkBalance(id);
//   }
//
//    @Test
//    void testGetAllCustomers() {
//        List<Customer> customers = new ArrayList<>();
//        when(adminService.getAllCustomers()).thenReturn(customers);
//
//     ResponseEntity<List<Customer>> response = adminController.getAllCustomers();
//
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//       assertEquals(customers, response.getBody());
//        verify(adminService, times(1)).getAllCustomers();
//    }
//
//    @Test
//    void testGetCustomerByIdFound() {
//        int id = 1;
//        Customer customer = new Customer();
//        when(adminService.getOneCustomer(id)).thenReturn(customer);
//
//        ResponseEntity<Customer> response = adminController.getCustomerById(id);
//
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertEquals(customer, response.getBody());
//        verify(adminService, times(1)).getOneCustomer(id);
//    }
//
//    @Test
//    void testGetCustomerByIdNotFound() {
//        int id = 1;
//        when(adminService.getOneCustomer(id)).thenThrow(ResourceNotFoundException.class);
//
//        ResponseEntity<Customer> response = adminController.getCustomerById(id);
//
//        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
//        verify(adminService, times(1)).getOneCustomer(id);
//    }
//
//    @Test
//    void testAddCustomer() {
//        Customer customer = new Customer();
//
//        ResponseEntity<Void> response = adminController.addCustomer(customer);
//
//        assertEquals(HttpStatus.CREATED, response.getStatusCode());
//        verify(adminService, times(1)).addCustomer(customer);
//    }
//
//    @Test
//    void testDeleteCustomerSuccess() {
//        int id = 1;
//        when(adminService.deleteCustomer(id)).thenReturn(true);
//
//        ResponseEntity<Void> response = adminController.deleteCustomer(id);
//
//        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
//        verify(adminService, times(1)).deleteCustomer(id);
//    }

    @Test
    void testDeleteCustomerNotFound() {
        int id = 1;
        when(adminService.deleteCustomer(id)).thenReturn(false);

        adminController.deleteCustomer(id);

        //assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(adminService, times(1)).deleteCustomer(id);
    }
}
