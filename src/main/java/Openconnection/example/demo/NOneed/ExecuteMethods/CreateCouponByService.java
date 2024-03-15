//package Openconnection.example.demo.clr.Coupon;
//
//import Openconnection.example.demo.database.ServiceInterface.CouponService;
//import Openconnection.example.demo.database.beans.Coupon;
//import Openconnection.example.demo.database.beans.Category;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//
//import java.sql.Date;
//
//@Component
//@Order(1)
//public class CreateCouponByService implements CommandLineRunner {
//    @Autowired
//    CouponService couponService;
//
//    @Override
//    public void run(String... args) throws Exception {
//        try {
//            couponService.couponExistsByTitleAndCompany("TRying", 0)){
//                couponService.addCoupon(Coupon.builder()
//                        .companyId(0)
//                        .category(Category.Food)
//                        .description("KFC For the win ")
//                        .title("TRying")
//                        .startDate(Date.valueOf("2024-03-12"))
//                        .endDate(Date.valueOf("2024-03-31"))
//                        .amount(15)
//                        .price(50.0)
//                        .image("path/to/image")
//                        .build());
//            }
//
//            couponService.couponExistsByTitleAndCompany("Summer Sale", 1)){
//                couponService.addCoupon(Coupon.builder()
//                        .companyId(1)
//                        .category(Category.Clothing)
//                        .description("50% off on all summer collection")
//                        .title("Summer Sale ")
//                        .startDate(Date.valueOf("2024-03-15"))
//                        .endDate(Date.valueOf("2024-04-15"))
//                        .amount(20)
//                        .price(100.0)
//                        .image("path/to/summer_sale_image")
//                        .build());
//            }
//
//            couponService.couponExistsByTitleAndCompany("BOGO Offer", 2)){
//                couponService.addCoupon(Coupon.builder()
//                        .companyId(2)
//                        .category(Category.Electricity)
//                        .description("Buy one get one free on selected items")
//                        .title("BOGO Offer")
//                        .startDate(Date.valueOf("2024-03-10"))
//                        .endDate(Date.valueOf("2024-03-20"))
//                        .amount(30)
//                        .price(200.0)
//                        .image("path/to/bogo_image")
//                        .build());
//            }
//
//            couponService.couponExistsByTitleAndCompany("International Flight Offer", 3)){
//                couponService.addCoupon(Coupon.builder()
//                        .companyId(3)
//                        .category(Category.Travel)
//                        .description("Flat $100 off on international flights")
//                        .title("International Flight Offer")
//                        .startDate(Date.valueOf("2024-03-25"))
//                        .endDate(Date.valueOf("2024-04-10"))
//                        .amount(15)
//                        .price(500.0)
//                        .image("path/to/international_flight_image")
//                        .build());
//            }
//
//            couponService.couponExistsByTitleAndCompany("Vacation Discount", 4)){
//                couponService.addCoupon(Coupon.builder()
//                        .companyId(4)
//                        .category(Category.Vacation)
//                        .description("Get $200 off on your next vacation package")
//                        .title("Vacation Discount")
//                        .startDate(Date.valueOf("2024-03-25"))
//                        .endDate(Date.valueOf("2024-04-10"))
//                        .amount(25)
//                        .price(1000.0)
//                        .image("path/to/vacation_discount_image")
//                        .build());
//            }
//
//            couponService.couponExistsByTitleAndCompany("Computer Component Sale", 5)){
//                couponService.addCoupon(Coupon.builder()
//                        .companyId(5)
//                        .category(Category.Computer)
//                        .description("Upgrade your PC with 30% discount on selected components")
//                        .title("Computer Component Sale")
//                        .startDate(Date.valueOf("2024-03-10"))
//                        .endDate(Date.valueOf("2024-03-20"))
//                        .amount(30)
//                        .price(500.0)
//                        .image("path/to/computer_component_sale_image")
//                        .build());
//            }
//        } catch (Exception e) {
//            System.out.println("Error: " + e.getMessage());
//        }
//    }
//}
