//package Openconnection.example.demo.clr;
//
//import Openconnection.example.demo.Exceptions.CustomerException;
//import Openconnection.example.demo.Service.AdminService;
//import Openconnection.example.demo.Service.CompanyService;
//import Openconnection.example.demo.Service.CouponService;
//import Openconnection.example.demo.Service.CustomerService;
//import Openconnection.example.demo.beans.Company;
//import Openconnection.example.demo.beans.Customer;
//import lombok.RequiredArgsConstructor;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//@Component
//@RequiredArgsConstructor
//public class AdminTester implements CommandLineRunner {
//    final CompanyService companyService;
//    final CustomerService customerService;
//    final CouponService couponService;
//    final AdminService adminService;
//
//    @Override
//    public void run(String... args) throws Exception {
//        System.out.println("Admin methods below");
//
//        try {
//            // Adding companies using builder pattern
//            companyService.addCompany(Company.builder()
//                    .id(1)
//                    .name("OnlyAdminCompany")
//                    .email("AdminCompany@company.com")
//                    .password("323232")
//                    .build());
//
//            companyService.addCompany(Company.builder()
//                    .id(2)
//                    .name("Fire")
//                    .email("Fireeeeee@company.com")
//                    .password("32321")
//                    .build());
//
//            // Updating company using builder pattern
//            companyService.updateCompany(Company.builder()
//                    .id(3)
//                    .name("UpdateName")
//                    .email("newMail@mail.mail")
//                    .password("update12")
//                    .build());
//
//            // Deleting company
//            companyService.deleteCompany(3); // Assuming a method to delete company by id exists
//
//            // Retrieving a single company by id (e.g., 1)
//            System.out.println(companyService.getOneCompany(2));
//
//            // Retrieving all companies
//            companyService.getAllCompanies().forEach(System.out::println);
//
//            // Creating customers
//            createCustomers();
//        } catch (Exception e) {
//            System.err.println("An error occurred while executing admin methods: " + e.getMessage());
//        }
//    }
//
//    private void createCustomers() {
//        try {
//            // Creating customers
//            Customer customer1 = Customer.builder()
//                    .firstName("John")
//                    .lastName("Doe")
//                    .email("john.doe@example.com")
//                    .password("password1")
//                    .build();
//
//            Customer customer2 = Customer.builder()
//                    .firstName("Alice")
//                    .lastName("Smith")
//                    .email("alice.smith@example.com")
//                    .password("password2")
//                    .build();
//
//            Customer customer3 = Customer.builder()
//                    .firstName("Bob")
//                    .lastName("Johnson")
//                    .email("bob.johnson@example.com")
//                    .password("password3")
//                    .build();
//
//            // Save customers
//            customerService.addCustomer(customer1);
//            customerService.addCustomer(customer2);
//            customerService.addCustomer(customer3);
//        } catch (CustomerException e) {
//            System.err.println("An error occurred while creating customers: " + e.getMessage());
//        }
//    }
//}
