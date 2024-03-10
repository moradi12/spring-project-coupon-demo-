package Openconnection.example.demo.clr;

import Openconnection.example.demo.database.Repository.CouponRepository;
import Openconnection.example.demo.database.beans.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Order(5)
public class DeleteCoupon implements CommandLineRunner {
    private final CouponRepository couponRepository;

    @Autowired
    public DeleteCoupon(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Assuming coupon with ID 2 exists
        Optional<Coupon> couponToDelete = couponRepository.findById(2);
        couponToDelete.ifPresent(coupon -> {
            couponRepository.delete(coupon);
            System.out.println("Coupon with ID " + coupon.getId() + "has been deleted");
        });
    }
}
