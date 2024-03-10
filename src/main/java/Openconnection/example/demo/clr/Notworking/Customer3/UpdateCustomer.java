//package Openconnection.example.demo.clr.Customer;
//
//import com.coupon.project.database.Exceptions.CustomerException;
//import com.coupon.project.database.Exceptions.ErrMsg;
//import com.coupon.project.database.Service.CustomerService;
//import com.coupon.project.database.beans.Customer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//
//import java.util.Optional;
//
///**
// * A command-line runner component to update customer information.
// */
//public class UpdateCustomer implements CommandLineRunner {
//    @Autowired
//    CustomerService customerService;
//
//    /**
//     * Runs the update process when the application starts.
//     *
//     * @param args Command-line arguments
//     * @throws Exception If an error occurs during the update process
//     */
//    @Override
//    public void run(String... args) throws Exception {
//        int customerIdToUpdate = 1; // Change to the actual ID you want to update
//
//        try {
//            Optional<Customer> optionalCustomer = customerService.getOneCustomer(customerIdToUpdate);
//
//            // Check if the customer exists
//            if (optionalCustomer.isPresent()) {
//
//                // If the customer exists, update it
//                Customer customerToUpdate = optionalCustomer.get();
//                customerToUpdate.setFirstName("David  ");
//                customerToUpdate.setLast_Name("Ars Gadol");
//                customerToUpdate.setEmail("ArsGadol@mail.com");
//                customerToUpdate.setPassword("passwordA");
//
//
//                // Save the updated customer
//                customerService.updateCustomer(customerToUpdate);
//                System.out.println("Customer with ID " + customerIdToUpdate + " updated successfully.");
//            } else {
//                throw new CustomerException(ErrMsg.CUSTOMER_NOT_FOUND);
//            }
//        } catch (CustomerException e) {
//            System.out.println("Error updating customer: " + e.getMessage());
//        }
//    }
//}
