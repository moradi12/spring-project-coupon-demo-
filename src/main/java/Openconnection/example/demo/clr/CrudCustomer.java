package Openconnection.example.demo.clr;

import Openconnection.example.demo.Exceptions.CustomerException;
import Openconnection.example.demo.Exceptions.ErrMsg;
import Openconnection.example.demo.database.Repository.CustomerRepository;
import Openconnection.example.demo.database.beans.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
public class CrudCustomer implements CommandLineRunner {

    private final CustomerRepository customerRepository;

    @Autowired
    public CrudCustomer(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    /**
     * Runs the command line task to add customers
     */
    @Override
    public void run(String... args) throws Exception {
        try {
            addCustomer("John", "Doe", "john@example.com", "password123");
            addCustomer("Dani", "Dean", "Dean@mail.com", "pas321");
            addCustomer("Janna", "Smith", "janna@botic.com", "password456");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Adds a customer to the database if it doesn't already exist
     * @param firstName The first name of the customer
     * @param lastName The last name of the customer
     * @param email The email of the customer
     * @param password The password of the customer
     */

    private void addCustomer(String firstName, String lastName, String email, String password) {
        if (!customerRepository.existsByEmailAndPassword(email, password)) {
            Customer customer = Customer.builder()
                    .firstName(firstName)
                    .lastName(lastName)
                    .email(email)
                    .password(password)
                    .build();
            customerRepository.save(customer);
            System.out.println("Customer '" + firstName + " " + lastName + "' successfully added");
        } else {
            throw new RuntimeException(ErrMsg.CUSTOMER_ALREADY_EXISTS.getMsg());
        }
    }
}
