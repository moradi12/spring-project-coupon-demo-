package Openconnection.example.demo.Service;

import Openconnection.example.demo.Exceptions.CustomerException;
import Openconnection.example.demo.beans.Customer;

import java.util.Optional;

public interface CustomerService {
    boolean isCustomerExists(String email, String password) throws CustomerException;

    void addCustomer(Customer customer) throws CustomerException;


    void updateCustomer(Customer customer) throws CustomerException;

    void deleteCustomer(int customerID) throws CustomerException;

    Optional<Customer> getOneCustomer(int customerID) throws CustomerException;

    Optional<Customer> findById(int id) throws CustomerException;
}
