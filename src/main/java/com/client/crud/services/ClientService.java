package com.client.crud.services;

import com.client.crud.dto.ClientDTO;
import com.client.crud.entities.Client;
import com.client.crud.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    @Transactional(readOnly = true)
    public ClientDTO findById (Long id){
        Optional<Client> client = repository.findById(id);
        ClientDTO dto = new ClientDTO(client.get());
        return dto;
    }

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll (Pageable pageable){
        Page<Client> client = repository.findAll(pageable);
        return  client.map(x -> new ClientDTO(x));
    }

}
