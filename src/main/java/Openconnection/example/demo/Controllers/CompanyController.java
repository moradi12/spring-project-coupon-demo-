package Openconnection.example.demo.Controllers;

import Openconnection.example.demo.Exceptions.CompanyAlreadyExistsException;
import Openconnection.example.demo.Exceptions.CompanyNotFoundException;
import Openconnection.example.demo.Service.CompanyService;
import Openconnection.example.demo.beans.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {

    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    // Endpoint to add a company
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Company addCompany(@RequestBody Company company) throws CompanyAlreadyExistsException, CompanyNotFoundException {
        companyService.addCompany(company);
        return company;
    }

    // Endpoint to update a company
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Company updateCompany(@PathVariable int id, @RequestBody Company company) throws CompanyNotFoundException {
        companyService.updateCompany(company);
        return company;
    }

    // Endpoint to delete a company
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCompany(@PathVariable int id) throws CompanyNotFoundException {
        companyService.deleteCompany(id);
    }

    // Endpoint to retrieve all companies
    @GetMapping("/all")
    public List<Company> getAllCompanies() {
        return companyService.getAllCompanies();
    }

    // Endpoint to retrieve a company by ID
    @GetMapping("/{id}")
    public Company getCompanyById(@PathVariable int id) throws CompanyNotFoundException {
        return companyService.getOneCompany(id).orElseThrow();
    }
}
