package com.formation.database.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "fournisseurs")
@Data
public class Fournisseur {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Column(name = "noms")
    private String noms;
    @Column(name = "adresse")
    private String adresse;
    @Column(name = "numero_tel")
    private String numeroTel;
    @Column(name = "type_produit")
    private String typeProduit;

    @OneToMany(mappedBy = "fournisseur",fetch = FetchType.LAZY)
    private List<Piece> pieces;
}
