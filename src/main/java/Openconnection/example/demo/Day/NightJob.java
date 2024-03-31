package Openconnection.example.demo.Day;

import Openconnection.example.demo.Service.CompanyService;
import Openconnection.example.demo.Service.CouponService;
import Openconnection.example.demo.beans.Coupon;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
@Component
@RequiredArgsConstructor
public class NightJob {

    private final CompanyService companyService;
    private final CouponService couponService;

    @Scheduled(cron = "0 0 0 * * *")
    public void deleteExpiredCoupons() {
        try {
            Date currentDate = new Date(System.currentTimeMillis());
            List<Coupon> expiredCoupons = couponService.getExpiredCoupons(currentDate);
            System.out.println("Found" + expiredCoupons.size() + "expired coupons");

            List<String> deletedCouponMessages = new ArrayList<>();
            for (Coupon coupon : expiredCoupons) {
                companyService.deleteCoupon(coupon.getId());
                deletedCouponMessages.add("Deleted expired coupon with ID " + coupon.getId() + " and data: "+coupon);
            }
            System.out.println("Deleted coupons:");
            System.out.println(String.join("\n", deletedCouponMessages));
        } catch (Exception e) {
            System.out.println("Error deleting expired coupons: " + e.getMessage());
        }
        System.out.println("Scheduled task executed");
    }
}