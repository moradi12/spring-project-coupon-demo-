package Openconnection.example.demo.Controllers;

import Openconnection.example.demo.Exceptions.CouponNotFoundException;
import Openconnection.example.demo.Service.CouponService;
import Openconnection.example.demo.beans.Coupon;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/// its only for the website !!!
@RestController
@RequestMapping("/api/coupon")
@RequiredArgsConstructor
public class CouponController {

    @Autowired
    CouponService couponService;

    // Get all coupons
    @GetMapping("/getAllCoupons")
    @ResponseStatus(HttpStatus.OK)
    public List<Coupon> getAllCoupons() throws CouponNotFoundException {
        return couponService.getAllCoupons();
    }

    // Create a new coupon
    @PostMapping("/addCoupon")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCoupon(@Validated @RequestBody Coupon coupon) throws CouponNotFoundException {
        couponService.addCoupon(coupon);
    }

    // Update a coupon by its ID
    @PutMapping("/updateCoupon/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCoupon(@PathVariable int id, @Valid @RequestBody Coupon coupon) throws CouponNotFoundException {
        Coupon existingCoupon = couponService.getOneCoupon(id)
                .orElseThrow(() -> new CouponNotFoundException("Coupon with id " + id + " not found"));
        coupon.setId(id); // Ensure the ID is set correctly
        couponService.updateCoupon(existingCoupon);
    }


    // Delete a coupon by its ID
    @DeleteMapping("/deleteCoupon/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteCoupon(@PathVariable int id) throws CouponNotFoundException {
        couponService.deleteCoupon(id);
    }

    // Get a coupon by its ID
    @GetMapping("/getOneCoupon/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Coupon> getOneCoupon(@PathVariable int id) throws CouponNotFoundException {
        return couponService.getOneCoupon(id);
    }
}
