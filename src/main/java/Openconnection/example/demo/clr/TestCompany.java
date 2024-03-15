package Openconnection.example.demo.clr;

import Openconnection.example.demo.Service.CompanyService;
import Openconnection.example.demo.beans.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Component
@Order(1) // Set order value
public class TestCompany implements CommandLineRunner {

    @Autowired
    RestTemplate restTemplate;

    private final CompanyService companyService;

    @Autowired
    public TestCompany(CompanyService companyService) {
        this.companyService = companyService;
    }

    /**
     * Adds predefined companies to the database
     *
     * @throws Exception If an error occurs while adding companies
     */
    @Override
    public void run(String... args) throws Exception {
        try {
            // Creating and saving the first company
            Company company1 = Company.builder()
                    .id(1)
                    .name("hafranit")
                    .email("email@email.com")
                    .password("ggwP")
                    .build();
            companyService.addCompany(company1);

            // Creating and saving the second company
            Company company2 = Company.builder()
                    .id(2)
                    .name("Tom Company")
                    .email("Tom@email.com")
                    .password("Tompassword32")
                    .build();
            companyService.addCompany(company2);

            // Creating and saving the third company
            Company company3 = Company.builder()
                    .id(3)
                    .name("Shani company")
                    .email("shani@email.com")
                    .password("shani321")
                    .build();
            companyService.addCompany(company3);

            // Creating and saving the fourth company
            Company company4 = Company.builder()
                    .id(4)
                    .name("Farkash Company")
                    .email("Frash@email.com")
                    .password("Farkash321")
                    .build();
            companyService.addCompany(company4);

            // Creating and saving the fifth company
            Company company5 = Company.builder()
                    .id(5)
                    .name("LP")
                    .email("LP@email.com")
                    .password("LPpassword321")
                    .build();
            companyService.addCompany(company5);

            // Update company
            Company updatedCompany = Company.builder()
                    .id(2)
                    .email("Thomasnew@mail.com")
                    .name("ThomasGever")
                    .password("newPassword")
                    .build();
            companyService.updateCompany(updatedCompany);

            // Printing all companies
            System.out.println("All Companies:");
            companyService.getAllCompanies().forEach(System.out::println);

            // Deleting a company with ID 2
            companyService.deleteCompany(2);
            System.out.println("Deleting company with ID 2...");

            // Printing remaining companies
            System.out.println("Remaining Companies:");
            companyService.getAllCompanies().forEach(System.out::println);

            // Posting companies to API
            restTemplate.postForEntity("http://localhost:8080/api/companies", company1, Company.class);
            restTemplate.postForEntity("http://localhost:8080/api/companies", company2, Company.class);
            restTemplate.postForEntity("http://localhost:8080/api/companies", company3, Company.class);

            // Getting all companies from API
            System.out.println(restTemplate.getForObject("http://localhost:8080/api/companies/all", String.class));

            // Deleting a company with ID 2 from API
            restTemplate.delete("http://localhost:8080/api/companies/{id}", 2);
            System.out.println("Deleting company with ID 2...");

            // Getting all companies after deletion from API
            Company[] companies = restTemplate.getForObject("http://localhost:8080/api/companies/all", Company[].class);
            if (companies != null) {
                Arrays.stream(companies).forEach(System.out::println);
            }

            // Getting companies by name from API
            Company[] companiesByName = restTemplate.getForObject("http://localhost:8080/api/companies/byName/{name}", Company[].class, "Electronics Sale");
            if (companiesByName != null) {
                Arrays.stream(companiesByName).forEach(System.out::println);
            }
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}
