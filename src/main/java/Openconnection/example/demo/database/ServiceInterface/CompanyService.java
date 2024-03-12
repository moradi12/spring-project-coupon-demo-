package Openconnection.example.demo.database.ServiceInterface;


import Openconnection.example.demo.Exceptions.CompanyNotFoundException;
import Openconnection.example.demo.Exceptions.CouponNotFoundException;
import Openconnection.example.demo.database.beans.Category;
import Openconnection.example.demo.database.beans.Company;
import Openconnection.example.demo.database.beans.Coupon;

import java.util.List;
import java.util.Optional;

public interface CompanyService {
    boolean login(String email, String password) throws CompanyNotFoundException;

    void addCoupon(Coupon coupon)throws CouponNotFoundException;
    void updateCoupon(Coupon coupon)throws CouponNotFoundException;

    void deleteCoupon(int couponID)throws CouponNotFoundException;

    List<Coupon>companyCoupons()throws CompanyNotFoundException;
    List<Coupon>companyCoupons(Category category)throws CompanyNotFoundException;
    List<Coupon>companyCoupons(double MaxPrice)throws CompanyNotFoundException;
    void getCompanyDetails(Company company);



    boolean isCompanyExists(String email, String password) throws CompanyNotFoundException;

    void saveAndFlush(Company company) throws CompanyNotFoundException;

    void addCompany(Company company) throws CompanyNotFoundException;

    void updateCompany(Company company) throws CompanyNotFoundException;

    void deleteCompany(int companyID) throws CompanyNotFoundException;

    List<Company> getAllCompanies();

    Optional<Company> getOneCompany(int companyID) throws CompanyNotFoundException;

    void saveAll(List<Company> companies) throws CompanyNotFoundException;
}
