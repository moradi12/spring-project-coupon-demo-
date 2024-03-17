package Openconnection.example.demo.ServiceImpl;

import Openconnection.example.demo.Exceptions.AdminException;
import Openconnection.example.demo.Exceptions.CompanyNotFoundException;
import Openconnection.example.demo.Exceptions.CustomerException;
import Openconnection.example.demo.Exceptions.ErrMsg;
import Openconnection.example.demo.Repository.CustomerRepository;
import Openconnection.example.demo.Service.CustomerService;
import Openconnection.example.demo.beans.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public boolean isCustomerExists(String email, String password) throws CustomerException {
        if (!customerRepository.existsByEmailAndPassword(email, password)) {
            throw new CustomerException(ErrMsg.AUTHENTICATION_FAILED);
        }
        return true;
    }

    @Override
    public void addCustomer(Customer customer) throws CustomerException {
        if (customerRepository.existsById(customer.getId()) || customerRepository.existsByEmail(customer.getEmail())) {
            throw new CustomerException(ErrMsg.CUSTOMER_ALREADY_EXISTS);
        }
        customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public void updateCustomer(Customer customer) throws CustomerException {
        int id = customer.getId();
        if (!customerRepository.existsById(id)) {
            throw new CustomerException(ErrMsg.CUSTOMER_NOT_FOUND);
        }
        Optional<Customer> existingCustomerByEmail = customerRepository.findByEmail(customer.getEmail());
        if (existingCustomerByEmail.isPresent() && existingCustomerByEmail.get().getId() != id) {
            throw new CustomerException(ErrMsg.CUSTOMER_ALREADY_EXISTS);
        }
        customerRepository.saveAndFlush(customer);

        System.out.println("Customer updated" + customer);
    }

    @Override
    public void deleteCustomer(int customerID) throws CustomerException {
        if (!customerRepository.existsById(customerID)) {
            throw new CustomerException(ErrMsg.CUSTOMER_NOT_FOUND);
        }
        customerRepository.deleteById(customerID);
        System.out.println("Customer deleted " + customerID);
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
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isEmpty()) {
            throw new CustomerException(ErrMsg.CUSTOMER_NOT_FOUND);
        }
        return customer;
    }

    @Override
    public boolean Login(String email, String password) throws AdminException, CompanyNotFoundException, CustomerException {
        Optional<Customer> customerOptional = customerRepository.findByEmailAndPassword(email, password);
        if (customerOptional.isPresent()) {
            return true;
        } else {
            throw new CustomerException(ErrMsg.AUTHENTICATION_FAILED);
        }
    }
}

