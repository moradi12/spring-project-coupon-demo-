package Openconnection.example.demo.ServiceImpl;

import Openconnection.example.demo.Exceptions.*;
import Openconnection.example.demo.Repository.CompanyRepository;
import Openconnection.example.demo.Repository.CouponRepository;
import Openconnection.example.demo.Service.CompanyService;
import Openconnection.example.demo.beans.Category;
import Openconnection.example.demo.beans.Company;
import Openconnection.example.demo.beans.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    CompanyRepository companyRepository;
    @Autowired
    CouponRepository couponRepository;

    @Override
    public void addCoupon(Coupon coupon) throws CouponNotFoundException {
        int id = coupon.getId();
        if (couponRepository.existsById(id)) {
            throw new CouponNotFoundException(ErrMsg.COUPON_ID_ALREADY_EXISTS.getMsg());
        }
        couponRepository.save(coupon);
        System.out.println("Coupon added: " + coupon);
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
    public List<Coupon> getCompanyCoupons() throws CompanyNotFoundException {
        throw new CompanyNotFoundException(ErrMsg.COMPANY_NOT_FOUND.getMsg());
    }

    @Override
    public List<Coupon> getCompanyCoupons(Category category) throws CompanyNotFoundException {
        throw new CompanyNotFoundException(ErrMsg.COMPANY_NOT_FOUND.getMsg());
    }

    @Override
    public List<Coupon> getCompanyCoupons(double MaxPrice) throws CompanyNotFoundException {
        throw new CompanyNotFoundException(ErrMsg.COMPANY_NOT_FOUND.getMsg());
    }

    @Override
    public void getCompanyDetails(Company company) {
        // Implementation to get and print company details
        System.out.println("Company Details: " + company);
    }

    @Override
    public boolean isCompanyExists(String email, String password) throws CompanyNotFoundException {
        if (!companyRepository.existsByEmailAndPassword(email, password)) {
            throw new CompanyNotFoundException(ErrMsg.COMPANY_NOT_FOUND.getMsg());
        }
        return true;
    }

    @Override
    public void addCompany(Company company) throws CompanyAlreadyExistsException {
        if (companyRepository.existsById(company.getId())) {
            throw new CompanyAlreadyExistsException(ErrMsg.COMPANY_ALREADY_EXISTS.getMsg());
        }
        companyRepository.save(company);
    }

    @Override
    public void updateCompany(Company company) throws CompanyNotFoundException {
        if (!companyRepository.existsById(company.getId())) {
            throw new CompanyNotFoundException(ErrMsg.COMPANY_NOT_FOUND.getMsg());
        }
        companyRepository.saveAndFlush(company);
        System.out.println("Company updated: " + company);
    }

    @Override
    public void deleteCompany(int companyID) throws CompanyNotFoundException {
        if (!companyRepository.existsById(companyID)) {
            throw new CompanyNotFoundException(ErrMsg.COMPANY_NOT_FOUND.getMsg());
        }
        companyRepository.deleteById(companyID);
        System.out.println("Company deleted with ID: " + companyID);
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Optional<Company> getOneCompany(int companyID) throws CompanyNotFoundException {
        Optional<Company> companyOptional = companyRepository.findById(companyID);
        if (companyOptional.isEmpty()) {
            throw new CompanyNotFoundException(ErrMsg.COMPANY_NOT_FOUND.getMsg());
        }
        return companyOptional;
    }

    @Override
    public void saveAll(List<Company> companies) {
        companyRepository.saveAll(companies);
        System.out.println("All companies saved: " + companies.size() + " companies.");
    }

    @Override
    public boolean Login(String email, String password) throws AdminException, CompanyNotFoundException, CustomerException {
        return false;
    }
}
