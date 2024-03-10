package Openconnection.example.demo.clr;

import Openconnection.example.demo.Exceptions.ErrMsg;
import Openconnection.example.demo.database.Repository.CompanyRepository;
import Openconnection.example.demo.database.beans.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UpdateCompany implements CommandLineRunner {

    private final CompanyRepository companyRepository;

    /**
     * Constructor to inject CompanyRepository dependency
     * @param companyRepository The CompanyRepository instance
     */
    @Autowired
    public UpdateCompany(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    /**
     * Runs the command line task to update a company
     * @throws Exception If any error occurs during the update process
     */
    @Override
    public void run(String... args) throws Exception {
        // Example usage of the updateCompany method
        updateCompany(1, "Shani Dota company", "Dota@gmail.com", "updatedPass321");
    }

    /**
     * Updates a company with the specified ID
     * @param id The ID of the company to update
     * @param name The new name of the company
     * @param email The new email of the company
     * @param password The new password of the company
     */
    private void updateCompany(int id, String name, String email, String password) {
        try {
            Optional<Company> optionalCompany = companyRepository.findById(id);
            if (optionalCompany.isPresent()) {
                Company existingCompany = optionalCompany.get();

                // Check if the new email address is already used by another company!!!
                if (!existingCompany.getEmail().equals(email) && companyRepository.existsByEmail(email)) {
                    System.out.println("Error: Email address'" + email + "'already exists for another company");
                    return;
                }

                existingCompany.setName(name);
                existingCompany.setEmail(email);
                existingCompany.setPassword(password);

                companyRepository.saveAndFlush(existingCompany);
                System.out.println("Company with ID " + id + "updated successfully");
            } else {
                System.out.println("Error: Company not found with ID " + id);
            }
        } catch (Exception e) {
            System.out.println("Error occurred during company update for ID " + id + ": " + e.getMessage());
        }
    }
}
