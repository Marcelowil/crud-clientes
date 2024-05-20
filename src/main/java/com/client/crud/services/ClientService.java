package com.client.crud.services;

import com.client.crud.dto.ClientDTO;
import com.client.crud.entities.Client;
import com.client.crud.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    public ClientDTO findById (Long id){
        Optional<Client> client = repository.findById(id);
        ClientDTO dto = new ClientDTO(client.get());
        return dto;
    }

}
