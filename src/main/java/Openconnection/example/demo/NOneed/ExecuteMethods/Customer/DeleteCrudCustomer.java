//package Openconnection.example.demo.clr.Customer;
//
//import Openconnection.example.demo.Exceptions.ErrMsg;
//import Openconnection.example.demo.database.Repository.CustomerRepository;
//import Openconnection.example.demo.database.beans.Customer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//import java.util.Optional;
//
//@Component
//@Order(6)
//public class DeleteCrudCustomer implements CommandLineRunner {
//    private final CustomerRepository customerRepository;
//
//    @Autowired
//    public DeleteCrudCustomer(CustomerRepository customerRepository) {
//        this.customerRepository = customerRepository;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        int customerIdToDelete = 4; // Change the ID the customer id u want to delete
//        System.out.println("Deleting customer with ID: " + customerIdToDelete);
//        deleteCustomerById(customerIdToDelete);
//    }
//
//    /**
//     * Deletes a customer by their ID
//     * @param id The ID of the customer to be deleted
//     */
//    private void deleteCustomerById(int id) {
//        Optional<Customer> optionalCustomer = customerRepository.findById(id);
//        if (optionalCustomer.isPresent()) {
//            Customer customer = optionalCustomer.get();
//            customerRepository.delete(customer);
//            System.out.println("Customer '" + customer.getFirstName() + " " +
//                    customer.getLastName() + "' with ID '" + id + "' successfully deleted");
//            System.out.println("Deletion successful.");
//        } else {
//            System.out.println(ErrMsg.CUSTOMER_NOT_FOUND.getMsg());
//        }
//    }
//}
