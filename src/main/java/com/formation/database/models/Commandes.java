package com.formation.database.models;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "commandes")
@Data
public class Commandes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private LocalDate date;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "commande_modele", joinColumns = {
            @JoinColumn(name = "commande_id", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "modele_id",
                    nullable = false, updatable = false) })
    private List<Modeles> modeles;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable=false,referencedColumnName = "Id")
    private Client client;
}
