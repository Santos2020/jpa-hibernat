package com.restaurante.food.domain.repository;

import java.util.List;

import com.restaurante.food.domain.model.Cidade;

public interface CidadeRepository {

	List<Cidade> listar();
	Cidade buscar(Long Id);
	Cidade salvar(Cidade cidade);
	void remover(Long id);

}
