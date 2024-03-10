//package Openconnection.example.demo.clr.Coupon;
//
//import com.coupon.project.database.Repository.CouponRepository;
//import com.coupon.project.database.beans.Coupon;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
////@Component
//public class CreateCoupon implements CommandLineRunner {
//    @Autowired
//    CouponRepository couponRepository;
//
//
//    /**
//     * Runs the command line task to create and save sample coupons
//     * @param args Command line arguments
//     * @throws Exception If an error occurs during execution
//     */
//
//    @Override
//    public void run(String... args) throws Exception {
//        List<Coupon> coupons = new ArrayList<>();
//
//        Coupon coupon1 = Coupon.builder()
//                .company_Id(1) // Set company ID
//                .category_Id(1) // Set category ID
//                .title("Coupon Title") // Set title
//                .description("Hotel") // Set description
//                .start_Date(LocalDate.now()) // Set start date
//                .endDate(LocalDate.now().plusDays(30))
//                .amount(10) // Set amount
//                .price(9.99) // Set price
//                .image("coupon_image.jpg") // Set image
//                .build(); // Build the Coupon instance
//
//
//        Coupon coupon2 = Coupon.builder()
//                .company_Id(2)
//                .category_Id(2)
//                .title("Pc stuff")
//                .description("Pc products discount")
//                .start_Date(LocalDate.now().plusDays(30))
//                .amount(4)
//                .price(80.99)
//                .image("coupon_Pc_image.jpg")
//                .build();
//
//        Coupon coupon3 = Coupon.builder()
//                .company_Id(3)
//                .category_Id(3)
//                .title("Vacation")
//                .description("Vacation discount")
//                .start_Date(LocalDate.now().plusDays(50))
//                .amount(10)
//                .price(33.90)
//                .image("spa.jpg")
//                .build();
//
//
//        ////SAVE!!!!!////
//        coupons.add(coupon1);
//        coupons.add(coupon2);
//        coupons.add(coupon3);
//        couponRepository.saveAll(coupons);
//        couponRepository.saveAll(Arrays.asList(coupon1, coupon2, coupon3));
//
//
//    }
//}
