package com.romeu.bookstore.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.romeu.bookstore.domain.Categoria;

public interface Resources {
	public ResponseEntity<Object> findById(@PathVariable Integer id);

}
