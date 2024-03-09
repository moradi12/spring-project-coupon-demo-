//package Openconnection.example.demo.Controllers;
//
//
//import Openconnection.example.demo.Exceptions.CouponNotFoundException;
//import Openconnection.example.demo.database.ServiceInterface.CouponService;
//import Openconnection.example.demo.database.beans.Coupon;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import java.util.List;
//
//@Controller
//@RequestMapping("api,coupon")
//public class CouponController {
//    @Autowired
//    CouponService couponService;
//
//    @GetMapping
//    public List<Coupon> getAllCoupons() throws CouponNotFoundException {
//        return couponService.getAllCoupons();
//
//    }
//}
//
