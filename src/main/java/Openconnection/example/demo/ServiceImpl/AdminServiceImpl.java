package Openconnection.example.demo.ServiceImpl;

import Openconnection.example.demo.Repository.CompanyRepository;
import Openconnection.example.demo.Repository.CustomerRepository;
import Openconnection.example.demo.beans.Company;
import Openconnection.example.demo.beans.Customer;
import Openconnection.example.demo.Service.AdminService;
import Openconnection.example.demo.Exceptions.AdminException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void addCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public void updateCompany(Company company) {
        if (!companyRepository.existsById(company.getId())) {
            throw new AdminException("Company not found");
        }
        companyRepository.save(company);
    }

    @Override
    public void deleteCompany(int companyId) {
        if (!companyRepository.existsById(companyId)) {
            throw new AdminException("Company not found");
        }
        companyRepository.deleteById(companyId);
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Company getOneCompany(int companyId) {
        Optional<Company> optionalCompany = companyRepository.findById(companyId);
        return optionalCompany.orElse(null);
    }

    @Override
    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void updateCustomer(Customer customer) {
        if (!customerRepository.existsById(customer.getId())) {
            throw new AdminException("Customer not found");
        }
        customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(int customerId) {
        if (!customerRepository.existsById(customerId)) {
            throw new AdminException("Customer not found");
        }
        customerRepository.deleteById(customerId);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> getOneCustomer(int customerId) {
        return customerRepository.findById(customerId);
    }
}