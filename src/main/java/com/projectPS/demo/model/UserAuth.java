package com.projectPS.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

public class UserAuth {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long CNP;

    protected String username;

    protected String password;

    protected String name;
    protected String address;

    public UserAuth(Long Cnp, String nume, String oras){
        CNP = Cnp;
        name = nume;
        address = oras;
    }

    public UserAuth(Long Cnp, String username, String password, String nume, String oras){
        this.username = username;
        this.password = password;
        this.CNP = Cnp;
        this.name = nume;
        this.address = oras;
    }

}
