package com.restaurante.food.domain.repository;

import java.math.BigDecimal;
import java.util.List;

import com.restaurante.food.domain.model.Restaurante;

public interface RestauranteRepositoryQueries {

	List<Restaurante> find(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal);

}
