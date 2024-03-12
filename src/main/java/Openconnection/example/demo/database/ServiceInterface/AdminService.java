package Openconnection.example.demo.database.ServiceInterface;

import Openconnection.example.demo.database.beans.Company;
import Openconnection.example.demo.database.beans.Customer;

import java.util.List;

public interface AdminService {

    boolean login(String email,String password);
    void addCompany(Company company);
    void updateCompany(Company company);
    void deleteCompany(int CompanyID);
    List<Company> getAllCompanies();
    List<Company> getOneCompany(int CompanyID);


    //customerSide
    void addCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void deleteCustomer(int customerID);
    List<Customer>getAllCustomers();
    void getOneCustomer(int customerID);





}
