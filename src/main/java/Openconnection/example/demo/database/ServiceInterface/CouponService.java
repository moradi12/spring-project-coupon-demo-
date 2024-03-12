package Openconnection.example.demo.database.ServiceInterface;

import Openconnection.example.demo.Exceptions.CouponNotFoundException;
import Openconnection.example.demo.database.beans.Coupon;
import Openconnection.example.demo.Exceptions.CompanyNotFoundException;

import java.util.List;
import java.util.Optional;

public interface CouponService {

    void addCoupon(Coupon coupon) throws CouponNotFoundException;

    void updateCoupon(int id, Coupon coupon) throws CouponNotFoundException;

    void deleteCoupon(int couponID) throws CouponNotFoundException;

    List<Coupon> getAllCoupons() throws CouponNotFoundException;

    Optional<Coupon> getOneCoupon(int couponID) throws CouponNotFoundException;

    boolean couponExistsByTitleAndCompany(String title, int companyId);
    boolean couponExistsByTitle(String title);
}
