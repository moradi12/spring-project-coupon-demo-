//package Openconnection.example.demo.clr.Coupon;
//
//import Openconnection.example.demo.Exceptions.ErrMsg;
//import Openconnection.example.demo.database.Repository.CouponRepository;
//import Openconnection.example.demo.database.beans.Category;
//import Openconnection.example.demo.database.beans.Coupon;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//
//import java.sql.Date;
//
//@Component
//@Order(1)
//public class CrudCoupon implements CommandLineRunner {
//
//    @Autowired
//    CouponRepository couponRepository;
//
//    @Override
//    public void run(String... args) {
//        try {
//            createCoupon("Food Coupon", Category.Food, " coupon", 10, 19.99, "image-url");
//            createCoupon("PC", Category.Computer, " pc Discount", 17, 69.99, "image-url");
//            createCoupon("Hotels discount", Category.Vacation, " Vacation Discount", 5, 799.90, "image-url");
//            createCoupon("PS5 discount", Category.Electricity, " PS5", 8, 999.90, "image-url");
//        } catch (Exception e) {
//            System.out.println("Error occurred during coupon creation: " + ErrMsg.COUPON_ERROR.getMsg());
//        }
//    }
//
//    private void createCoupon(String title, Category category, String description, int amount, double price, String image) {
//        Coupon existingCoupon = couponRepository.findByTitle(title);
//
//        if (existingCoupon != null) {
//            System.out.println("Coupon '" + title + "' already exists. Skipping creation.");
//            return; // Exit the method without creating a new coupon
//        }
//
//        Coupon coupon = Coupon.builder()
//                .category(category)
//                .description(description)
//                .title(title)
//                .startDate(new Date(System.currentTimeMillis()))
//                .endDate(new Date(System.currentTimeMillis() + (24 * 60 * 60 * 1000))) // Set the end date (example: 1 day ahead)
//                .amount(amount)
//                .price(price)
//                .image(image)
//                .build();
//
//        try {
//            couponRepository.save(coupon);
//            System.out.println("Coupon '" + title + "' created successfully.");
//        } catch (Exception e) {
//            System.out.println("Error occurred during coupon creation for '" + title + "': " + ErrMsg.COUPON_ERROR.getMsg());
//        }
//    }
//}
