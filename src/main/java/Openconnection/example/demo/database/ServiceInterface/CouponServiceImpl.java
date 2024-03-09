package Openconnection.example.demo.database.ServiceInterface;

import Openconnection.example.demo.database.beans.Coupon;import Openconnection.example.demo.Exceptions.CouponNotFoundException;
import Openconnection.example.demo.Exceptions.ErrMsg;
import Openconnection.example.demo.database.Repository.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CouponServiceImpl implements CouponService {

    @Autowired
    CouponRepository couponRepository;

    @Override
    public void addCoupon(Coupon coupon) throws CouponNotFoundException {
        int id = coupon.getId();
        if (couponRepository.existsById(id)) {
            throw new CouponNotFoundException(ErrMsg.COMPANY_ALREADY_EXISTS.getMsg());
        }
        couponRepository.save(coupon);
    }


    @Override
    public void updateCoupon(int id, Coupon coupon) throws CouponNotFoundException {
        if (!couponRepository.existsById(id)) {
            throw new CouponNotFoundException(ErrMsg.COUPON_ID_NOT_FOUND.getMsg());
        }
        couponRepository.saveAndFlush(coupon);
    }

    @Override
    public void deleteCoupon(int couponID) throws CouponNotFoundException {
        if (!couponRepository.existsById(couponID)) {
            throw new CouponNotFoundException(ErrMsg.COUPON_ID_NOT_FOUND.getMsg());

        }
        couponRepository.deleteById(couponID);
    }


    @Override
    public List<Coupon> getAllCoupons() throws CouponNotFoundException {
        return couponRepository.findAll();
    }

    @Override
    public Optional<Coupon> getOneCoupon(int couponID) throws CouponNotFoundException {
        Optional<Coupon> couponOptional = couponRepository.findById(couponID);
        if (couponOptional.isEmpty()) {
            throw new CouponNotFoundException(ErrMsg.COUPON_ID_NOT_FOUND.getMsg());
        }
        return couponOptional;
    }
}