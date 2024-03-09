//package Openconnection.example.demo.database.Service;
//
//import Openconnection.example.demo.Exceptions.CouponNotFoundException;
//import Openconnection.example.demo.database.beans.Coupon;
//import Openconnection.example.demo.Exceptions.CompanyNotFoundException;
//
//import java.util.List;
//import java.util.Optional;
//
//public interface CouponService {
//
//    void addCoupon(Coupon coupon) throws CouponNotFoundException;
//
//    void updateCoupon(int id, Coupon coupon) throws CouponNotFoundException;
//
//    void deleteCoupon(int couponID) throws CouponNotFoundException;
//
//    void addCouponPurchase(int customerID, int couponID) throws CouponNotFoundException;
//
//
//    void deleteCouponPurchase(int customerID, int couponID) throws CouponNotFoundException;
//
//
//    List<Coupon> getAllCoupons() throws CouponNotFoundException;
//
//    Optional<Coupon> getOneCoupon(int couponID) throws CouponNotFoundException;
//
//    List<Coupon> getCouponsByCompany(int companyId) throws CompanyNotFoundException;
//}
