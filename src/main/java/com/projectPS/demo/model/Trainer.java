package com.projectPS.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Trainer extends UserAuth {
    private String orar;
    private int salariu;

    @OneToMany
    List<FitnessGroup> fitnessGroup;

    public Trainer(Long o, String name, String s, String s1, int sal, List<FitnessGroup> fitnessGroup) {
        setCNP(o);
        setName(name);
        setAddress(s);
        setOrar(s1);
        setSalariu(sal);
        setFitnessGroup(fitnessGroup);
    }
}
