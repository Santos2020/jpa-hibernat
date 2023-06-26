package com.restaurante.food.domain.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.restaurante.food.domain.model.Estado;

@Repository
public interface EstadoRepository {

	List<Estado> listar();
    Estado buscar(Long Id);
    Estado salvar(Estado estado);
	void remover(Long Id);

}
