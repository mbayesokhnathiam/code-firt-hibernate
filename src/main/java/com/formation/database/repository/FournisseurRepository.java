package com.formation.database.repository;

import com.formation.database.models.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FournisseurRepository extends JpaRepository<Fournisseur,Long> {

    //Liste des fournisseur spécialisés dans la vente du type de produit x
    @Query("select f from Fournisseur  f where f.typeProduit=:typeprod")
    List<Fournisseur> getAllFournisseurBYPieceID(@Param("typeprod") Long id);

    //Liste des fournisseurs habitant à l’adresse a et évoluant dans la vente du type de produit z
    @Query("select f from Fournisseur f where f.adresse=:adresse and f.typeProduit=:typeprod")
    List<Fournisseur> getAllFournisseurByIDAndProduit(@Param("adresse") String adresse, @Param("typeprod") Long id);

    //Liste des fournisseurs dont le nom commence par x ou ladresse se termine par y ou e numéro de téléphone contient z
    List<Fournisseur> findAllByNomsStartingWithOrAdresseEndsWithOrNumeroTelContains(String x, String y, String z);

    //Liste des fournisseurs par type produit
    @Query(value = "SELECT f.*, f.id as type FROM fournisseurs f GROUP BY (f.id)",nativeQuery = true)
    List<Object> findAllGroupingByTp();

    //Liste des fournisseurs par adresse
    @Query(value = "SELECT f.*, f.adresse as adresse_fournisseur FROM fournisseurs f GROUP BY (f.adresse)",nativeQuery = true)
    List<Object> findAllGroupingByAdresse();
}
