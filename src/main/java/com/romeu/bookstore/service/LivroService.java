package com.romeu.bookstore.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.romeu.bookstore.domain.Livro;
import com.romeu.bookstore.dtos.LivroDTO;
import com.romeu.bookstore.exceptions.ObjectNotFoundException;
import com.romeu.bookstore.repositories.LivroRepository;

@Service
public class LivroService {

	@Autowired
	private LivroRepository livroRepository;

	@Autowired
	private CategoriaService categoriaService;

	public Livro findById(Integer id) {
		Optional<Livro> obj = livroRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Livro não encontrato! ID: " + id));
	}

	public List<Livro> findAll() {
		List<Livro> livros = livroRepository.findAll();
		return livros;
	}

	public List<Livro> findAll(Integer id_cat) {
		/* Validação se a categoria existe */
		categoriaService.findByID(id_cat);
		return livroRepository.findByCategoria(id_cat);

	}

	public Livro create(Livro obj) {
		obj.setId(null);
		return livroRepository.save(obj);
	}

	public List<LivroDTO> livroToDTO(List<Livro> livros) {
		/*
		 * Converte uma lista de Livros em Livros DTO. Uma dúvida é se esse método pode
		 * ficar no Serviço
		 */
		return livros.stream().map(obj -> new LivroDTO(obj.getId(), obj.getTitulo(), obj.getCategoria().getDescricao()))
				.collect(Collectors.toList());
	}

	public Livro update(Integer id, Livro obj) {
		Livro newObj = findById(id);
		updateData(newObj, obj);
		return livroRepository.save(newObj);
	}

	private void updateData(Livro newObj, Livro obj) {
		newObj.setTitulo(obj.getTitulo());
		newObj.setNome_autor(obj.getNome_autor());
		newObj.setTexto(obj.getTexto());

	}

}
