package Openconnection.example.demo.database.ServiceInterface;

import Openconnection.example.demo.Exceptions.CustomerException;
import Openconnection.example.demo.Exceptions.ErrMsg;
import Openconnection.example.demo.database.Repository.CustomerRepository;
import Openconnection.example.demo.database.beans.Customer;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    ///  boolean customerExists = customerRepository.existsByEmailAndPassword(email, password);
//        if (!customerExists) {
//            throw new CustomerException(ErrMsg.CUSTOMER_NOT_FOUND);
//        }////
    @Override
    public boolean isCustomerExists(String email, String password) throws CustomerException {
        boolean customerExists = customerRepository.existsByEmailAndPassword(email, password);
        if (!customerExists) {
            throw new CustomerException(ErrMsg.CUSTOMER_NOT_FOUND);
        }
        return true;
    }

    @Override
    public void addCustomer(Customer customer) throws CustomerException {
        if (customerRepository.existsByEmail(customer.getEmail())) {
            throw new CustomerException(ErrMsg.CUSTOMER_ALREADY_EXISTS);
        }
        customerRepository.save(customer);
    }

    @Override
    public void saveCustomer(Customer customer) throws CustomerException {
        if (!customerRepository.existsById(customer.getId())) {
            throw new CustomerException(ErrMsg.CUSTOMER_NOT_FOUND);

        }
        customerRepository.save(customer);
    }

    @Override
    public void updateCustomer(Customer customer) throws CustomerException {
        if (!customerRepository.existsById(customer.getId())) {
            throw new CustomerException(ErrMsg.CUSTOMER_NOT_FOUND);

        }
        customerRepository.saveAndFlush(customer);
    }

    @Override
    public void deleteCustomer(int customerID) throws CustomerException {
        if (!customerRepository.existsById(customerID)) {
            throw new CustomerException(ErrMsg.CUSTOMER_NOT_FOUND);
        }
        customerRepository.deleteById(customerID);

    }

    @Override
    public Optional<Customer> getOneCustomer(int customerID) throws CustomerException {
        Optional<Customer> customer = customerRepository.findById(customerID);
        if (customer.isEmpty()) {
            throw new CustomerException(ErrMsg.CUSTOMER_NOT_FOUND);
        }
        return customer;
    }

    @Override
    public Optional<Customer> findById(int id) throws CustomerException {
        Optional<Customer> customers = customerRepository.findById(id);
        if (customers.isEmpty()) {
            throw new CustomerException(ErrMsg.CUSTOMER_NOT_FOUND);
        }
        return customers;
    }
}
