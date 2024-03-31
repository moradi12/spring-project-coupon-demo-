package Openconnection.example.demo.Controllers;

import Openconnection.example.demo.Exceptions.AdminException;
import Openconnection.example.demo.Exceptions.CompanyAlreadyExistsException;
import Openconnection.example.demo.Service.AdminService;
import Openconnection.example.demo.beans.Company;
import Openconnection.example.demo.beans.Customer;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/companies")
    public String addCompany(@RequestBody Company company) {
        try {
            adminService.addCompany(company);
            return "Company added successfully!";
        } catch (CompanyAlreadyExistsException e) {
            return e.getMessage();
        }
    }

    @PutMapping("/companies/{companyId}")
    public String updateCompany(@PathVariable int companyId, @RequestBody Company company) {
        try {
            company.setId(companyId);
            adminService.updateCompany(company);
            return "Company updated successfully!";
        } catch (AdminException | CompanyAlreadyExistsException e) {
            return e.getMessage();
        }
    }

    @DeleteMapping("/companies/{companyId}")
    public String deleteCompany(@PathVariable int companyId) {
        adminService.deleteCompany(companyId);
        return "Company deleted successfully!";
    }

    @GetMapping("/companies")
    public List<Company> getAllCompanies(@RequestHeader(name = "Autorotation") String token) {
        return adminService.getAllCompanies();
    }

    @GetMapping("/companies/{companyId}")
    public Company getOneCompany(@PathVariable int companyId) {
        return adminService.getOneCompany(companyId);
    }

    @PostMapping("/customers")
    public String addCustomer(@RequestBody Customer customer) {
        try {
            adminService.addCustomer(customer);
            return "Customer added successfully!";
        } catch (AdminException e) {
            return e.getMessage();
        }
    }

    @PutMapping("/customers/{customerId}")
    public String updateCustomer(@PathVariable int customerId, @RequestBody Customer customer) {
        try {
            customer.setCustomerID(customerId);
            adminService.updateCustomer(customer);
            return "Customer updated successfully!";
        } catch (AdminException e) {
            return e.getMessage();
        }
    }

    @DeleteMapping("/customers/{customerId}")
    public String deleteCustomer(@PathVariable int customerId) {
        adminService.deleteCustomer(customerId);
        return "Customer deleted successfully!";
    }

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return adminService.getAllCustomers();
    }

    @GetMapping("/customers/{customerId}")
    public Optional<Customer> getOneCustomer(@PathVariable int customerId) {
        return adminService.getOneCustomer(customerId);
    }
}
