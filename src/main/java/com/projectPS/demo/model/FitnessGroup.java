package com.projectPS.demo.model;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Entity
@NoArgsConstructor
@Data
public class FitnessGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long nr_grupa;

    @OneToMany
    List<Subscription> subscriptions;


    public FitnessGroup(Long nr_grupa, List<Subscription> subscriptions) {
        setNr_grupa(nr_grupa);
        setSubscriptions(subscriptions);

    }
}
