package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.EstadoRepository;

@Component
public abstract class EstadoRepositoryImpl implements EstadoRepository {

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
	public void remover(Estado Estado) {
		Estado = buscar(Estado.getId());
		manager.remove(Estado);

	}

}
