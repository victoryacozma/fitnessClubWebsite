package com.projectPS.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Client extends UserAuth {

    @OneToOne
    Subscription subscriptions;

    public Client(Long id, String nume, String oras, Subscription ab){
        super(id, nume, oras);
        setCNP(id);
        setName(nume);
        setAddress(oras);
        //setAbonamente(ab);
    }

    public Client(Long id, String nume, String oras){
        super(id, nume, oras);
        setCNP(id);
        setName(nume);
        setAddress(oras);
    }

    public Client(Long Cnp, String username, String password, String nume, String oras){
        super(Cnp, username, password, nume, oras);
        this.username = username;
        this.password = password;
        this.CNP = Cnp;
        this.name = nume;
        this.address = oras;
    }

}
