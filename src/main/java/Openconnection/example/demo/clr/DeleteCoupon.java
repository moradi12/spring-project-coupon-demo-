package Openconnection.example.demo.clr;

import Openconnection.example.demo.Exceptions.CouponNotFoundException;
import Openconnection.example.demo.database.Repository.CouponRepository;
import Openconnection.example.demo.database.beans.Coupon;
import Openconnection.example.demo.Exceptions.ErrMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DeleteCoupon {

    @Autowired
    private CouponRepository couponRepository;

    public void deleteCouponById(Integer couponId) {
        Optional<Coupon> couponToDelete = getCouponById(couponId);
        if (couponToDelete.isPresent()) {
            couponRepository.delete(couponToDelete.get());
            couponRepository.flush(); // Flush changes to the database
            System.out.println("Coupon " + couponId + " deleted successfully!");
        } else {
            System.out.println(ErrMsg.COUPON_NOT_FOUND.getMsg());
        }
    }

    private Optional<Coupon> getCouponById(Integer couponId) {
        return couponRepository.findById(couponId);
    }
}
