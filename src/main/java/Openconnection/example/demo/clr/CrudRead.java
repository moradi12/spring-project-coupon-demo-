package Openconnection.example.demo.clr;

import Openconnection.example.demo.database.Repository.CompanyRepository;
import Openconnection.example.demo.database.Repository.CouponRepository;
import Openconnection.example.demo.database.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(4)
public class CrudRead implements CommandLineRunner {
    @Autowired
    CouponRepository couponRepository;
    @Autowired

    CompanyRepository companyRepository;
    @Autowired

    CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {

        companyRepository.findAll().forEach(System.out::println);
        customerRepository.findAll().forEach(System.out::println);
        couponRepository.findAll().forEach(System.out::println);


    }
}
