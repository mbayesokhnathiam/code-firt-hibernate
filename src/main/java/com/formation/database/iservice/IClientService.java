package com.formation.database.iservice;

import com.formation.database.models.Client;

import java.util.List;

public interface IClientService {

    List<Client> listerClient(Long Id);

    List<Client> filterClientParTelNomAdresse(String a, String b, String c);

    List<Client> listerClientByAdresse(String adresse);
}
