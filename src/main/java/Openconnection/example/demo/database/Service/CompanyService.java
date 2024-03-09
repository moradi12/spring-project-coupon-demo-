//package Openconnection.example.demo.database.Service;
//
//
//import Openconnection.example.demo.Exceptions.CompanyNotFoundException;
//import Openconnection.example.demo.database.beans.Company;
//
//import java.util.List;
//
//public interface CompanyService {
//
//    boolean isCompanyExists(String email, String password) throws CompanyNotFoundException;
//
//
//    void addCompany(Company company) throws CompanyNotFoundException;
//    void updateCompany(Company company) throws CompanyNotFoundException;
//    void deleteCompany(int companyID) throws CompanyNotFoundException;
//    List<Company> getAllCompanies();
//    Company getOneCompany(int companyID) throws CompanyNotFoundException;
//
//    void saveAll(List<Company> companies) throws CompanyNotFoundException;
//}
