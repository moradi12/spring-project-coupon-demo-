package Openconnection.example.demo.clr.Coupon;

import Openconnection.example.demo.database.ServiceInterface.CouponService;
import Openconnection.example.demo.database.beans.Coupon;
import Openconnection.example.demo.database.beans.Category; // Import Category enum
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
@Order(1)
public class CreateCouponByService implements CommandLineRunner {
    @Autowired
    CouponService couponService;

    @Override
    public void run(String... args) throws Exception {
        try {
            couponService.addCoupon(Coupon.builder()
                    .companyId(0)
                    .category(Category.Food)
                    .description("Your coupon description")
                    .title("Your coupon title")
                    .startDate(Date.valueOf("2024-03-12"))
                    .endDate(Date.valueOf("2024-03-31"))
                    .amount(10)
                    .price(50.0)
                    .image("path/to/image")
                    .build());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    }
