package Openconnection.example.demo.Repository;

import Openconnection.example.demo.beans.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

    Boolean existsByEmailAndPassword(String email, String password);

    Optional<Company> findByName(String name);

    Boolean existsByEmail(String email);

    Optional<Company> findById(int id);



}
