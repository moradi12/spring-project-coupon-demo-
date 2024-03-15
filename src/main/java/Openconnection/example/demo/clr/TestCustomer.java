package Openconnection.example.demo.clr;


import Openconnection.example.demo.Exceptions.CustomerException;
import Openconnection.example.demo.Service.CustomerService;
import Openconnection.example.demo.beans.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestCustomer implements CommandLineRunner {

    private final CustomerService customerService;

    @Autowired
    public TestCustomer(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public void run(String... args) {
        try {
            // Creating and saving the first customer
            Customer customer1 = Customer.builder()
                    .id(1)
                    .firstName("Idan")
                    .lastName("Naor")
                    .email("john@mail.com")
                    .password("password123")
                    .build();

            // Creating and saving the second customer
            Customer customer2 = Customer.builder()
                    .id(2)
                    .firstName("Jane")
                    .lastName("Smith")
                    .email("jane@smith.com")
                    .password("password456")
                    .build();


            // Creating and saving the third customer
            Customer customer3 = Customer.builder()
                    .id(3)
                    .firstName("Alice")
                    .lastName("Johnson")
                    .email("alice@mail.com")
                    .password("password789")
                    .build();
        } catch (Exception e) {
            System.err.println("Unexpected error occurred: " + e.getMessage());
        }
    }
}
