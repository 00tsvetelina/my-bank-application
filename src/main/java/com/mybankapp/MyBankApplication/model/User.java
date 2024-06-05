package com.mybankapp.MyBankApplication.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "accounts")
    private List<Account> accounts;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

}
