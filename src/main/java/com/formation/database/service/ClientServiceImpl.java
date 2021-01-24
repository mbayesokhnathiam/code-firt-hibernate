package com.formation.database.service;

import com.formation.database.iservice.IClientService;
import com.formation.database.models.Client;
import com.formation.database.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements IClientService {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public List<Client> listerClient(Long Id) {
        return clientRepository.findAllById(Id);
    }

    @Override
    public List<Client> filterClientParTelNomAdresse(String a, String b, String c) {
        return clientRepository.findAllByTelephoneContainsOrAdresseContainsOrNameContains(a,b,c);
    }

    @Override
    public List<Client> listerClientByAdresse(String adresse) {
        return clientRepository.findAllByAdresse(adresse);
    }
}
