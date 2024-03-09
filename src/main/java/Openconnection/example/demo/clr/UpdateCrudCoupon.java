package Openconnection.example.demo.clr;

import Openconnection.example.demo.Exceptions.CouponNotFoundException;
import Openconnection.example.demo.database.Repository.CouponRepository;
import Openconnection.example.demo.database.beans.Category;
import Openconnection.example.demo.database.beans.Coupon;
import Openconnection.example.demo.Exceptions.ErrMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class UpdateCrudCoupon {

    @Autowired
    private CouponRepository couponRepository;

//    public void updateCouponCategory() {
//        try {
//            // Retrieve coupon c2 by its ID
//            Coupon couponToUpdate = getCouponById(2); // Assuming coupon c2 has ID 2
//            if (couponToUpdate != null) {
//                // Update coupon category to Category.Electricity
//                couponToUpdate.setCategory(Category.Electricity);
//                // Save the updated coupon and flush changes to the database
//                couponRepository.saveAndFlush(couponToUpdate);
//                System.out.println("Coupon c2 updated successfully!");
//            } else {
//                System.out.println(ErrMsg.COUPON_NOT_FOUND.getMsg());
//            }
//        } catch (CouponNotFoundException e) {
//            System.out.println(e.getMessage());
//        }
//    }

    private Coupon getCouponById(Integer couponId) throws CouponNotFoundException {
        return couponRepository.findById(couponId)
                .orElseThrow(() -> new CouponNotFoundException(ErrMsg.COUPON_NOT_FOUND.getMsg()));
    }
}
