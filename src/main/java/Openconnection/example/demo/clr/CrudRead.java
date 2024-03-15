package Openconnection.example.demo.clr;

import Openconnection.example.demo.Repository.CompanyRepository;
import Openconnection.example.demo.Repository.CouponRepository;
import Openconnection.example.demo.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(6)
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
