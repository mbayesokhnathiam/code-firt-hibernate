package com.formation.database.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "clients")
@Data
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Column(name = "name",unique = true)
    private String name;

    private String adresse;

    private String telephone;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "client")
    //FetchType.Lazy les donnees de relation ne viennent pas avec l'object, elles sont a la demande
    //FetchType.EAGER les donnees de relation viennent avec l'object automatiquement
    //Ex si on fait un findById de Client on aura tous les commandes associees a ce client (EAGER), si c'est LAZY on aura seulement l'objet client sans les commandes
    //MappedBy se refere au nom d'object se trouvant au niveau de la classe Commandes
    private List<Commandes> commandes;






}
