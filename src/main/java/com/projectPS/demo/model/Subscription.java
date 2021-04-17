package com.projectPS.demo.model;

import com.projectPS.demo.constants.SubscriptionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@DynamicUpdate

public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    SubscriptionType tip;

    @ManyToOne
    //@JoinColumn(name = "client_id")
    Client client;

    @ManyToOne
    //@JoinColumn(name = "grupa_id")
    FitnessGroup fitnessGroup;

    private String data_inceput;
    private int durata;

}
