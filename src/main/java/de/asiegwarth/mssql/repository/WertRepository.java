package de.asiegwarth.mssql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.asiegwarth.mssql.entity.Wert;

@Repository
public interface WertRepository extends JpaRepository<Wert, Integer> {
    
}