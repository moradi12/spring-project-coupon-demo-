package Openconnection.example.demo.Controllers;

import Openconnection.example.demo.Exceptions.CompanyNotFoundException;
import Openconnection.example.demo.Exceptions.CustomerException;
import Openconnection.example.demo.Exceptions.ErrMsg;
import Openconnection.example.demo.Service.CustomerService;
import Openconnection.example.demo.beans.Customer;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/login")
    public Map<String, Boolean> login(@RequestParam String email, @RequestParam String password) throws CustomerException, CompanyNotFoundException {
        boolean isAuthenticated = customerService.Login(email, password);
        Map<String, Boolean> response = new HashMap<>();
        response.put("authenticated", isAuthenticated);
        return response;
    }

    @PostMapping("/register")
    public void registerCustomer(@Valid @RequestBody Customer customer) throws CustomerException {
        customerService.addCustomer(customer);
    }

    @PutMapping("/update/{customerId}")
    public void updateCustomer(@PathVariable int customerId, @Valid @RequestBody Customer customer) throws CustomerException {
        customer.setId(customerId); // Set the ID of the customer object from the path
        customerService.updateCustomer(customer);
    }

    @DeleteMapping("/delete/{customerId}")
    public void deleteCustomer(@PathVariable int customerId) throws CustomerException {
        customerService.deleteCustomer(customerId);
    }

    @GetMapping("/get/{customerId}")
    public Customer getCustomer(@PathVariable int customerId) throws CustomerException {
        return customerService.getOneCustomer(customerId).orElseThrow(() -> new CustomerException(ErrMsg.CUSTOMER_NOT_FOUND));
    }

    @GetMapping("/getAll")
    public List<Customer> getAllCustomers() throws CustomerException {
        return customerService.getAllCustomers();
    }
}
