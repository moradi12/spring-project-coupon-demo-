package Openconnection.example.demo.clr;

import Openconnection.example.demo.Exceptions.ErrMsg;
import Openconnection.example.demo.database.Repository.CompanyRepository;
import Openconnection.example.demo.database.beans.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Order(2)
public class CrudCompany implements CommandLineRunner {

    private final CompanyRepository companyRepository;

    @Autowired
    public CrudCompany(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }


    /**
     * Runs the command line task to create companies if they do not already exist
     */

    @Override
    public void run(String... args) {
        try {
            createCompanyIfNotExists("David Company", "Company@Company.com", "password123");
            createCompanyIfNotExists("Shai Company", "Shai@dora.com", "popo321");
            createCompanyIfNotExists("DanaAb", "Dana@AB.com", "s1587DD");
            createCompanyIfNotExists("Moti", "MOti@mail.com", "Motale");
            createCompanyIfNotExists("Katarian", "Kata@mail.com", "Kitty");
        } catch (Exception e) {
            System.out.println("Error occurred during company creation:" + ErrMsg.COMPANY_ERROR.getMsg());
        }
    }


    /**
     * Creates a company if it does not already exist
     * @param name The name of the company
     * @param email The email of the company
     * @param password The password of the company
     */

    private void createCompanyIfNotExists(String name, String email, String password) {
        Optional<Company> existingCompany = companyRepository.findByName(name);
        if (existingCompany.isPresent()) {
            System.out.println("Company '" + name + "already exists");
        } else {
            Company company = Company.builder()
                    .name(name)
                    .email(email)
                    .password(password)
                    .build();
            companyRepository.save(company);
            System.out.println("Company '" + name + "'created successfully");
        }
    }
}


























//package Openconnection.example.demo.clr;
//
//import Openconnection.example.demo.Exceptions.CouponNotFoundException;
//import Openconnection.example.demo.Exceptions.ErrMsg;
//import Openconnection.example.demo.database.Repository.CompanyRepository;
//import Openconnection.example.demo.database.beans.Company;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//
//import java.util.Optional;
////todo ask zeev why the first one down there is not working what is the problem ?
//@Component
//@Order(2)
//public class CrudCompany implements CommandLineRunner {
//
//    private final CompanyRepository companyRepository;
//
//    @Autowired
//    public CrudCompany(CompanyRepository companyRepository) {
//        this.companyRepository = companyRepository;
//    }
//    @Override
//    public void run(String... args) {
//        try {
//            Company company1 = Company.builder()
//                    .name("David Company")
//                    .email("Company@Company.com")
//                    .password("password123")
//                    .build();
//            companyRepository.save(company1);
//            System.out.println("Company 'David Company' created successfully.");
//
//            Company company2 = Company.builder()
//                    .name("Shai Company")
//                    .email("Shai@pop.com")
//                    .password("popo321")
//                    .build();
//            companyRepository.save(company2);
//            System.out.println("Company 'Shai Company' created successfully.");
//        } catch (Exception e) {
//            System.out.println("Error occurred during company creation: " + ErrMsg.COMPANY_ERROR.getMsg());
//        }
//    }
//}



























//        try {
//            Optional<Company> existingCompany = companyRepository.findByName("David Company");
//            if (existingCompany != null) {
//                System.out.println("Company 'David Company' already exists.");
//            } else {
//                Company company1 = Company.builder()
//                        .name("David Company")
//                        .email("Company@Company.com")
//                        .password("password123")
//                        .build();
//                companyRepository.save(company1);
//                System.out.println("Company 'David Company' created successfully.");
//            }
//
//            existingCompany = companyRepository.findByName("Shai Company");
//            if (existingCompany != null) {
//                System.out.println("Company 'Shai Company' already exists.");
//            } else {
//                Company company2 = Company.builder()
//                        .name("Shai Company")
//                        .email("Shai@pop.com")
//                        .password("popo321")
//                        .build();
//                companyRepository.save(company2);
//                System.out.println("Company 'Shai Company' created successfully.");
//            }
//        } catch (Exception e) {
//            System.out.println("Error occurred during company creation: " + ErrMsg.COMPANY_ERROR.getMsg());
//        }
//    }
//}


//todo: why is this 1 not working ?? what is the problem ? ask zeevik//
//    @Override
//    public void run(String... args) {
//

