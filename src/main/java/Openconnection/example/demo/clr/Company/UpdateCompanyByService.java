//package Openconnection.example.demo.clr.Company;
//
//import Openconnection.example.demo.Exceptions.CompanyNotFoundException;
//import Openconnection.example.demo.Exceptions.ErrMsg;
//import Openconnection.example.demo.database.ServiceInterface.CompanyService;
//import Openconnection.example.demo.database.beans.Company;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//
//@Component
//@Order(5)
//public class UpdateCompanyByService implements CommandLineRunner {
//    private final int companyIdToUpdate = 1; // The company ID to update
//    @Autowired
//    private CompanyService companyService;
//
//    @Override
//    public void run(String... args) throws Exception {
//
//
//
//
////        try {
////            updateCompanyById(companyIdToUpdate);
////        } catch (CompanyNotFoundException e) {
////            System.out.println("Company not found for update: " + ErrMsg.COMPANY_NOT_FOUND.getMsg());
////        } catch (Exception e) {
////            System.out.println("An error occurred while updating the company: " + e.getMessage());
////        }
////    }
////
////
////    private void updateCompanyById(int companyId) throws CompanyNotFoundException {
////        Company company = companyService.getOneCompany(companyId)
////                .orElseThrow(() -> new CompanyNotFoundException(ErrMsg.COMPANY_NOT_FOUND.getMsg()));
////        company.setEmail("DanaBannana@example.com");
////        company.setPassword("PleaseWork");
////        try {
////            companyService.updateCompany(company);
////            companyService.saveAndFlush(company);
////            System.out.println("Company updated successfully with ID: " + companyId);
////        } catch (Exception e) {
////            System.out.println("Failed to update company with ID " + companyId + "Error!" + e.getMessage());
////        }
//    }
//}
