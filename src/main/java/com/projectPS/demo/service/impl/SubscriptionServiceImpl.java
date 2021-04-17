package com.projectPS.demo.service.impl;

import com.projectPS.demo.model.Subscription;
import com.projectPS.demo.model.Client;
import com.projectPS.demo.repository.SubscriptionRepository;
import com.projectPS.demo.repository.ClientRepository;
import com.projectPS.demo.service.SubscriptionService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    //@Autowired
    //private AbonamentRepository abonamentRepository;

    //injectare
    private final SubscriptionRepository subscriptionRepository;

    public SubscriptionServiceImpl(SubscriptionRepository subscriptionRepository, ClientRepository clientRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }


    @Override
    public Subscription findAbonamentByDurata(int durata) {
        return subscriptionRepository.findSubscriptionByDurata(28);
    }

    @Override
    public List<Subscription> findAll() {
        return (List<Subscription>) subscriptionRepository.findAll();
    }

    @Override
    @Transactional
    public Subscription updateAbonament(Subscription dtoSubscription, String dataInceput) {
        Subscription subscription = subscriptionRepository.findById(dtoSubscription.getId()).orElseThrow();
        subscription.setData_inceput(dataInceput);
        return subscription;
    }
}
