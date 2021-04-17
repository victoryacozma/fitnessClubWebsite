package com.projectPS.demo.repository;

import com.projectPS.demo.model.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
    Client findClientByCNP(Long id);
    Client findClientByName(String name);
    List<Client> findAll();
}
