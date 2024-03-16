package Openconnection.example.demo.ServiceImpl;

import Openconnection.example.demo.Exceptions.AdminException;
import Openconnection.example.demo.Exceptions.CompanyAlreadyExistsException;
import Openconnection.example.demo.Exceptions.ErrMsg;
import Openconnection.example.demo.Repository.CompanyRepository;
import Openconnection.example.demo.Repository.CustomerRepository;
import Openconnection.example.demo.beans.Company;
import Openconnection.example.demo.beans.Customer;
import Openconnection.example.demo.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {


    @Value("${admin.email}")
    private String adminEmail;

    @Value("${admin.password}")
    private String adminPassword;


    private final CompanyRepository companyRepository;
    private final CustomerRepository customerRepository;


    @Autowired
    public AdminServiceImpl(CompanyRepository companyRepository, CustomerRepository customerRepository) {
        this.companyRepository = companyRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public Boolean Login(String email, String password) throws AdminException {
        if (adminEmail.equals(email) && adminPassword.equals(password)) {
            System.out.println("Login successful!");
            return true;
        } else {
            throw new AdminException("Invalid email or password");
        }
    }

    @Override
    public void addCompany(Company company) throws CompanyAlreadyExistsException {
        if (companyRepository.existsById(company.getId())) {
            throw new CompanyAlreadyExistsException(ErrMsg.COMPANY_ALREADY_EXISTS.getMsg());
        }
        companyRepository.save(company);
    }

    @Override
    public void updateCompany(Company company) throws CompanyAlreadyExistsException {
        if (!companyRepository.existsById(company.getId())) {
            throw new AdminException("Company not found");
        }

        // Check if another company with the same ID exists
        if (companyRepository.existsByIdNotAndId(company.getId(), company.getId())) {
            throw new CompanyAlreadyExistsException("Another company with the same ID already exists");
        }

        // Save and flush changes to the database
        companyRepository.saveAndFlush(company);
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
        return companyRepository.findById(companyId)
                .orElseThrow(() -> new AdminException("Company not found"));
    }

    @Override
    public void addCustomer(Customer customer) {
        if (customerRepository.existsById(customer.getId())) {
            throw new AdminException("Customer with the same ID already exists");
        }
        if (customerRepository.existsByEmail(customer.getEmail())) {
            throw new AdminException("Customer with the same email already exists");
        }
        customerRepository.save(customer);
    }

    @Override
    public void updateCustomer(Customer customer) {
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
