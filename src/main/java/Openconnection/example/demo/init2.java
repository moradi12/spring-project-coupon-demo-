//package Openconnection.example.demo;
//
//import Openconnection.example.demo.Exceptions.CompanyNotFoundException;
//import Openconnection.example.demo.Exceptions.CustomerException;
//import Openconnection.example.demo.database.Service.CompanyService;
//import Openconnection.example.demo.database.Service.CustomerService;
//import Openconnection.example.demo.database.beans.Company;
//import Openconnection.example.demo.database.beans.Customer;
//import lombok.RequiredArgsConstructor;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//
//@Component
//@RequiredArgsConstructor
//@Order(1)
//public class init2 implements CommandLineRunner {
//    private final CompanyService companyService;
//    private final CustomerService customerService;
//
//    @Override
//    public void run(String... args) {
//        try {
//            initializeData();
//        } catch (Exception e) {
//            System.err.println("An error occurred during data initialization: " + e.getMessage());
//        }
//    }
//
//    private void initializeData() throws CompanyNotFoundException, CustomerException {
//        companyService.addCompany(Company.builder()
//                .email("HardCodedCompany@gmail.com")
//                .name("HardCodedName")
//                .password("123456")
//                .build());
//
//        customerService.addCustomer(Customer.builder()
//                .email("HardCodedCustomer@gmail.com")
//                .firstName("Hard")
//                .lastName("Coded")
//                .password("123456")
//                .build());
//    }
//}
