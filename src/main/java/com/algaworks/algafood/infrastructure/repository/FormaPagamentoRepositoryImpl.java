package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.algaworks.algafood.domain.model.FormaPagamento;
import com.algaworks.algafood.domain.repository.FormaPagamentoRepository;

@Component
public abstract class FormaPagamentoRepositoryImpl implements FormaPagamentoRepository {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<FormaPagamento> listar() {
		return manager.createQuery("from FormaPagamento", FormaPagamento.class).getResultList();
	}

	@Override
	public FormaPagamento buscar(Long Id) {
		return manager.find(FormaPagamento.class, Id);
	}

	@Transactional
	@Override
	public FormaPagamento salvar(FormaPagamento FormaPagamento) {
		return manager.merge(FormaPagamento);
	}

	@Transactional
	@Override
	public void remover(FormaPagamento FormaPagamento) {
		FormaPagamento = buscar(FormaPagamento.getId());
		manager.remove(FormaPagamento);

	}

}
