//package Openconnection.example.demo.clr.Company;
//
//import com.coupon.project.database.Repository.CompaniesRepository;
//import com.coupon.project.database.Service.CompanyService;
//import com.coupon.project.database.beans.Company;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.core.annotation.Order;
//
//import java.util.Optional;
//
////@Component
//@Order(5)
//public class DeleteCompany implements CommandLineRunner {
//
//    @Autowired
//    CompanyService companyService;
//    @Autowired
//    CompaniesRepository companiesRepository;
//
//    /**
//     * Deletes a company with the specified ID
//     * @param args Command line arguments
//     * @throws Exception If an error occurs during execution
//     */
//
//    @Override
//    public void run(String... args) throws Exception {
//
//        Optional<Company> companyToDelete = companiesRepository.findById(1); // Change the id to the one you want to delete
//        companyToDelete.ifPresent(company -> {
//            companiesRepository.delete(company);
//            System.out.println("Company deleted successfully");
//        });
//
//    }
//}
//
