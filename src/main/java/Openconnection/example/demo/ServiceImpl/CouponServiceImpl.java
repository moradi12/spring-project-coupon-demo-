package Openconnection.example.demo.ServiceImpl;

import Openconnection.example.demo.Repository.CouponRepository;
import Openconnection.example.demo.Repository.CustomerRepository;
import Openconnection.example.demo.Service.CouponService;
import Openconnection.example.demo.beans.Coupon;
import Openconnection.example.demo.Exceptions.CouponNotFoundException;
import Openconnection.example.demo.Exceptions.ErrMsg;
import Openconnection.example.demo.beans.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CouponServiceImpl implements CouponService {

    @Autowired
    CouponRepository couponRepository;
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public void addCoupon(Coupon coupon) throws CouponNotFoundException {
        int id = coupon.getId();
        if (couponRepository.existsByTitleAndCompanyId(coupon.getTitle(), coupon.getCompanyId())) {
            throw new CouponNotFoundException(ErrMsg.COUPON_ID_ALREADY_EXISTS.getMsg());
        }
        couponRepository.save(coupon);
        System.out.println("Coupon added: " + coupon);
    }

    @Override
    public Coupon getCouponById(int id) throws CouponNotFoundException {
        Optional<Coupon> couponOptional = couponRepository.findById(id);
        return couponOptional.orElseThrow(() -> new CouponNotFoundException(ErrMsg.COUPON_ID_NOT_FOUND.getMsg()));
    }


    @Override
    public void updateCoupon(Coupon coupon) throws CouponNotFoundException {
        if (!couponRepository.existsById(coupon.getId())) {
            throw new CouponNotFoundException(ErrMsg.COUPON_ID_NOT_FOUND.getMsg());
        }
        couponRepository.saveAndFlush(coupon);
        System.out.println("Coupon updated: " + coupon);
    }

    @Override
    public void deleteCoupon(int couponID) throws CouponNotFoundException {
        if (!couponRepository.existsById(couponID)) {
            throw new CouponNotFoundException(ErrMsg.COUPON_ID_NOT_FOUND.getMsg());
        }
        couponRepository.deleteById(couponID);
        System.out.println("Coupon deleted with ID: " + couponID);
    }

    @Override
    public List<Coupon> getAllCoupons() throws CouponNotFoundException {
        List<Coupon> coupons = couponRepository.findAll();
        System.out.println("Retrieved all coupons: " + coupons.size());
        return coupons;
    }

    @Override
    public Coupon getOneCoupon(int couponID) throws CouponNotFoundException {
        return couponRepository.findById(couponID)
                .orElseThrow(() -> new CouponNotFoundException(ErrMsg.COUPON_ID_NOT_FOUND.getMsg()));
    }

    @Override
    public boolean couponExistsByTitleAndCompany(String title, int companyId) {
        boolean exists = couponRepository.existsByTitleAndCompanyId(title, companyId);
        System.out.println("Coupon exists with title: " + title + " and company ID: " + companyId + ": " + exists);
        return exists;
    }

    @Override
    public void deleteCouponPurchase(int couponID, int customerID) throws CouponNotFoundException {
        Coupon coupon = couponRepository.findById(couponID)
                .orElseThrow(() -> new CouponNotFoundException(ErrMsg.COUPON_NOT_FOUND.getMsg()));
        Optional<Customer> optionalCustomer = customerRepository.findById(customerID);

        if (optionalCustomer.isEmpty()) {
            throw new CouponNotFoundException(ErrMsg.CUSTOMER_NOT_FOUND.getMsg());
        }
        Customer customer = optionalCustomer.get();
        List<Coupon> customerCoupons = customer.getCoupons();
        customerCoupons.removeIf(c -> c.getId() == couponID);
        customer.setCoupons(customerCoupons);
        customerRepository.saveAndFlush(customer);

        System.out.println("Coupon purchase deleted for Customer ID: " + customerID + " for Coupon ID: " + couponID);
    }

    @Override
    public void saveAndFlush(Coupon coupon) throws CouponNotFoundException {
        couponRepository.saveAndFlush(coupon);
        System.out.println("Coupon saved and flushed: " + coupon);
    }

    @Override
    public void addCouponPurchase(int couponID, int customerID) throws CouponNotFoundException {
        Coupon coupon = couponRepository.findById(couponID)
                .orElseThrow(() -> new CouponNotFoundException(ErrMsg.COUPON_NOT_FOUND.getMsg()));
        Optional<Customer> optionalCustomer = customerRepository.findById(customerID);
        if (optionalCustomer.isEmpty()) {
            throw new CouponNotFoundException(ErrMsg.CUSTOMER_NOT_FOUND.getMsg());
        }
        Customer customer = optionalCustomer.get();
        List<Coupon> customerCoupons = customer.getCoupons();
        customerCoupons.add(coupon);
        customer.setCoupons(customerCoupons);
        customerRepository.saveAndFlush(customer);
        System.out.println("Coupon purchase added for Customer ID: " + customerID + " for Coupon ID: " + couponID);
    }

    @Override
    public void deleteExpiredCoupons() throws CouponNotFoundException {
        // Get the current date
        Date currentDate = new Date(System.currentTimeMillis());

        try {
            // Find all expired coupons
            List<Coupon> expiredCoupons = couponRepository.findByEndDateBefore(currentDate);

            // Delete each expired coupon
            for (Coupon coupon : expiredCoupons) {
                couponRepository.delete(coupon);
                System.out.println("Deleted expired coupon with ID " + coupon.getId());
            }
        } catch (Exception e) {
            throw new CouponNotFoundException("Error deleting expired coupons: " + e.getMessage());
        }
    }
    @Override
    public List<Coupon> getExpiredCoupons(Date currentDate) throws CouponNotFoundException {
        return null;
    }

    }
