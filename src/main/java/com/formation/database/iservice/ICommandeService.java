package com.formation.database.iservice;

import com.formation.database.models.Commandes;

import java.time.LocalDate;
import java.util.List;

public interface ICommandeService {

    List<Commandes> isterTousLesCommandes();

    List<Commandes> listerCommandeParDate(LocalDate d);

    List<Commandes> listerCommandeParIdClient(Long id);

    List<Commandes> listerCommandeEntreDeuxDate(LocalDate start,LocalDate end);

    List<Commandes> listerCommandesParAdresseEtTelStartWith(String adresse,String tel);

    //Liste des commandes dont la date est supérieure à d et effectuées par le client dont l’id est x
    List<Commandes> listerCommandeDontDateSupEtParClient(LocalDate date,Long id);
}
