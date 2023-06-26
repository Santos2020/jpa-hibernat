package com.restaurante.food.domain.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.restaurante.food.domain.model.Restaurante;

@Repository
public interface RestauranteRepository {
	
	List<Restaurante> listar();
	Restaurante buscar(Long Id);
	Restaurante salvar(Restaurante restaurante);
	void remover(Restaurante restaurante);

}
