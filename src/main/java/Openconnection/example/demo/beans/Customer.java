package Openconnection.example.demo.beans;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "customers")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(min = 3, max = 20)
    @Column(nullable = false, length = 20)
    private String firstName;

    @NotNull
    @Size(min = 3, max = 20)
    @Column(nullable = false, length = 40)
    private String lastName;

    @NotNull
    @Size(min = 5, max = 50)
    @Column(nullable = false, length = 40)
    private String email;

    @NotNull
    @Size(min = 6, max = 20, message = "Password length must be between 6 and 20 characters")
    @Column(nullable = false, length = 40)
    private String password;

    @OneToMany(cascade = CascadeType.ALL)
    @Singular
    private List<Coupon> coupons;
}