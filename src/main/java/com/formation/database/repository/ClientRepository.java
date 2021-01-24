package com.formation.database.repository;

import com.formation.database.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client,Long> {

    //Liste des clients dont le code est x
    List<Client> findAllById(Long Id);
    //Liste des clients dont le telephone contient a ou l'adresse b ou le nom c
    List<Client> findAllByTelephoneContainsOrAdresseContainsOrNameContains(String a, String b, String c);
    //Afficher le nom et le téléphone des clients habitant à l’adresse x
    List<Client> findAllByAdresse(String adresse);
}
