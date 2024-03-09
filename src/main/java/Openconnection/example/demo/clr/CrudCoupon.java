package Openconnection.example.demo.clr;

import Openconnection.example.demo.Exceptions.ErrMsg;
import Openconnection.example.demo.database.Repository.CouponRepository;
import Openconnection.example.demo.database.beans.Category;
import Openconnection.example.demo.database.beans.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
@Order(1)
public class CrudCoupon implements CommandLineRunner {

    @Autowired
    CouponRepository couponRepository;

    @Override
    public void run(String... args) {
        try {
            createCoupon("Food Coupon", Category.Food, " coupon", 10, 19.99, "image-url");
            createCoupon("PC", Category.Computer, " coupon for pc", 10, 69.99, "image-url");
            createCoupon("Hotels discount", Category.Vacation, " Vacation Discount", 5, 799.90, "image-url");
        } catch (Exception e) {
            // Handle any exceptions that might occur during coupon creation
            System.out.println("Error occurred during coupon creation: " + ErrMsg.COUPON_ERROR.getMsg());
        }
    }

    private void createCoupon(String title, Category category, String description, int amount, double price, String image) {
        Coupon coupon = Coupon.builder()
                .category(category)
                .description(description)
                .title(title)
                .startDate(new Date(System.currentTimeMillis()))
                .endDate(new Date(System.currentTimeMillis() + (24 * 60 * 60 * 1000))) // Set the end date (example: 1 day ahead)
                .amount(amount)
                .price(price)
                .image(image)
                .build();

        try {
            couponRepository.save(coupon);
            System.out.println("Coupon '" + title + "' created successfully.");
        } catch (Exception e) {
            // Handle any exceptions that might occur during coupon creation
            System.out.println("Error occurred during coupon creation for '" + title + "': " + ErrMsg.COUPON_ERROR.getMsg());
        }
    }
}















//package Openconnection.example.demo.clr;
//
//import Openconnection.example.demo.database.Repository.CouponRepository;
//import Openconnection.example.demo.database.beans.Category;
//import Openconnection.example.demo.database.beans.Coupon;
//import Openconnection.example.demo.Exceptions.CouponNotFoundException;
//import Openconnection.example.demo.Exceptions.ErrMsg;
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
//    @Autowired
//    CouponRepository couponRepository;
//
//    @Override
//    public void run(String... args) {
//        try {
//            Coupon c1 = Coupon.builder()
//                    //.companyId(0) // Set your company ID
//                    .category(Category.Food)
//                    .description(" coupon")
//                    .title("Food Coupon")
//                    .startDate(new Date(System.currentTimeMillis()))
//                    .endDate(new Date(System.currentTimeMillis() + (24 * 60 * 60 * 1000))) // Set the end date (example: 1 day ahead)
//                    .amount(10)
//                    .price(19.99)
//                    .image("image-url")
//                    .build();
//            System.out.println("Coupon 'Food Coupon' created successfully.");
//
//            couponRepository.save(c1);
//
//            Coupon c2 = Coupon.builder()
//                    // .companyId(0) // Set your company ID
//                    .category(Category.Computer)
//                    .description(" coupon for pc")
//                    .title("PC")
//                    .startDate(new Date(System.currentTimeMillis()))
//                    .endDate(new Date(System.currentTimeMillis() + (24 * 60 * 60 * 1000))) // Set the end date (example: 1 day ahead)
//                    .amount(10)
//                    .price(69.99)
//                    .image("image-url")
//                    .build();
//            System.out.println("Coupon 'PC' created successfully.");
//            couponRepository.save(c2);
//
//            Coupon c3 = Coupon.builder()
//                    //   .companyId(0) // Set your company ID
//                    .category(Category.Vacation)
//                    .description(" Vacation Discount")
//                    .title("Hotels discount")
//                    .startDate(new Date(System.currentTimeMillis()))
//                    .endDate(new Date(System.currentTimeMillis() + (24 * 60 * 60 * 1000))) // Set the end date (example: 1 day ahead)
//                    .amount(5)
//                    .price(799.90)
//                    .image("image-url")
//                    .build();
//            System.out.println("Coupon 'Hotels discount' created successfully.");
//
//            couponRepository.save(c3);
//        } catch (Exception e) {
//            // Handle any exceptions that might occur during coupon creation
//            System.out.println("Error occurred during coupon creation: " + ErrMsg.COUPON_ERROR.getMsg());
//        }
//
//    }
//
//
//}
//
//
