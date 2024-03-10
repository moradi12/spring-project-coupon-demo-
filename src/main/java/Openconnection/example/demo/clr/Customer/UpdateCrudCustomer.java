package Openconnection.example.demo.clr.Customer;

import Openconnection.example.demo.Exceptions.ErrMsg;
import Openconnection.example.demo.database.Repository.CustomerRepository;
import Openconnection.example.demo.database.beans.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Order(8)
public class UpdateCrudCustomer implements CommandLineRunner {

    @Autowired
    private CustomerRepository customerRepository;
    /**
     * Runs the command line task to update a customer.
     */
    public void run(String... args) throws Exception {
        customerRepository.findById(1)
                .ifPresentOrElse(
                        customer -> {
                            customer.setFirstName("Donatello");
                            customer.setLastName("Pro");
                            customerRepository.saveAndFlush(customer);
                            System.out.println("Customer updated successfully: " + customer);
                        },
                        () -> System.out.println(ErrMsg.CUSTOMER_NOT_FOUND.getMsg()));
    }
}

//    @Override
//    public void run(String... args) throws Exception {
//        Optional<Customer> optionalCustomer = customerRepository.findById(1); // Assuming the customer with ID 1!!!!!
//
//        if (optionalCustomer.isPresent()) {
//            Customer customer = optionalCustomer.get();
//            customer.setFirstName("Donatello");
//            customer.setLastName("Pro");
//            customerRepository.saveAndFlush(customer);
//            System.out.println("Customer updated successfully: " + customer);
//        } else {
//            System.out.println(ErrMsg.CUSTOMER_NOT_FOUND.getMsg());
//        }
//    }
//}

//
//    public void updateCouponCategory() {
//        try {
//            // Retrieve coupon c2 by its ID
//            Coupon couponToUpdate = getCouponById(2); // Assuming coupon c2 has ID 2
//            if (couponToUpdate != null) {
//                // Update coupon category to Category.Electricity
//                couponToUpdate.setCategory(Category.Electricity);
//                // Save the updated coupon and flush changes to the database
//                couponRepository.saveAndFlush(couponToUpdate);
//                System.out.println("Coupon c2 updated successfully!");
//            } else {
//                System.out.println(ErrMsg.COUPON_NOT_FOUND.getMsg());
//            }
//        } catch (CouponNotFoundException e) {
//            System.out.println(e.getMessage());
//        }
//    }
//
//    private Coupon getCouponById(Integer couponId) throws CouponNotFoundException {
//        return couponRepository.findById(couponId)
//                .orElseThrow(() -> new CouponNotFoundException(ErrMsg.COUPON_NOT_FOUND.getMsg()));
//    }

