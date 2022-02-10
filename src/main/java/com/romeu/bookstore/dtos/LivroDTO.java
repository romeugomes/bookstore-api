package com.romeu.bookstore.dtos;

import java.io.Serializable;

public class LivroDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String titulo;
	private String categoria;

	public LivroDTO(Integer id, String titulo, String categoria) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.categoria = categoria;
	}

	public LivroDTO() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	
}
