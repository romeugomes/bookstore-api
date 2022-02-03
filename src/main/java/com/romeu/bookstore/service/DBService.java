package com.romeu.bookstore.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.romeu.bookstore.domain.Categoria;
import com.romeu.bookstore.domain.Livro;
import com.romeu.bookstore.repositories.CategoriaRepositry;
import com.romeu.bookstore.repositories.LivroRepositry;

@Service
public class DBService {

	@Autowired
	private CategoriaRepositry categoriaRepositry;

	@Autowired
	private LivroRepositry livroRepositry;
	
	public void instanciaBaseDeDados() {
		Categoria cat1 = new Categoria(null, "Informática", "Livro de Informática");
		Categoria cat2 = new Categoria(null, "Ficção Cientifica", "Livro de Ficção Científica");
		Categoria cat3 = new Categoria(null, "Biografia", "Livro de Biografias");

		Livro l1 = new Livro(null, "Clean Code", "Robert", "Lorem ipsum", cat1);
		Livro l2 = new Livro(null, "Engenharia de software", "Louis", "Lorem ipsum", cat1);
		Livro l3 = new Livro(null, "The Time Machine", "H. G. ", "Lorem ipsum", cat2);
		Livro l4 = new Livro(null, "The War of the Worlds", "H. G.", "Lorem ipsum", cat2);
		Livro l5 = new Livro(null, "I, Robot", "Isaac Asimov", "Lorem ipsum", cat2);

		cat1.getLivros().addAll(Arrays.asList(l1, l2));
		cat2.getLivros().addAll(Arrays.asList(l3, l4, l5));
		
		categoriaRepositry.saveAll(Arrays.asList(cat1, cat2, cat3));
		livroRepositry.saveAll(Arrays.asList(l1, l2, l3, l4, l5));


	}

}
