package com.formation.database.repository;

import com.formation.database.models.Modeles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModeleRepository extends JpaRepository<Modeles,Long> {
}
