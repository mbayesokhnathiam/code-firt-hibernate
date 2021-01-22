package com.formation.database.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pieces")
@Data
public class Piece {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Column(name = "numero_piece",length = 20,nullable = false)
    private String numeroPiece;

    @Column(name = "prix")
    private int prix;

    @Column(name = "delai_livr")
    private int delaiLivr;


    @ManyToOne
    @JoinColumn(name = "fournisseur_id",referencedColumnName = "Id")
    private Fournisseur fournisseur;


    @ManyToOne
    @JoinColumn(name = "modele_id",referencedColumnName = "Id")
    private Modeles modele;
}
