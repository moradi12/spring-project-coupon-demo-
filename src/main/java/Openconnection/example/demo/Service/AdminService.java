package Openconnection.example.demo.Service;

import Openconnection.example.demo.beans.Company;
import Openconnection.example.demo.beans.Customer;

import java.util.List;
import java.util.Optional;

public interface AdminService {

   // boolean login(String email,String password);
    void addCompany(Company company);
    void updateCompany(Company company);
    void deleteCompany(int CompanyID);
    List<Company> getAllCompanies();

    // Modified method to return a single Company object
    Company getOneCompany(int CompanyID);

    // Customer Side
    void addCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void deleteCustomer(int customerID);
    List<Customer> getAllCustomers();
    Optional<Customer> getOneCustomer(int customerID);
}


