package Openconnection.example.demo.database.ServiceInterface;

import Openconnection.example.demo.Exceptions.CompanyNotFoundException;
import Openconnection.example.demo.Exceptions.CouponNotFoundException;
import Openconnection.example.demo.Exceptions.ErrMsg;
import Openconnection.example.demo.database.Repository.CompanyRepository;
import Openconnection.example.demo.database.beans.Category;
import Openconnection.example.demo.database.beans.Company;
import Openconnection.example.demo.database.beans.Coupon;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CompanyServiceImpl implements CompanyService {
    @Autowired
    CompanyRepository companyRepository;

    @Override
    public boolean login(String email, String password) throws CompanyNotFoundException {
        return false;
    }

    @Override
    public boolean isCompanyExists(String email, String password) throws CompanyNotFoundException {
        if (!companyRepository.existsByEmailAndPassword(email, password)) {
            throw new CompanyNotFoundException(ErrMsg.COMPANY_NOT_FOUND.getMsg());
        }
        return true;
    }


    @Override
    public void addCoupon(Coupon coupon) throws CouponNotFoundException {

    }

    @Override
    public void updateCoupon(Coupon coupon) throws CouponNotFoundException {


    }

    @Override
    public void deleteCoupon(int couponID) throws CouponNotFoundException {

    }




    @Override
    public void saveAndFlush(Company company) throws CompanyNotFoundException {
        try {
            companyRepository.saveAndFlush(company);
        } catch (Exception ex) {
            throw new CompanyNotFoundException(ErrMsg.COMPANY_ERROR.getMsg());
        }
    }


    @Override
    public void addCompany(Company company) throws CompanyNotFoundException {
        if (companyRepository.existsById(company.getId())) {
            throw new CompanyNotFoundException(ErrMsg.COMPANY_ALREADY_EXISTS.getMsg());
        }
        companyRepository.save(company);
    }

    @Override
    public void updateCompany(Company company) throws CompanyNotFoundException {
        if (!companyRepository.existsById(company.getId())) {
            throw new CompanyNotFoundException(ErrMsg.COMPANY_NOT_FOUND.getMsg());
        }
        companyRepository.saveAndFlush(company);
    }

    @Override
    public void deleteCompany(int companyID) throws CompanyNotFoundException {
        if (!companyRepository.existsById(companyID)) {
            throw new CompanyNotFoundException(ErrMsg.COMPANY_NOT_FOUND.getMsg());
        }
        companyRepository.deleteById(companyID);
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

        return null;
    }

    @Override
    public List<Coupon> companyCoupons(Category category) throws CompanyNotFoundException {
        return null;
    }

    @Override
    public List<Coupon> companyCoupons(double MaxPrice) throws CompanyNotFoundException {


        return null;
    }

    @Override
    public void getCompanyDetails(Company company) {

    }


    @Override
    public void saveAll(List<Company> companies) throws CompanyNotFoundException {
        companyRepository.saveAll(companies);
    }
}
