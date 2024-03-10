//package Openconnection.example.demo.clr.Customer;
//
//import com.coupon.project.database.Exceptions.CustomerException;
//import com.coupon.project.database.Exceptions.ErrMsg;
//import com.coupon.project.database.Service.CustomerService;
//import com.coupon.project.database.beans.Customer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//
////@Component
//public class CreateCustomer implements CommandLineRunner {
//    @Autowired
//    CustomerService customerService;
//
//    @Override
//    public void run(String... args) throws Exception {
//        createAndAddCustomer(1, "David", "Gonzalez", "customer@email.com", "password12");
//        createAndAddCustomer(2, "Daniel", "Rock", "Daniel@mail.com", "Daniel213");
//    }
//
//    private void createAndAddCustomer(int id, String firstName, String lastName, String email, String password) throws CustomerException {
//        try {
//            Customer customer = Customer.builder()
//                    .id(id)
//                    .firstName(firstName)
//                    .last_Name(lastName)
//                    .email(email)
//                    .password(password)
//                    .build();
//            customerService.addCustomer(customer);
//            customerService.saveCustomer(customer);
//        } catch (Exception e) {
//            throw new CustomerException(ErrMsg.CUSTOMER_ALREADY_EXISTS, e);
//        }
//    }
//}
