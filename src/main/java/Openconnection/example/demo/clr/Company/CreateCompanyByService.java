//package Openconnection.example.demo.clr.Company;
//
//import Openconnection.example.demo.Exceptions.ErrMsg;
//import Openconnection.example.demo.database.ServiceInterface.CompanyService;
//import Openconnection.example.demo.database.beans.Company;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//@Component
//public class CreateCompanyByService implements CommandLineRunner {
//
//    private final CompanyService companyService;
//
//    @Autowired
//    public CreateCompanyByService(CompanyService companyService) {
//        this.companyService = companyService;
//    }
//
//    /**
//     * Adds predefined companies to the database
//     *
//     * @throws Exception If an error occurs while adding companies
//     */
//    @Override
//    public void run(String... args) throws Exception {
//        addCompanyIfNotExists("DanielDB", "Daniel@gmail.com", "passw32103");
//        addCompanyIfNotExists("Lola 2", "Loli@po.com", "password2");
//        addCompanyIfNotExists("Bambi 3", "Bambi@Bambi.com", "Bomba32");
//        addCompanyIfNotExists("Ted 4", "Lasso@Ted.com", "Ted48");
//        addCompanyIfNotExists("Shai 5", "Shai@mail.com", "passkey4");
//    }
//
//    private void addCompanyIfNotExists(String name, String email, String password) throws Exception {
//        if (!companyService.isCompanyExists(email, password)) {
//            Company company = new Company();
//            company.setName(name);
//            company.setEmail(email);
//            company.setPassword(password);
//            companyService.addCompany(company);
//            System.out.println("Company added successfully: " + name);
//        } else {
//            System.out.println("Failed to add company: " + name + ". Company already exists");
//            throw new Exception(ErrMsg.COMPANY_ALREADY_EXISTS.getMsg());
//        }
//    }
//}
