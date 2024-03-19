package Openconnection.example.demo.Day;

import Openconnection.example.demo.Service.CouponService;
import Openconnection.example.demo.beans.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.List;

@Component
public class DayJob {

    private final CouponService couponService;

    @Autowired
    public DayJob(CouponService couponService) {
        this.couponService = couponService;
    }
    @Scheduled(cron = "0 0 0 * * *") // Executes daily at midnight
    public void deleteExpiredCoupons() {
        try {
            Date currentDate = new Date(System.currentTimeMillis());
            List<Coupon> allCoupons = couponService.getAllCoupons();
            for (Coupon coupon : allCoupons) {
                if (isExpired(coupon, currentDate)) {
                    couponService.deleteCoupon(coupon.getId());
                    System.out.println("Deleted expired coupon with ID " + coupon.getId());
                }
            }
        } catch (Exception e) {
            System.out.println("Error deleting expired coupons: " + e.getMessage());
        }
    }

    private boolean isExpired(Coupon coupon, Date currentDate) {
        return currentDate.after(coupon.getEndDate());
    }
}
