package Openconnection.example.demo.Service;

import Openconnection.example.demo.Exceptions.CustomerException;
import Openconnection.example.demo.beans.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService extends ClientService {
    boolean isCustomerExists(String email, String password) throws CustomerException;
    boolean isCustomerExistsByEmail(String email) throws CustomerException; // New method to check existence by email
    void addCustomer(Customer customer) throws CustomerException;

    List<Customer> getAllCustomers() throws CustomerException;

    void updateCustomer(Customer customer) throws CustomerException;

    void deleteCustomer(int customerID) throws CustomerException;

    Optional<Customer> getOneCustomer(int customerID) throws CustomerException;

    Optional<Customer> findById(int id) throws CustomerException;

}
