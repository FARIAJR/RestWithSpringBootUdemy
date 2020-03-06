package br.com.projects.udemy.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.projects.udemy.java.data.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

}