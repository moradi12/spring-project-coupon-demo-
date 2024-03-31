//package Openconnection.example.demo.Controllers;
//
//import Openconnection.example.demo.Exceptions.CouponNotFoundException;
//import Openconnection.example.demo.beans.Coupon;
//import jakarta.validation.Valid;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//@RestController
//@RequestMapping("/api/coupon")
//@RequiredArgsConstructor
//public class CouponController {
//
//    private final CouponService couponService;
//
//    // Get all coupons
//    @GetMapping("/getAllCoupons")
//    @ResponseStatus(HttpStatus.OK)
//    public List<Coupon> getAllCoupons() throws CouponNotFoundException {
//        return couponService.getAllCoupons();
//    }
//
//    // Create a new coupon
//    @PostMapping("/addCoupon")
//    @ResponseStatus(HttpStatus.CREATED)
//    public void addCoupon(@Validated @RequestBody Coupon coupon) throws CouponNotFoundException {
//        couponService.addCoupon(coupon);
//    }
//
//    // Update a coupon by its ID
//    @PutMapping("/updateCoupon/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public void updateCoupon(@PathVariable("id") int id, @Valid @RequestBody Coupon coupon) throws CouponNotFoundException {
//        Coupon existingCoupon = couponService.getOneCoupon(id);
//        existingCoupon.setTitle(coupon.getTitle());
//        existingCoupon.setDescription(coupon.getDescription());
//        couponService.saveAndFlush(existingCoupon);
//        }
//
//    // Delete a coupon by its ID
//    @DeleteMapping("/deleteCoupon/{id}")
//    @ResponseStatus(HttpStatus.ACCEPTED)
//    public void deleteCoupon(@PathVariable int id) throws CouponNotFoundException {
//        couponService.deleteCoupon(id);
//    }
//
//    // Get a coupon by its ID
//    @GetMapping("/getOneCoupon/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public Coupon getOneCoupon(@PathVariable("id") int id) throws CouponNotFoundException {
//        return couponService.getOneCoupon(id);
//    }
//}
