package com.algaworks.algafood.domain.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.algaworks.algafood.domain.model.Estado;

@Repository
public interface EstadoRepository {

	List<Estado> listar();
    Estado buscar(Long Id);
    Estado salvar(Estado estado);
	void remover(Long Id);

}
