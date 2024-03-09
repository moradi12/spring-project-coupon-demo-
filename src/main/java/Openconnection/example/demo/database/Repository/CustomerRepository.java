package Openconnection.example.demo.database.Repository;

import Openconnection.example.demo.database.beans.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Boolean existsByEmailAndPassword(String email, String password);
}
