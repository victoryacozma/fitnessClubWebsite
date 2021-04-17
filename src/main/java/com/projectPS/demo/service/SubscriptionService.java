package com.projectPS.demo.service;

import com.projectPS.demo.model.Subscription;
import com.projectPS.demo.model.Client;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SubscriptionService {

    Subscription findAbonamentByDurata(int durata);
    List<Subscription> findAll();
    Subscription updateAbonament(Subscription subscription, String dataInceput);

}
