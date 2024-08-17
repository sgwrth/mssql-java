package de.asiegwarth.mssql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.asiegwarth.mssql.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    
}
