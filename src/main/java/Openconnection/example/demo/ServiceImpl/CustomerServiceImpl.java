package Openconnection.example.demo.ServiceImpl;

import Openconnection.example.demo.Exceptions.CompanyNotFoundException;
import Openconnection.example.demo.Exceptions.CouponNotFoundException;
import Openconnection.example.demo.Exceptions.CustomerException;
import Openconnection.example.demo.Exceptions.ErrMsg;
import Openconnection.example.demo.Repository.CustomerRepository;
import Openconnection.example.demo.Service.CustomerService;
import Openconnection.example.demo.beans.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;
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
        System.out.println("Customer added " + customer);
    }


    @Override
    public void updateCustomer(Customer customer) throws CustomerException {
        if (!customerRepository.existsById(customer.getId())) {
            throw new CustomerException(ErrMsg.CUSTOMER_NOT_FOUND);

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
        System.out.println("Customer deleted " +customerID);

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
