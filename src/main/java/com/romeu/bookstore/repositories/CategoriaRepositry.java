package com.romeu.bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.romeu.bookstore.domain.Categoria;

@Repository
public interface CategoriaRepositry extends JpaRepository<Categoria, Integer> {

}
