//package Openconnection.example.demo.ExecuteMethods;
//
//import Openconnection.example.demo.Exceptions.CompanyNotFoundException;
//import Openconnection.example.demo.Exceptions.ErrMsg;
//import Openconnection.example.demo.database.Repository.CompanyRepository;
//import Openconnection.example.demo.database.Service.CompanyService;
//import Openconnection.example.demo.database.beans.Company;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@RequiredArgsConstructor
//@Service
//public class CompanyServiceImp implements CompanyService {
//
//    private final CompanyRepository companyRepository;
//
//    @Override
//    public boolean isCompanyExists(String email, String password) throws CompanyNotFoundException {
//        boolean companyExists = companyRepository.existsByEmailAndPassword(email, password);
//        if (companyExists) {
//            return true;
//        } else {
//            throw new CompanyNotFoundException(ErrMsg.COMPANY_NOT_FOUND.getMsg());
//        }
//
//    }
//
//    public void addCompany(Company company) throws CompanyNotFoundException {
//        boolean companyExists = companyRepository.existsByEmailAndPassword(company.getName(), company.getEmail());
//        if (companyExists) {
//            throw new CompanyNotFoundException(ErrMsg.COMPANY_ALREADY_EXISTS.getMsg());
//        } else {
//            companyRepository.save(company);
//            System.out.println("Company added successfully: " + company);
//
//        }
//    }
//
//    @Override
//    public void updateCompany(Company company) throws CompanyNotFoundException {
//        if (!companyRepository.existsById(company.getId())) {
//            throw new CompanyNotFoundException(ErrMsg.COMPANY_NOT_FOUND.getMsg());
//        }
//        companyRepository.saveAndFlush(company);
//        System.out.println("Company updated successfully: " + company);
//    }
//
//
//    public void deleteCompany(int companyId) throws CompanyNotFoundException {
//        if (!companyRepository.existsById(companyId)) {
//            throw new CompanyNotFoundException(ErrMsg.COMPANY_NOT_FOUND.getMsg());
//        }
//        companyRepository.deleteById(companyId);
//        System.out.println("Company deleted successfully with ID: " + companyId);
//    }
//    @Override
//    public List<Company> getAllCompanies() {
//        return companyRepository.findAll();
//    }
//
//    @Override
//    public Company getOneCompany(int companyId) throws CompanyNotFoundException {
//        return companyRepository.findById(companyId)
//                .orElseThrow(() -> new CompanyNotFoundException(ErrMsg.COMPANY_NOT_FOUND.getMsg()));    }
//
//    @Override
//    public void saveAll(List<Company> companies) {
//        companyRepository.saveAll(companies);
//    }
//    }
//
