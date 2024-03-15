package Openconnection.example.demo.clr;

import Openconnection.example.demo.beans.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Order
public class RestTest implements CommandLineRunner {

    private final RestTemplate restTemplate;

    @Autowired
    public RestTest(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        try {
            String url = "http://localhost:8080/api/coupons";
            Coupon response = restTemplate.getForObject(url, Coupon.class);
            System.out.println(response);

        } catch (Exception err) {
            System.out.println(err.getMessage());

        }
    }

}
