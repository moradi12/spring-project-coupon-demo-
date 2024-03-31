package Openconnection.example.demo.Controllers;

import Openconnection.example.demo.Exceptions.CouponNotFoundException;
import Openconnection.example.demo.Exceptions.CouponOutOfStock;
import Openconnection.example.demo.Exceptions.CustomerExceptionException;
import Openconnection.example.demo.Service.CouponService;
import Openconnection.example.demo.Service.CustomerService;
import Openconnection.example.demo.beans.Company;
import Openconnection.example.demo.beans.Coupon;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//get system coupon
//get customer coupon
//purchase coupon
@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor

public class CustomerController {
    private final CouponService couponService;
    private final CustomerService customerService;

    @GetMapping("/all")
    public List<Coupon> getAllCoupons() {
        return couponService.getAllCoupons();
    }


    @GetMapping("/{customerId}/coupons")
    public List<Coupon> getCustomerCoupons(@PathVariable int customerId) throws CustomerExceptionException {
        return customerService.getCustomerCoupons(customerId);
    }


    @PostMapping("/coupon/purchase")
    public void purchaseCoupon(@RequestParam int couponID, @RequestParam int customerID) throws CouponNotFoundException, CouponOutOfStock, CustomerExceptionException {
        customerService.CouponPurchase(couponID, customerID);
    }
}



