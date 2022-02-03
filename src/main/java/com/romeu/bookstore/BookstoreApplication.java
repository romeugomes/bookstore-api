package com.romeu.bookstore;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.romeu.bookstore.domain.Categoria;
import com.romeu.bookstore.domain.Livro;
import com.romeu.bookstore.repositories.CategoriaRepositry;
import com.romeu.bookstore.repositories.LivroRepositry;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepositry categoriaRepositry;

	@Autowired
	private LivroRepositry livroRepositry;

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informatica", "Livros de TI");

		Livro l1 = new Livro(null, "Clean code", "Robert Martin", "Lorem ipsum", cat1);

		cat1.getLivros().addAll(Arrays.asList(l1));

		this.categoriaRepositry.saveAll(Arrays.asList(cat1));
		this.livroRepositry.saveAll(Arrays.asList(l1));
	}

}
