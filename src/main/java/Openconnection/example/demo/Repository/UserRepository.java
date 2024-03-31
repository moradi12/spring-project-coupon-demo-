package Openconnection.example.demo.Repository;

import Openconnection.example.demo.beans.Credentials;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Credentials, Integer> {

    Credentials findByUserNameAndUserPass(String userName, String userPass);}
