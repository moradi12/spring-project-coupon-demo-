package Openconnection.example.demo.Controllers;

import Openconnection.example.demo.Exceptions.CompanyAlreadyExistsException;
import Openconnection.example.demo.Exceptions.CompanyNotFoundException;
import Openconnection.example.demo.Service.CompanyService;
import Openconnection.example.demo.beans.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Company> addCompany(@RequestBody Company company) {
        try {
            companyService.addCompany(company);
            return new ResponseEntity<>(company, HttpStatus.CREATED);
        } catch (CompanyAlreadyExistsException | CompanyNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // Endpoint to update a company
    @PutMapping("/{id}")
    public ResponseEntity<Company> updateCompany(@PathVariable int id, @RequestBody Company company) {
        try {
            companyService.updateCompany(company);
            return new ResponseEntity<>(company, HttpStatus.OK);
        } catch (CompanyNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint to delete a company
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompany(@PathVariable int id) {
        try {
            companyService.deleteCompany(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (CompanyNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint to retrieve all companies
    @GetMapping("/all")
    public ResponseEntity<List<Company>> getAllCompanies() {
        List<Company> companies = companyService.getAllCompanies();
        return new ResponseEntity<>(companies, HttpStatus.OK);
    }

    // Endpoint to retrieve a company by ID
    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable int id) {
        try {
            return ResponseEntity.of(companyService.getOneCompany(id));
        } catch (CompanyNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
