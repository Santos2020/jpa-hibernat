package com.restaurante.food.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import com.restaurante.food.domain.model.Cidade;
import com.restaurante.food.domain.repository.CidadeRepository;

@Component
public  class CidadeRepositoryImpl implements CidadeRepository {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Cidade> listar() {
		return manager.createQuery("from Cidade", Cidade.class).getResultList();
	}

	@Override
	public Cidade buscar(Long Id) {
		return manager.find(Cidade.class, Id);
	}

	@Transactional
	@Override
	public Cidade salvar(Cidade Cidade) {
		return manager.merge(Cidade);
	}

	@Transactional
	@Override
	public void remover(Long id) {
		Cidade cidade = buscar(id);
		
		if(cidade == null) {
			throw new EmptyResultDataAccessException(1);
		}
		
		manager.remove(cidade);

	}

}
