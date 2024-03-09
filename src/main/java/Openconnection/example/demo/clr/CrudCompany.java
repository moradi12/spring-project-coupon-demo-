package Openconnection.example.demo.clr;

import Openconnection.example.demo.Exceptions.CouponNotFoundException;
import Openconnection.example.demo.Exceptions.ErrMsg;
import Openconnection.example.demo.database.Repository.CompanyRepository;
import Openconnection.example.demo.database.beans.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Optional;
//todo ask zeev why the first one down there is not working what is the problem ?
@Component
@Order(2)
public class CrudCompany implements CommandLineRunner {

    private final CompanyRepository companyRepository;

    @Autowired
    public CrudCompany(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }


    @Override
    public void run(String... args) {
        try {
            Optional<Company> existingCompany = companyRepository.findByName("David Company");
            if (existingCompany != null) {
                System.out.println("Company 'David Company' already exists.");
            } else {
                Company company1 = Company.builder()
                        .name("David Company")
                        .email("Company@Company.com")
                        .password("password123")
                        .build();
                companyRepository.save(company1);
                System.out.println("Company 'David Company' created successfully.");
            }

            existingCompany = companyRepository.findByName("Shai Company");
            if (existingCompany != null) {
                System.out.println("Company 'Shai Company' already exists.");
            } else {
                Company company2 = Company.builder()
                        .name("Shai Company")
                        .email("Shai@pop.com")
                        .password("popo321")
                        .build();
                companyRepository.save(company2);
                System.out.println("Company 'Shai Company' created successfully.");
            }
        } catch (Exception e) {
            System.out.println("Error occurred during company creation: " + ErrMsg.COMPANY_ERROR.getMsg());
        }
    }
}


//todo: why is this 1 not working ?? what is the problem ? ask zeevik
//    @Override
//    public void run(String... args) {
//
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

