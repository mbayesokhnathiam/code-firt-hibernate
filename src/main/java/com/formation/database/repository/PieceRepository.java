package com.formation.database.repository;

import com.formation.database.models.Fournisseur;
import com.formation.database.models.Piece;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PieceRepository extends JpaRepository<Piece,Long> {

    //Liste des pièces dont le prix dépasse x et fabriquées par le fournisseur d’id x
    List<Piece> findAllByPrixGreaterThanAndFournisseur_Id(int prix,Long idFournisseur);

    //Liste des pieces dont le delai est compris entre x et y
    List<Piece> findAllByDelaiLivrBetween(int start, int end);

    //Liste des pieces de modele x et fournisseur y
    List<Piece> findAllByModele_IdAndFournisseur_Id(Long idModel, Long idFrournisseur);

    
}
