//package Openconnection.example.demo.database.Service;
//
//
//import Openconnection.example.demo.Exceptions.CompanyNotFoundException;
//import Openconnection.example.demo.Exceptions.CustomerException;
//import Openconnection.example.demo.database.beans.Customer;
//
//import java.util.List;
//import java.util.Optional;
//
//public interface CustomerService {
//    boolean isCustomerExists(String email, String password) throws CustomerException;
//
//    void addCustomer(Customer customer) throws CustomerException;
//
//    void saveCustomer(Customer customer) throws CustomerException;
//
//    void updateCustomer(Customer customer) throws CustomerException;
//
//    void deleteCustomer(int customerID);
//
//    Optional<Customer> getOneCustomer(int customerID) throws CustomerException;
//
//    List<Customer> findById(int id);
//
//    List<Customer> findByName(String name);
//
//    List<Customer> getCustomersByCompany(int companyId) throws CompanyNotFoundException;}
