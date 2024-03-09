//package Openconnection.example.demo.clr.Coupon;
//
//import com.coupon.project.database.Repository.CouponRepository;
//import com.coupon.project.database.beans.Coupon;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.core.annotation.Order;
//
//import java.util.Optional;
//
////@Component
//@Order(3)
//public class DeleteCoupon implements CommandLineRunner {
//
//
//    @Autowired
//    CouponRepository couponRepository;
//
//    /**
//     * Runs the command line task to delete a coupon
//     *
//     * @param args Command line arguments
//     * @throws Exception If an error occurs during execution
//     */
//
//    @Override
//    public void run(String... args) throws Exception {
//
//        Optional<Coupon> couponToDelete = couponRepository.findById(1); // Change the ID to the one you want to delete...
//        couponToDelete.ifPresent(couponRepository::delete);
//    }
//}
