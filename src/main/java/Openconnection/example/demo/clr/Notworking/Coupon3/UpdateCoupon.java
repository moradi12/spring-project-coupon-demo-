//package Openconnection.example.demo.clr.Coupon;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.core.annotation.Order;
//
//import java.time.LocalDate;
//import java.util.Optional;
//
////@Component
//@Order(4)
//public class UpdateCoupon implements CommandLineRunner {
//
//    @Autowired
//    CouponRepository couponRepository;
//
//    @Override
//    public void run(String... args) throws Exception {
//        updateCoupon();
//    }
//    /**
//     * Updates a coupon with new information
//     */
//    private void updateCoupon() {
//        Optional<Coupon> optionalCoupon = couponRepository.findById(2);
//        if (optionalCoupon.isPresent()) {
//            Coupon coupon = optionalCoupon.get();
//            coupon.setCompany_Id(5);
//            coupon.setCategory_Id(5);
//            coupon.setTitle("Coupon Title V2");
//            coupon.setDescription("Coupon Description updated");
//            coupon.setStart_Date(LocalDate.now());
//            coupon.setEndDate(LocalDate.now().plusDays(30));
//            coupon.setAmount(3);
//            coupon.setPrice(9.99);
//            coupon.setImage("coupon_new_img.jpg");
//            couponRepository.saveAndFlush(coupon);
//        } else {
//            System.out.println(ErrMsg.COUPON_ID_NOT_FOUND.getMsg());
//        }
//    }
//}
