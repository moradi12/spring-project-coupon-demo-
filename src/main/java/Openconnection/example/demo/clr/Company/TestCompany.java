package Openconnection.example.demo.clr.Company;

import Openconnection.example.demo.database.ServiceInterface.CompanyService;
import Openconnection.example.demo.database.beans.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order
public class TestCompany implements CommandLineRunner {

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

            companyService.addCompany(Company.builder()
                    .id(1)
                    .name("hafranit")
                    .email("email@email.com")
                    .password("ggwP")
                    .build());

            companyService.addCompany(Company.builder()
                    .id(2)
                    .name("Tom Company")
                    .email("Tom@email.com")
                    .password("Tompassword32")
                    .build());


            companyService.addCompany(Company.builder()
                    .id(3)
                    .name("Shani company")
                    .email("shani@email.com")
                    .password("shani321")
                    .build());


            companyService.addCompany(Company.builder()
                    .id(4)
                    .name("Farkash Company")
                    .email("Frash@email.com")
                    .password("Farkash321")
                    .build());


            companyService.addCompany(Company.builder()
                    .id(5)
                    .name("LP")
                    .email("LP@email.com")
                    .password("LPpassword321")
                    .build());




            companyService.updateCompany(Company.builder()
                    .id(2)
                    .email("Thomasnew@mail.com")
                    .name("ThomasGever")
                    .password("newPassword")
                    .build());


            companyService.deleteCompany(3);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}


//// the old methods

//        addCompanyIfNotExists("DanielDB", "Daniel@gmail.com", "passw32103");
//        addCompanyIfNotExists("Lola 2", "Loli@po.com", "password2");
//        addCompanyIfNotExists("Bambi 3", "Bambi@Bambi.com", "Bomba32");
//        addCompanyIfNotExists("Ted 4", "Lasso@Ted.com", "Ted48");
//        addCompanyIfNotExists("Shai 5", "Shai@mail.com", "passkey4");


//    private void addCompanyIfNotExists(String name, String email, String password) throws Exception {
//        if (!companyService.isCompanyExists(email, password)) {
//            Company company = new Company();
//            company.setName(name);
//            company.setEmail(email);
//            company.setPassword(password);
//            companyService.addCompany(company);
//            System.out.println("Company added successfully: " + name);
//        } else {
////            System.out.println("Failed to add company: " + name + ". Company already exists");
////            throw new Exception(ErrMsg.COMPANY_ALREADY_EXISTS.getMsg());
////        }
//}
//}
