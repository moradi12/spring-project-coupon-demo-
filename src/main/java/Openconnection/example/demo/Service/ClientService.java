package Openconnection.example.demo.Service;

import Openconnection.example.demo.Exceptions.AdminException;
import Openconnection.example.demo.Exceptions.CompanyNotFoundException;
import Openconnection.example.demo.Exceptions.CustomerException;

public interface ClientService {


    boolean Login(String email, String password) throws AdminException, CompanyNotFoundException, CustomerException;
}

