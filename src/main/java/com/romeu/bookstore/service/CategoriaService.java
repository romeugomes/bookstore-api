package com.romeu.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.romeu.bookstore.domain.Categoria;
import com.romeu.bookstore.dtos.CategoriaDTO;
import com.romeu.bookstore.exceptions.DataIntegretyViolationException;
import com.romeu.bookstore.exceptions.ObjectNotFoundException;
import com.romeu.bookstore.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;

	public Categoria findByID(Integer id) {
		Optional<Categoria> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrato! ID: " + id));
	}

	public List<Categoria> findAll() {
		return repository.findAll();
	}

	public Categoria create(Categoria obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public Categoria update(Integer id, CategoriaDTO objDto) {
		Categoria obj = findByID(id);
		obj.setNome(objDto.getNome());
		obj.setDescricao(objDto.getDescricao());
		return repository.save(obj);
	}
	
	public void delete(Integer id) {
		findByID(id);
		try {
			repository.deleteById(id);
		} catch (DataIntegretyViolationException e) {
			throw new DataIntegretyViolationException("Categoria não pode ser deletado! Possui livro associados!"); 
		}
	}

}
