package Openconnection.example.demo.Controllers;
import Openconnection.example.demo.Exceptions.AdminException;
import Openconnection.example.demo.Exceptions.CompanyAlreadyExistsException;
import Openconnection.example.demo.Exceptions.CompanyNotFoundException;
import Openconnection.example.demo.Exceptions.CustomerException;
import Openconnection.example.demo.Service.AdminService;
import Openconnection.example.demo.beans.Company;
import Openconnection.example.demo.beans.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    private final AdminService adminService;
    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String email, @RequestParam String password) {
        try {
            if (adminService.Login(email, password)) {
                return ResponseEntity.ok("Login successful!");
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed!");
            }
        } catch (AdminException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (CustomerException | CompanyNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @PostMapping("/companies")
    public ResponseEntity<String> addCompany(@RequestBody Company company) {
        try {
            adminService.addCompany(company);
            return ResponseEntity.status(HttpStatus.CREATED).body("Company added successfully!");
        } catch (CompanyAlreadyExistsException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    @PutMapping("/companies/{companyId}")
    public ResponseEntity<String> updateCompany(@PathVariable int companyId, @RequestBody Company company) {
        try {
            company.setId(companyId);
            adminService.updateCompany(company);
            return ResponseEntity.ok("Company updated successfully!");
        } catch (AdminException | CompanyAlreadyExistsException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    @DeleteMapping("/companies/{companyId}")
    public ResponseEntity<String> deleteCompany(@PathVariable int companyId) {
        adminService.deleteCompany(companyId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Company deleted successfully!");
    }
    @GetMapping("/companies")
    public ResponseEntity<List<Company>> getAllCompanies() {
        List<Company> companies = adminService.getAllCompanies();
        return ResponseEntity.ok(companies);
    }

    @GetMapping("/companies/{companyId}")
    public ResponseEntity<Company> getOneCompany(@PathVariable int companyId) {
        Company company = adminService.getOneCompany(companyId);
        return ResponseEntity.ok(company);
    }

    @PostMapping("/customers")
    public ResponseEntity<String> addCustomer(@RequestBody Customer customer) {
        try {
            adminService.addCustomer(customer);
            return ResponseEntity.status(HttpStatus.CREATED).body("Customer added successfully!");
        } catch (AdminException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/customers/{customerId}")
    public ResponseEntity<String> updateCustomer(@PathVariable int customerId, @RequestBody Customer customer) {
        try {
            customer.setId(customerId);
            adminService.updateCustomer(customer);
            return ResponseEntity.ok("Customer updated successfully!");
        } catch (AdminException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/customers/{customerId}")
    public ResponseEntity<String> deleteCustomer(@PathVariable int customerId) {
        adminService.deleteCustomer(customerId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Customer deleted successfully!");
    }

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = adminService.getAllCustomers();
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/customers/{customerId}")
    public ResponseEntity<Customer> getOneCustomer(@PathVariable int customerId) {
        Optional<Customer> customer = adminService.getOneCustomer(customerId);
        return customer.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}