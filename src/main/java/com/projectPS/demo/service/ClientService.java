package com.projectPS.demo.service;

import com.projectPS.demo.dto.ClientDTO;
import com.projectPS.demo.model.Client;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ClientService {
    List<Client> findAllClients();
    Client findClientByCNP(Long id);
    Client findClientByName(String name);
    Client updateClient(Client client, String name, String adresa);
    Client updateClient(ClientDTO clientDTO);
    Client addClient(Long id, String name, String adresa);
    void deleteClient(Long id);
}
