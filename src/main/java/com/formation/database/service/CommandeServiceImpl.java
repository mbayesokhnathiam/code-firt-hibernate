package com.formation.database.service;

import com.formation.database.iservice.ICommandeService;
import com.formation.database.models.Commandes;
import com.formation.database.repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CommandeServiceImpl implements ICommandeService {

    @Autowired
    CommandeRepository commandeRepository;

    @Override
    public List<Commandes> isterTousLesCommandes() {
        return commandeRepository.listerTousLesCommandes();
    }

    @Override
    public List<Commandes> listerCommandeParDate(LocalDate d) {
        return commandeRepository.findAllByDate(d);
    }

    @Override
    public List<Commandes> listerCommandeParIdClient(Long id) {
        return commandeRepository.findAllByClient_Id(id);
    }

    @Override
    public List<Commandes> listerCommandeEntreDeuxDate(LocalDate start, LocalDate end) {
        return commandeRepository.findAllByDateBetween(start,end);
    }

    @Override
    public List<Commandes> listerCommandesParAdresseEtTelStartWith(String adresse, String tel) {
        return commandeRepository.findAllCommandeByAdresseAndTelStartWith(adresse,tel);
    }

    @Override
    public List<Commandes> listerCommandeDontDateSupEtParClient(LocalDate date, Long id) {
        return commandeRepository.findAllByDateAfterAndClient_Id(date,id);
    }
}
