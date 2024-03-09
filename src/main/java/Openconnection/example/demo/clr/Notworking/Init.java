//package Openconnection.example.demo.clr;
//
//import Openconnection.example.demo.Exceptions.ErrMsg;
//import Openconnection.example.demo.database.Service.CompanyService;
//import Openconnection.example.demo.database.Service.CouponService;
//import Openconnection.example.demo.database.Service.CustomerService;
//import Openconnection.example.demo.database.beans.Category;
//import Openconnection.example.demo.database.beans.Company;
//import Openconnection.example.demo.database.beans.Coupon;
//import Openconnection.example.demo.database.beans.Customer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.core.annotation.Order;
//
//import java.sql.Date;
//import java.time.LocalDate;
//
//@Order(1)
//public class Init implements CommandLineRunner {
//    private final CustomerService customerService;
//    private final CompanyService companyService;
//    private final CouponService couponService;
//
//    @Autowired
//    public Init(CustomerService customerService, CompanyService companyService, CouponService couponService) {
//        this.customerService = customerService;
//        this.companyService = companyService;
//        this.couponService = couponService;
//    }
//
//    /**
//     * Runs the command line task to initialize the application
//     * @param args Command line arguments.
//     * @throws Exception If an error occurs during execution
//     */
//
//    @Override
//    public void run(String... args) throws Exception {
//        System.out.println("Running init class......");
//        try {
//            // Add Company
//            companyService.addCompany(Company.builder()
//                    .id(43)
//                    .email("Try@mail.com")
//                    .name("Tamir")
//                    .password("123456")
//                    .build());
//
//            // Add Customer
//            customerService.addCustomer(Customer.builder()
//                    .id(23)
//                    .email("BestCustomer@mail.com")
//                    .firstName("Dobi")
//                    .lastName("Bot")
//                    .password("4899")
//                    .build());
//
//            // Add Coupon
//            couponService.addCoupon(Coupon.builder()
//                    .companyId(0)
//                    .category(Category.Food) // Using custom enum
//                    .title("Coupon TitleHardcode")
//                    .description("Hotel")
//                    .startDate(Date.valueOf(LocalDate.now()))
//                    .endDate(Date.valueOf(LocalDate.now().plusDays(30)))
//                    .amount(10)
//                    .price(9.99)
//                    .image("coupon_image.jpg")
//                    .build());
//        } catch (Exception e) {
//            System.out.println(ErrMsg.DATABASE_CONNECTION_ERROR.getMsg());
//        }
//    }
//}
