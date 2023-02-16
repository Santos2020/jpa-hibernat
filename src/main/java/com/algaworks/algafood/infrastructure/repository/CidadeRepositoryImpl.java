package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.repository.CidadeRepository;

@Component
public abstract class CidadeRepositoryImpl implements CidadeRepository {

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
	public void remover(Cidade Cidade) {
		Cidade = buscar(Cidade.getId());
		manager.remove(Cidade);

	}

}
