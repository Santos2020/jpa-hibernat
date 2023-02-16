package com.algaworks.algafood.domain.repository;

import java.util.List;

import com.algaworks.algafood.domain.model.Estado;

public interface EstadoRepository {

	List<Estado> listar();

    Estado buscar(Long Id);

    Estado salvar(Estado estado);

	void remover(Estado estado);

}
