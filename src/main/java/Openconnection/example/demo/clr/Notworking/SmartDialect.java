//package Openconnection.example.demo.clr;
//
//import com.coupon.project.database.Repository.CouponRepository;
//import com.coupon.project.database.beans.Coupon;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
//@Component
//public class SmartDialect implements CommandLineRunner {
//
//    private final CouponRepository couponRepository;
//
//    @Autowired
//    public SmartDialect(CouponRepository couponRepository) {
//        this.couponRepository = couponRepository;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        //  repo test
//        List<Coupon> findByPriceLessThan = couponRepository.findByPriceLessThan(100.00);
//        List<Coupon> couponStartWith = couponRepository.findByNameStartingWith("PC");
//        List<Coupon> findByCompanyId = couponRepository.findByCompanyId(3);
//        List<Coupon> findByNameOrId = couponRepository.findByNameOrId("Hotel", 4);
//
//    }
//}
