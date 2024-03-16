package Openconnection.example.demo.Service;

import Openconnection.example.demo.Exceptions.AdminException;
import Openconnection.example.demo.beans.Company;
import Openconnection.example.demo.beans.Customer;

import java.util.List;
import java.util.Optional;

public interface AdminService {

   // boolean login(String email,String password);
    void addCompany(Company company)throws AdminException;
    void updateCompany(Company company)throws AdminException;
    void deleteCompany(int CompanyID)throws AdminException;
    List<Company> getAllCompanies();

    // Modified method to return a single Company object
    Company getOneCompany(int CompanyID)throws AdminException;

    // Customer Side
    void addCustomer(Customer customer)throws AdminException;
    void updateCustomer(Customer customer)throws AdminException;
    void deleteCustomer(int customerID)throws AdminException;
    List<Customer> getAllCustomers();
    Optional<Customer> getOneCustomer(int customerID)throws AdminException;
}


