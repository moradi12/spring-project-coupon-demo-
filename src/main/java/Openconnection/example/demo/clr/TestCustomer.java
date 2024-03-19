package Openconnection.example.demo.clr;

import Openconnection.example.demo.Service.CouponService;
import Openconnection.example.demo.Service.CustomerService;
import Openconnection.example.demo.beans.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2) // Set order value
public class TestCustomer implements CommandLineRunner {

    private final CustomerService customerService;
    private final CouponService couponService;

    @Autowired
    public TestCustomer(CustomerService customerService, CouponService couponService) {
        this.customerService = customerService;
        this.couponService = couponService;
    }

    @Override
    public void run(String... args) throws Exception {
        try {
            System.out.println("Adding predefined customers...");

            System.out.println("Adding customer 1...");
            Customer customer1 = Customer.builder()
                    .id(1)
                    .firstName("Idan")
                    .lastName("Naor")
                    .email("john@mail.com")
                    .password("password123")
                    .coupon(couponService.getOneCoupon(1))
                    .build();
            customerService.addCustomer(customer1);


            System.out.println("Adding customer 3...");
            Customer customer3 = Customer.builder()
                    .id(3)
                    .firstName("Alice")
                    .lastName("Johnson")
                    .email("alice@mail.com")
                    .password("password789")
                    .coupon(couponService.getOneCoupon(3))
                    .build();
            customerService.addCustomer(customer3);

            System.out.println("Adding customer 4...");
            Customer customer4 = Customer.builder()
                    .id(4)
                    .firstName("Ofir")
                    .lastName("Cool")
                    .email("ofir@example.com")
                    .password("ofirPassword")
                    .coupon(couponService.getOneCoupon(4))
                    .build();
            customerService.addCustomer(customer4);


            System.out.println("Adding customer 5...");
            Customer customer5 = Customer.builder()

                    .id(5)
                    .firstName("Danit")
                    .lastName("DanitD")
                    .email("Danit@example.com")
                    .password("Danit212121")
                    .coupon(couponService.getOneCoupon(5))
                    .build();
            customerService.addCustomer(customer5);


            System.out.println("Adding customer 5...");
            Customer customer6 = Customer.builder()
                    .id(6)
                    .firstName("Ben")
                    .lastName("Mocher")
                    .email("Ben@example.com")
                    .password("Benew")
                    .coupon(couponService.getOneCoupon(6))
                    .build();
            customerService.addCustomer(customer6);



            // Printing all customers
            System.out.println("All Customers after adding:");
            customerService.getAllCustomers().forEach(System.out::println);

            // Deleting a customer with ID 2
            System.out.println("Deleting customer with ID 2...");
            //customerService.deleteCustomer(2);
            System.out.println("Remaining Customers after deletion:");
            customerService.getAllCustomers().forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}