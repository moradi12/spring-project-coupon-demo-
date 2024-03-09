package Openconnection.example.demo.database.ServiceInterface;

import Openconnection.example.demo.Exceptions.CompanyNotFoundException;
import Openconnection.example.demo.Exceptions.ErrMsg;
import Openconnection.example.demo.database.Repository.CompanyRepository;
import Openconnection.example.demo.database.beans.Company;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CompanyServiceImpl implements CompanyService {
    @Autowired
    CompanyRepository companyRepository;

    //        int id = coupon.getId();
    //        if (couponRepository.existsById(id)) {
    //            throw new CouponNotFoundException(ErrMsg.COMPANY_ALREADY_EXISTS.getMsg());
    //        }
    //        couponRepository.save(coupon);
    //    }//
    @Override
    public boolean isCompanyExists(String email, String password) throws CompanyNotFoundException {
        if (!companyRepository.existsByEmailAndPassword(email, password)) {
            throw new CompanyNotFoundException(ErrMsg.COMPANY_NOT_FOUND.getMsg());
        }
        return true;
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
    public void saveAll(List<Company> companies) throws CompanyNotFoundException {
        companyRepository.saveAll(companies);
    }
}
