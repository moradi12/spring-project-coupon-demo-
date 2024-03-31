package Openconnection.example.demo.Service;

import Openconnection.example.demo.beans.Coupon;
import Openconnection.example.demo.beans.Category;
import Openconnection.example.demo.Repository.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class GuestService {

    @Autowired
    private CouponRepository couponRepository;

    public List<Coupon> searchCouponsByCompany(Integer companyId) {
        return couponRepository.findByCompanyId(companyId);
    }

    public Coupon searchCouponByTitle(String title) {
        return couponRepository.findByTitle(title);
    }

    public boolean doesCouponExist(String title, int companyId) {
        return couponRepository.existsByTitleAndCompanyId(title, companyId);
    }

    public List<Coupon> searchExpiredCoupons(Date endDate) {
        return couponRepository.findByEndDateBefore(endDate);
    }

    public List<Coupon> searchCouponsByCategory(Category category) {
        return couponRepository.findByCategory(category);
    }

    public List<Coupon> searchCouponsByPriceRange(double minPrice, double maxPrice) {
        return couponRepository.findByPriceBetween(minPrice, maxPrice);
    }
}
//    public List<Coupon> searchCouponsByDiscountPercentageAndAvailability(double minDiscount, double maxDiscount, boolean available) {
//        return couponRepository.findByDiscountPercentageBetweenAndAvailable(minDiscount, maxDiscount, available);
//    }}


