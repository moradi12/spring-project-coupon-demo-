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
    public void addCompany(Company company) throws AdminException {
        companyRepository.save(company);
    }

    @Override
    public void updateCompany(Company company) throws AdminException {
        if (!companyRepository.existsById(company.getId())) {
            throw new AdminException("Company not found");
        }
        companyRepository.save(company);
    }

    @Override
    public void deleteCompany(int companyId) throws AdminException {
        if (!companyRepository.existsById(companyId)) {
            throw new AdminException("Company not found");
        }
        companyRepository.deleteById(companyId);
    }

    @Override
    public List<Company> getAllCompanies() throws AdminException {
        return companyRepository.findAll();
    }

    @Override
    public Company getOneCompany(int companyId) throws AdminException {
        Optional<Company> optionalCompany = companyRepository.findById(companyId);
        return optionalCompany.orElseThrow(() -> new AdminException("Company not found"));
    }

    public void addCustomer(Customer customer) throws AdminException {
        int id = customer.getId();
        if (customerRepository.existsById(id)) {
            throw new AdminException("Customer with the same ID already exists");
        }
        if (customerRepository.existsByEmail(customer.getEmail())) {
            throw new AdminException("Customer with the same email already exists");
        }
        customerRepository.save(customer);
    }
    public void updateCustomer(Customer customer) throws AdminException {
        int id = customer.getId();
        if (!customerRepository.existsById(id)) {
            throw new AdminException("Customer not found");
        }
        if (customerRepository.existsByEmail(customer.getEmail()) && !customerRepository.findById(id).get().getEmail().equals(customer.getEmail())) {
            throw new AdminException("Customer with the same email already exists");
        }
        customerRepository.saveAndFlush(customer);
    }
    @Override
    public void deleteCustomer(int customerId) throws AdminException {
        if (!customerRepository.existsById(customerId)) {
            throw new AdminException("Customer not found");
        }
        customerRepository.deleteById(customerId);
    }

    @Override
    public List<Customer> getAllCustomers() throws AdminException {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> getOneCustomer(int customerId) throws AdminException {
        return customerRepository.findById(customerId);
    }
}
