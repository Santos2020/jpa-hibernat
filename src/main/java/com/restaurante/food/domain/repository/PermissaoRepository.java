package com.restaurante.food.domain.repository;

import java.util.List;

import com.restaurante.food.domain.model.Permissao;

public interface PermissaoRepository {

	List<Permissao> listar();

	Permissao buscar(Long Id);

	Permissao salvar(Permissao permissao);

	void remover(Permissao permissao);

}
