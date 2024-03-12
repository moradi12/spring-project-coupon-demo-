package Openconnection.example.demo.clr.Coupon;

import Openconnection.example.demo.database.ServiceInterface.CouponService;
import Openconnection.example.demo.database.beans.Category;
import Openconnection.example.demo.database.beans.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class CouponTester implements CommandLineRunner {

    private final CouponService couponService;

    @Autowired
    public CouponTester(CouponService couponService) {
        this.couponService = couponService;
    }

    @Override
    public void run(String... args) throws Exception {
        try {
            couponService.addCoupon(Coupon.builder()
                    .companyId(0)
                    .category(Category.Food)
                    .description("50% off on electronics")
                    .title("Electronics Sale")
                    .startDate(Date.valueOf("2024-03-12"))
                    .endDate(Date.valueOf("2024-03-31"))
                    .amount(100)
                    .price(50.0)
                    .image("electronics_sale.jpg")
                    .build()
            );

            couponService.addCoupon(Coupon.builder()
                    .companyId(1)
                    .category(Category.Vacation)
                    .description("10% off on summer vacation packages")
                    .title("Summer Vacation Deal")
                    .startDate(Date.valueOf("2024-06-01"))
                    .endDate(Date.valueOf("2024-08-31"))
                    .amount(50)
                    .price(200.0)
                    .image("summer_vacation.jpg")
                    .build()
            );

            couponService.addCoupon(Coupon.builder()
                    .companyId(2)
                    .category(Category.Health)
                    .description("Get 1 month free on fitness membership")
                    .title("Fitness Membership Offer")
                    .startDate(Date.valueOf("2024-03-15"))
                    .endDate(Date.valueOf("2024-04-15"))
                    .amount(20)
                    .price(75.0)
                    .image("fitness_membership.jpg")
                    .build());

                    couponService.addCoupon(Coupon.builder()
                    .companyId(3)
                    .category(Category.Food)
                    .description("KFC")
                    .title("KFC Membership Offer")
                    .startDate(Date.valueOf("2024-03-15"))
                    .endDate(Date.valueOf("2024-04-15"))
                    .amount(5)
                    .price(75.0)
                    .image("KFC.jpg")
                    .build()
            );

            Coupon updatedCoupon = Coupon.builder()
                    .id(1)
                    .companyId(2)
                    .category(Category.Health)
                    .description("Updated description for fitness membership")
                    .title("Updated Fitness Membership Offer")
                    .startDate(Date.valueOf("2024-03-15"))
                    .endDate(Date.valueOf("2024-05-15"))
                    .amount(25)
                    .price(70.0)
                    .image("updated_fitness_membership.jpg")
                    .build();
//work!!
            couponService.updateCoupon(1, updatedCoupon);

            couponService.deleteCoupon(3);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}






//package Openconnection.example.demo.clr.Coupon;
//
//import Openconnection.example.demo.database.Repository.CouponRepository;
//import Openconnection.example.demo.database.ServiceInterface.CouponService;
//import Openconnection.example.demo.database.beans.Category;
//import Openconnection.example.demo.database.beans.Coupon;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//
//import java.sql.Date;
//
//public class CouponTester implements CommandLineRunner {
//
//
//    private final CouponService couponService;
//
//    public CouponTester(CouponService couponService) {
//        this.couponService = couponService;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        try {
//
//            couponService.addCoupon(Coupon.builder()
//                    .companyId(1)
//                    .category(Category.Food)
//                    .description("50% off on electronics")
//                    .title("Electronics Sale")
//                    .startDate(Date.valueOf("2024-03-12"))
//                    .endDate(Date.valueOf("2024-03-31"))
//                    .amount(100)
//                    .price(50.0)
//                    .image("electronics_sale.jpg")
//                    .build()
//            );
//            couponService.addCoupon(Coupon.builder()
//                    .companyId(2)
//                    .category(Category.Vacation)
//                    .description("10% off on summer vacation packages")
//                    .title("Summer Vacation Deal")
//                    .startDate(Date.valueOf("2024-06-01"))
//                    .endDate(Date.valueOf("2024-08-31"))
//                    .amount(50)
//                    .price(200.0)
//                    .image("summer_vacation.jpg")
//                    .build());
//
//
//            couponService.addCoupon(Coupon.builder()
//                    .companyId(3)
//                    .category(Category.Health)
//                    .description("Get 1 month free on fitness membership")
//                    .title("Fitness Membership Offer")
//                    .startDate(Date.valueOf("2024-03-15"))
//                    .endDate(Date.valueOf("2024-04-15"))
//                    .amount(20)
//                    .price(75.0)
//                    .image("fitness_membership.jpg")
//                    .build()
//            );
////            Coupon updatedCoupon = Coupon.builder()
////                    .id(3)  // ID of the coupon to update
////                    .companyId(4)  // Updated company ID
////                    .category(Category.Vacation)  // Updated category
////                    .description("New description")  // Updated description
////                    .title("New title")  // Updated title
////                    .startDate(Date.valueOf("2024-03-15"))  // Updated start date
////                    .endDate(Date.valueOf("2024-04-15"))  // Updated end date
////                    .amount(30)  // Updated amount
////                    .price(50.5)  // Updated price
////                    .image("new_image.jpg")  // Updated image
////                    .build();
////
//         //   couponService.updateCoupon(3, updatedCoupon);  // Assuming 3 is the ID of the coupon to update
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//
//
//    }
//}
