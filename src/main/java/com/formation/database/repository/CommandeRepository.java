package com.formation.database.repository;

import com.formation.database.models.Commandes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface CommandeRepository extends JpaRepository<Commandes,Long> {
    //Liste de toutes les commandes
    @Query("select c from Commandes c")
    List<Commandes> listerTousLesCommandes();

    //Liste des commandes dont la date est d
    List<Commandes> findAllByDate(LocalDate d);

    //Liste des commandes effectuées par le client dont l’id est x
    List<Commandes> findAllByClient_Id(Long id);

    //Liste des commandes effectuées entre la date a et la date b
    List<Commandes> findAllByDateBetween(LocalDate start,LocalDate end);

    //Liste des commandes des clients habitant à x et dont leur numéro de téléphone commence par y
    @Query("select c from Commandes c where c.client.adresse=:adresse and c.client.telephone like %:tel%")
    List<Commandes> findAllCommandeByAdresseAndTelStartWith(@Param("tel")String tel);

    //Liste des commandes dont la date est supérieure à d et effectuées par le client dont l’id est x
    List<Commandes> findAllByDateAfterAndClient_Id(LocalDate date,Long id);
}
