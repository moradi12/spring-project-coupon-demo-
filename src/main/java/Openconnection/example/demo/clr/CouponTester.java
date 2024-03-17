package Openconnection.example.demo.clr;

import Openconnection.example.demo.Service.CouponService;
import Openconnection.example.demo.beans.Category;
import Openconnection.example.demo.beans.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.sql.Date;
import java.util.Arrays;

@Component
@Order(1)
public class CouponTester implements CommandLineRunner {

    @Autowired
    RestTemplate restTemplate;

    private final CouponService couponService;

    @Autowired
    public CouponTester(CouponService couponService) {
        this.couponService = couponService;
    }

    @Override
    public void run(String... args) throws Exception {
        try {
            // Adding coupons to the database using CouponService
            Coupon coupon1 = Coupon.builder()
                    .id(1)
                    .companyId(1)
                    .category(Category.Food)
                    .description("50% off on electronics")
                    .title("Electronics Sale")
                    .startDate(Date.valueOf("2024-03-12"))
                    .endDate(Date.valueOf("2024-03-31"))
                    .amount(100)
                    .price(50.0)
                    .image("electronics_sale.jpg")
                    .build();

            Coupon coupon2 = Coupon.builder()
                    .id(2)
                    .companyId(2)
                    .category(Category.Vacation)
                    .description("10% off on summer vacation packages")
                    .title("Summer Vacation Deal")
                    .startDate(Date.valueOf("2024-06-01"))
                    .endDate(Date.valueOf("2024-08-31"))
                    .amount(50)
                    .price(200.0)
                    .image("summer_vacation.jpg")
                    .build();

            Coupon coupon3 = Coupon.builder()
                    .id(3)
                    .companyId(3)
                    .category(Category.Health)
                    .description("Get 1 month free on fitness membership")
                    .title("Fitness Membership Offer")
                    .startDate(Date.valueOf("2024-03-15"))
                    .endDate(Date.valueOf("2024-04-15"))
                    .amount(20)
                    .price(75.0)
                    .image("fitness_membership.jpg")
                    .build();

            Coupon coupon4 = Coupon.builder()
                    .id(4)
                    .companyId(4)
                    .category(Category.Travel)
                    .description("Get 3 months free on any travel package")
                    .title("Special Travel Package Offer")
                    .startDate(Date.valueOf("2024-03-25"))
                    .endDate(Date.valueOf("2024-06-25"))
                    .amount(40)
                    .price(100.0)
                    .image("special_travel_package.jpg")
                    .build();


            couponService.addCoupon(coupon1);
            couponService.addCoupon(coupon2);
            couponService.addCoupon(coupon3);
            couponService.addCoupon(coupon4);

            System.out.println("All Coupons:");
            couponService.getAllCoupons().forEach(System.out::println);

            // Deleting a coupon from the database using CouponService
            couponService.deleteCoupon(2);
            System.out.println("Deleting coupon with ID 2...");

            System.out.println("Remaining Coupons:");
            couponService.getAllCoupons().forEach(System.out::println);

            // Update a coupon using REST API
            Coupon updatedCoupon = couponService.getCouponById(1); // Change the id
            if (updatedCoupon != null) {
                updatedCoupon.setTitle("Updated Title");
                updatedCoupon.setDescription("Updated Description");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

//                restTemplate.put("http://localhost:8080/api/coupons/{id}", updatedCoupon, 1);
//                System.out.println("Updated coupon with ID 1");
//            }
//
//            // Sending coupons to REST API endpoints
//            restTemplate.postForEntity("http://localhost:8080/api/coupons", coupon1, Coupon.class);
//            restTemplate.postForEntity("http://localhost:8080/api/coupons", coupon2, Coupon.class);
//            restTemplate.postForEntity("http://localhost:8080/api/coupons", coupon3, Coupon.class);
//            restTemplate.postForEntity("http://localhost:8080/api/coupons", coupon5, Coupon.class);
//
//            // Displaying coupons received from REST API endpoints
//            System.out.println(restTemplate.getForObject("http://localhost:8080/api/coupons/all", String.class));
//
//            restTemplate.delete("http://localhost:8080/api/coupons/{id}", 1);
//            System.out.println("Deleting coupon with ID 2");
//
//            Coupon[] coupons = restTemplate.getForObject("http://localhost:8080/api/coupons/all", Coupon[].class);
//            if (coupons != null) {
//                Arrays.stream(coupons).forEach(System.out::println);
//            }
//
//            Coupon[] couponsByName = restTemplate.getForObject("http://localhost:8080/api/coupons/byName/{name}", Coupon[].class, "Electronics Sale");
//            if (couponsByName != null) {
//                Arrays.stream(couponsByName).forEach(System.out::println);
