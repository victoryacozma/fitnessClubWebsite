package com.projectPS.demo.service.impl;

import com.projectPS.demo.dto.ClientDTO;
import com.projectPS.demo.model.Client;
import com.projectPS.demo.repository.ClientRepository;
import com.projectPS.demo.repository.SubscriptionRepository;
import com.projectPS.demo.service.ClientService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;

    public ClientServiceImpl( ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<Client> findAllClients(){
        return clientRepository.findAll();
    }

    @Override
    public Client findClientByCNP(Long id){
        return clientRepository.findClientByCNP(id);
    }

    @Override
    public Client findClientByName(String name) {
        return clientRepository.findClientByName(name);
    }

    @Override
    @Transactional
    public Client updateClient(Client client, String name, String adresa) {
        Client client1 = clientRepository.findClientByCNP(client.getCNP());
        client1.setName(name);
        client1.setAddress(adresa);
        return client1;
    }

    @Override
    public Client updateClient(ClientDTO clientDTO) {
        Client client1 = clientRepository.findClientByCNP(clientDTO.getId());
        client1.setName(clientDTO.getName());
        client1.setAddress(clientDTO.getAddress());
        client1.setPassword(clientDTO.getPassword());
        System.out.println("Datele noi ale clientului: " + client1);
        clientRepository.save(client1);
        return client1;
    }

    @Override
    public Client addClient(Long id, String name, String adresa) {
        Client client = new Client(id, name, adresa);
        clientRepository.save(client);
        return client;
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}
