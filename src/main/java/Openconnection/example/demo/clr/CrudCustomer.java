package Openconnection.example.demo.clr;

import Openconnection.example.demo.Exceptions.ErrMsg;
import Openconnection.example.demo.database.Repository.CustomerRepository;
import Openconnection.example.demo.database.beans.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CrudCustomer implements CommandLineRunner {

    private final CustomerRepository customerRepository;

    @Autowired
    public CrudCustomer(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        addCustomer("John", "Doe", "john@example.com", "password123");
        addCustomer("Janna", "Smith", "janna@example.com", "password456");
    }

    private void addCustomer(String firstName, String lastName, String email, String password) {
        if (!customerRepository.existsByEmailAndPassword(email, password)) {
            Customer customer = Customer.builder()
                    .firstName(firstName)
                    .lastName(lastName)
                    .email(email)
                    .password(password)
                    .build();
            customerRepository.save(customer);
            System.out.println("Customer '" + firstName + " " + lastName + "' successfully added.");
        } else {
            throw new RuntimeException(ErrMsg.CUSTOMER_ALREADY_EXISTS.getMsg());
        }
    }
}
