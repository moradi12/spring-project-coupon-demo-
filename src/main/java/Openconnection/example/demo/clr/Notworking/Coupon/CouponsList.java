//package Openconnection.example.demo.clr.Coupon;
//
//import com.coupon.project.database.Repository.CouponRepository;
//import com.coupon.project.database.beans.Coupon;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//
//import java.util.List;
//
//public class CouponsList implements CommandLineRunner {
//    @Autowired
//    CouponRepository couponRepository;
//
//    @Override
//    public void run(String... args) throws Exception {
//
//
//        List<Coupon> allCoupons = couponRepository.findAll();
//        allCoupons.forEach(System.out::println);
//
//
//    }
//}
