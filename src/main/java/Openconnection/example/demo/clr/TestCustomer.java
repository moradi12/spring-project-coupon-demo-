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
//
//            System.out.println("Adding customer 2...");
//            Customer customer2 = Customer.builder()
//                    .id(2)
//                    .firstName("Jane")
//                    .lastName("Smith")
//                    .email("jane@smith.com")
//                    .password("password456")
//                    .coupon(couponService.getOneCoupon(2))
//                    .build();
//            customerService.addCustomer(customer2);

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



            // Printing all customers
            System.out.println("All Customers after adding:");
            customerService.getAllCustomers().forEach(System.out::println);

            // Deleting a customer with ID 2
            System.out.println("Deleting customer with ID 2...");
        //    customerService.deleteCustomer(2);
            System.out.println("Remaining Customers after deletion:");
            customerService.getAllCustomers().forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}














//
//            System.out.println("Posting customers to API...");
//            restTemplate.postForEntity("http://localhost:8080/api/customers", customer1, Customer.class);
//            restTemplate.postForEntity("http://localhost:8080/api/customers", customer2, Customer.class);
//            restTemplate.postForEntity("http://localhost:8080/api/customers", customer3, Customer.class);
//            restTemplate.postForEntity("http://localhost:8080/api/customers", customer4, Customer.class);
//
//            System.out.println("Getting all customers from API...");
//            System.out.println(restTemplate.getForObject("http://localhost:8080/api/customers/all", String.class));
//
//            System.out.println("Deleting customer with ID 2 from API...");
//            restTemplate.delete("http://localhost:8080/api/customers/{id}", 2);
//            System.out.println("Getting all customers after deletion from API...");
//            Customer[] customers = restTemplate.getForObject("http://localhost:8080/api/customers/all", Customer[].class);
//            if (customers != null) {
//                Arrays.stream(customers).forEach(System.out::println);
//            }
//
//            System.out.println("Getting customers by first name from API...");
//            Customer[] customersByFirstName = restTemplate.getForObject("http://localhost:8080/api/customers/byFirstName/{firstName}", Customer[].class, "Alice");
//            if (customersByFirstName != null) {
//                Arrays.stream(customersByFirstName).forEach(System.out::println);
//            }
//        } catch (Exception e) {
//            System.out.println("Error occurred: " + e.getMessage());
//        }
//    }
//}
