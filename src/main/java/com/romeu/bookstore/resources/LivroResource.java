package com.romeu.bookstore.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.romeu.bookstore.domain.Livro;
import com.romeu.bookstore.dtos.LivroDTO;
import com.romeu.bookstore.service.LivroService;

@RestController
@RequestMapping(value = "/livros")
public class LivroResource {

	@Autowired
	private LivroService livroService;

	@GetMapping
	public ResponseEntity<List<LivroDTO>> findAllByCategoria(
			@RequestParam(value = "categoria", defaultValue = "0") Integer id_cat) {
		List<Livro> list;
		if (id_cat == 0) {
			list = livroService.findAll();
		} else {
			list = livroService.findAll(id_cat);
		}
		return ResponseEntity.ok().body(livroService.livroToDTO(list));
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Livro> findById(@PathVariable Integer id) {
		Livro livro = livroService.findById(id);
		return ResponseEntity.ok().body(livro);
	}

	@PostMapping
	public ResponseEntity<Livro> create(@RequestBody Livro obj) {
		obj = livroService.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

}