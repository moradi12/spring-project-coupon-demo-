package Openconnection.example.demo.clr;

import Openconnection.example.demo.Repository.CouponRepository;
import Openconnection.example.demo.beans.Coupon;
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

    }
}
