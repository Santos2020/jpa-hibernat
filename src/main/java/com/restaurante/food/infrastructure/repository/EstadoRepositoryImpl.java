package com.restaurante.food.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import com.restaurante.food.domain.model.Estado;
import com.restaurante.food.domain.repository.EstadoRepository;

@Component
public  class EstadoRepositoryImpl implements EstadoRepository {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Estado> listar() {
		return manager.createQuery("from Estado", Estado.class).getResultList();
	}

	@Override
	public Estado buscar(Long Id) {
		return manager.find(Estado.class, Id);
	}

	@Transactional
	@Override
	public Estado salvar(Estado Estado) {
		return manager.merge(Estado);
	}

	@Transactional
	@Override
	public void remover(Long Id) {
		Estado estado = buscar(Id);
		
		if(estado == null) {
			throw new EmptyResultDataAccessException(1);
		}
		manager.remove(estado);

	}

}
