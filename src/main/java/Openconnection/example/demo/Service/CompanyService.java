package Openconnection.example.demo.Service;


import Openconnection.example.demo.Exceptions.CompanyNotFoundException;
import Openconnection.example.demo.Exceptions.CouponNotFoundException;
import Openconnection.example.demo.beans.Category;
import Openconnection.example.demo.beans.Company;
import Openconnection.example.demo.beans.Coupon;

import java.util.List;
import java.util.Optional;

public interface CompanyService extends ClientService {

    void addCoupon(Coupon coupon)throws CouponNotFoundException;
    void updateCoupon(Coupon coupon)throws CouponNotFoundException;

    void deleteCoupon(int couponID)throws CouponNotFoundException;

    List<Coupon> getCompanyCoupons()throws CompanyNotFoundException;
    List<Coupon> getCompanyCoupons(Category category)throws CompanyNotFoundException;
    List<Coupon> getCompanyCoupons(double MaxPrice)throws CompanyNotFoundException;
    void getCompanyDetails(Company company);

    boolean isCompanyExists(String email, String password) throws CompanyNotFoundException;


    void addCompany(Company company) throws CompanyNotFoundException;

    void updateCompany(Company company) throws CompanyNotFoundException;

    void deleteCompany(int companyID) throws CompanyNotFoundException;

    List<Company> getAllCompanies();

    Optional<Company> getOneCompany(int companyID) throws CompanyNotFoundException;

    void saveAll(List<Company> companies) throws CompanyNotFoundException;
}
