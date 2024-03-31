package Openconnection.example.demo.beans;

import lombok.Getter;

@Getter
public enum ClientType {

    ADMIN("Admin"),
    CUSTOMER("Customer"),
    COMPANY("Company"),
    GUEST("Guest");

    private String roleName;

    ClientType(String roleName) {
        this.roleName = roleName;
    }
}
