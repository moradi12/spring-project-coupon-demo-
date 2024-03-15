package Openconnection.example.demo.ServiceImpl;

import Openconnection.example.demo.Exceptions.CompanyNotFoundException;
import Openconnection.example.demo.Exceptions.CouponNotFoundException;
import Openconnection.example.demo.Exceptions.ErrMsg;
import Openconnection.example.demo.Repository.CompanyRepository;
import Openconnection.example.demo.Repository.CouponRepository;
import Openconnection.example.demo.Service.CompanyService;
import Openconnection.example.demo.beans.Category;
import Openconnection.example.demo.beans.Company;
import Openconnection.example.demo.beans.Coupon;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    CompanyRepository companyRepository;
    @Autowired
    CouponRepository couponRepository;

    private int companyID;

    @Override
    public boolean isCompanyExists(String email, String password) throws CompanyNotFoundException {
        if (!companyRepository.existsByEmailAndPassword(email, password)) {
            throw new CompanyNotFoundException(ErrMsg.COMPANY_NOT_FOUND.getMsg());
        }
        return true;
    }

    @Override
    public void addCoupon(Coupon coupon) throws CouponNotFoundException {
        Optional<Company> companyOptional = companyRepository.findById(coupon.getCompanyId());
        if (companyOptional.isEmpty()) {
            throw new CouponNotFoundException(ErrMsg.COMPANY_NOT_FOUND.getMsg());
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
    public void addCompany(Company company) throws CompanyNotFoundException {
        if (companyRepository.existsById(company.getId())) {
            throw new CompanyNotFoundException(ErrMsg.COMPANY_ALREADY_EXISTS.getMsg());
        }
        companyRepository.save(company);
        System.out.println("Company added: " + company);
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
    public List<Coupon> companyCoupons() throws CompanyNotFoundException {
        throw new CompanyNotFoundException(ErrMsg.COMPANY_NOT_FOUND.getMsg());
    }

    @Override
    public List<Coupon> companyCoupons(Category category) throws CompanyNotFoundException {
        throw new CompanyNotFoundException(ErrMsg.COMPANY_NOT_FOUND.getMsg());
    }

    @Override
    public List<Coupon> companyCoupons(double maxPrice) throws CompanyNotFoundException {
        throw new CompanyNotFoundException(ErrMsg.COMPANY_NOT_FOUND.getMsg());
    }

    @Override
    public void getCompanyDetails(Company company) {
    }

    @Override
    public void saveAll(List<Company> companies) throws CompanyNotFoundException {
        companyRepository.saveAll(companies);
        System.out.println("All companies saved: " + companies.size() + " companies.");
    }
}
