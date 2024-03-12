package Openconnection.example.demo.Controllers;

import Openconnection.example.demo.Exceptions.CouponNotFoundException;
import Openconnection.example.demo.database.ServiceInterface.CouponService;
import Openconnection.example.demo.database.beans.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/// its only for the website !!!
@RestController
@RequestMapping("/api/coupon")
public class CouponController {

    @Autowired
    CouponService couponService;


    // getting data

    //getting all the coupons!!!

    //GetMapping//

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Coupon> getAllCoupons() throws CouponNotFoundException {
        return couponService.getAllCoupons();
    }


    //create data
    //PostMapping

    //validated make sure thats its working
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addCoupon(@Validated @RequestBody Coupon coupon) throws CouponNotFoundException {
        couponService.addCoupon(coupon);
    }


    //put = update
    //PutMapping
    ///select the id to update the coupon



    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCoupon(@PathVariable int id, @RequestBody Coupon coupon) throws CouponNotFoundException {
        couponService.updateCoupon(id, coupon);

    }

    ///delete cat
//DeleteMapping
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteCoupon(@PathVariable int id) throws CouponNotFoundException {
        couponService.deleteCoupon(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Coupon> getOneCoupon(@PathVariable int id) throws CouponNotFoundException {
        return couponService.getOneCoupon(id);


    }

}
/// if we have more than 1 get mapping we have to change the path