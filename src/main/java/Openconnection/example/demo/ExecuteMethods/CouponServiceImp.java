//package Openconnection.example.demo.ExecuteMethods;
//
//import Openconnection.example.demo.Exceptions.CompanyNotFoundException;
//import Openconnection.example.demo.Exceptions.CouponNotFoundException;
//import Openconnection.example.demo.Exceptions.ErrMsg;
//import Openconnection.example.demo.database.Service.CompanyService;
//import Openconnection.example.demo.database.Service.CouponService;
//import Openconnection.example.demo.database.beans.Coupon;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@RequiredArgsConstructor
//@Service
//public class CouponServiceImp implements CouponService {
//    private final CompanyService companyService;
//    private final CouponService couponService;
//
//    @Override
//    public void addCoupon(Coupon coupon) throws CouponNotFoundException {
//        try {
//            companyService.getOneCompany(coupon.getCompanyId());
//            Coupon newCoupon = Coupon.builder()
//                    .companyId(coupon.getCompanyId())
//                    .category(coupon.getCategory())
//                    .description(coupon.getDescription())
//                    .title(coupon.getTitle())
//                    .startDate(coupon.getStartDate())
//                    .endDate(coupon.getEndDate())
//                    .amount(coupon.getAmount())
//                    .price(coupon.getPrice())
//                    .image(coupon.getImage())
//                    .build();
//            // Your logic for adding the new coupon goes here
//        } catch (CompanyNotFoundException e) {
//            throw new CouponNotFoundException(ErrMsg.COMPANY_NOT_FOUND.getMsg());
//        }
//    }
//
//    @Override
//    public void updateCoupon(int id, Coupon coupon) throws CouponNotFoundException {
//        try {
//            Optional<Coupon> optionalCoupon = couponService.getOneCoupon(id);
//            if (optionalCoupon.isPresent()) {
//                Coupon existingCoupon = optionalCoupon.get();
//                existingCoupon.setCategory(coupon.getCategory());
//                existingCoupon.setDescription(coupon.getDescription());
//                existingCoupon.setTitle(coupon.getTitle());
//                existingCoupon.setStartDate(coupon.getStartDate());
//                existingCoupon.setEndDate(coupon.getEndDate());
//                existingCoupon.setAmount(coupon.getAmount());
//                existingCoupon.setPrice(coupon.getPrice());
//                existingCoupon.setImage(coupon.getImage());
//                couponService.addCoupon(existingCoupon);
//                System.out.println("Coupon with id " + id + " updated successfully.");
//            } else {
//                throw new CouponNotFoundException(ErrMsg.COUPON_NOT_FOUND.getMsg() + ": " + id);
//            }
//        } catch (Exception e) {
//            throw new CouponNotFoundException(ErrMsg.COUPON_ERROR.getMsg() + ": " + e.getMessage());
//        }
//    }
//
//    @Override
//    public void deleteCoupon(int couponID) throws CouponNotFoundException {
//
//    }
//
//    @Override
//    public void addCouponPurchase(int customerID, int couponID) throws CouponNotFoundException {
//
//    }
//
//    @Override
//    public void deleteCouponPurchase(int customerID, int couponID) throws CouponNotFoundException {
//
//    }
//
//    @Override
//    public List<Coupon> getAllCoupons() throws CouponNotFoundException {
//        return null;
//    }
//
//    @Override
//    public Optional<Coupon> getOneCoupon(int couponID) throws CouponNotFoundException {
//        return Optional.empty();
//    }
//
//    @Override
//    public List<Coupon> getCouponsByCompany(int companyId) throws CompanyNotFoundException {
//        return null;
//    }
//}
