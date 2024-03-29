package Openconnection.example.demo.Service;

import Openconnection.example.demo.Exceptions.CouponNotFoundException;
import Openconnection.example.demo.beans.Coupon;

import java.util.List;

public interface CouponService {

    void addCoupon(Coupon coupon) throws CouponNotFoundException;

    Coupon getCouponById(int id) throws CouponNotFoundException;

    void updateCoupon(Coupon coupon) throws CouponNotFoundException;

    void deleteCoupon(int couponID) throws CouponNotFoundException;

    List<Coupon> getAllCoupons() throws CouponNotFoundException;

    Coupon getOneCoupon(int couponID) throws CouponNotFoundException;

    boolean couponExistsByTitleAndCompany(String title, int companyId);

    void deleteCouponPurchase(int couponID, int customerID) throws CouponNotFoundException;

    void saveAndFlush(Coupon coupon) throws CouponNotFoundException;

    void addCouponPurchase(int couponID, int customerID) throws CouponNotFoundException;

    void deleteExpiredCoupons() throws CouponNotFoundException;

    List<Coupon> getExpiredCoupons(java.sql.Date currentDate) throws CouponNotFoundException;

}
