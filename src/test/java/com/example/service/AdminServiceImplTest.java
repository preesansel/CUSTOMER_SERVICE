package com.example.service;
import com.example.exceptions.ResourceNotFoundException;
import com.example.model.Customer;
import com.example.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AdminServiceImplTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private AdminServiceImpl adminService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        when(customerRepository.findAll()).thenReturn(customers);

        List<Customer> result = adminService.getAllCustomers();

        assertEquals(customers, result);
        verify(customerRepository, times(1)).findAll();
    }

    @Test
    void testGetOneCustomerFound() {
        int id = 1;
        Customer customer = new Customer();
        when(customerRepository.findById(id)).thenReturn(Optional.of(customer));

        Customer result = adminService.getOneCustomer(id);

        assertEquals(customer, result);
        verify(customerRepository, times(1)).findById(id);
    }

    @Test
    void testGetOneCustomerNotFound() {
        int id = 1;
        when(customerRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> adminService.getOneCustomer(id));
        verify(customerRepository, times(1)).findById(id);
    }

    @Test
    void testAddCustomer() {
        Customer customer = new Customer();
        adminService.addCustomer(customer);

        verify(customerRepository, times(1)).save(customer);
    }

    @Test
    void testDeleteCustomerExists() {
        int id = 1;
        when(customerRepository.existsById(id)).thenReturn(true);

        boolean result = adminService.deleteCustomer(id);

        assertTrue(result);
        verify(customerRepository, times(1)).deleteById(id);
    }

    @Test
    void testDeleteCustomerNotExists() {
        int id = 1;
        when(customerRepository.existsById(id)).thenReturn(false);

        assertThrows(ResourceNotFoundException.class, () -> adminService.deleteCustomer(id));
        verify(customerRepository, times(1)).existsById(id);
    }
}
