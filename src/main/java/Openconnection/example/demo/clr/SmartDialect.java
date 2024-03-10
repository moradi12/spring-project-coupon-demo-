package Openconnection.example.demo.clr;

import Openconnection.example.demo.database.Repository.CouponRepository;
import Openconnection.example.demo.database.beans.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.List;

@Component
@Order(5)
public class SmartDialect implements CommandLineRunner {
    private final CouponRepository couponRepository;

    @Autowired
    public SmartDialect(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        // Find coupons by company ID
        List<Coupon> couponsByCompanyId = couponRepository.findByCompanyId(1);
        System.out.println("Coupons by Company ID:");
        couponsByCompanyId.forEach(System.out::println);

        Date endDate = Date.valueOf("2024-03-10");
        couponRepository.deleteByEndDateBefore(endDate);
        System.out.println("Coupons with end date before " + endDate + " deleted successfully.");
    }
}
