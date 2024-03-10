package Openconnection.example.demo.clr;

import Openconnection.example.demo.Exceptions.ErrMsg;
import Openconnection.example.demo.database.Repository.CompanyRepository;
import Openconnection.example.demo.database.beans.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DeleteCompany implements CommandLineRunner {

    private final CompanyRepository companyRepository;

    @Autowired
    public DeleteCompany(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }


    /**
     * delete a company by ID */
    @Override
    public void run(String... args) throws Exception {
        // Delete a company by ID
        int companyIdToDelete = 4; // Change this to the ID of the company you want to delete

        Optional<Company> companyOptional = companyRepository.findById(companyIdToDelete);
        if (companyOptional.isPresent()) {
            companyRepository.deleteById(companyIdToDelete);
            System.out.println("Company with ID " + companyIdToDelete + " deleted successfully.");
        } else {
            System.out.println(ErrMsg.COMPANY_NOT_FOUND.getMsg() + " with ID " + companyIdToDelete);
        }
    }
}
