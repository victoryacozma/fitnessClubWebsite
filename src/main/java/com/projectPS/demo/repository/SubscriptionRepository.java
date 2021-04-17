package com.projectPS.demo.repository;

import com.projectPS.demo.model.Subscription;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscriptionRepository extends CrudRepository<Subscription, Long> {
    Subscription findSubscriptionByDurata(int durata);
    List<Subscription> findAllByDurata(int durata);

}
