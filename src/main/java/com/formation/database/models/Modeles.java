package com.formation.database.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "modeles")
@Data
public class Modeles {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "modele_seq")
    @SequenceGenerator(name = "modele_seq", initialValue = 2, allocationSize = 4)

    private Long Id;

    @Column(name = "numero_modele")
    private String numeroModele;

    private int taille;

    private int stock_reverse;

    @ManyToOne
    @JoinColumn(name="piece_id", nullable=false,referencedColumnName = "Id")
    private Piece piece;

    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "modeles")
    private List<Commandes> commandes;


    @OneToMany(mappedBy = "modele",fetch = FetchType.LAZY)
    private List<Piece> pieces;


}
