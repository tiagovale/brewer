package com.algaworks.brewer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.brewer.model.Cidade;
import com.algaworks.brewer.repository.Cidades;
import com.algaworks.brewer.service.exception.NomeEstiloJaCadastradoException;

@Service
public class CadastroCidadeService {
	@Autowired
	private Cidades cidades;

	@Transactional
	public void salvar(Cidade cidade) {
		Optional<Cidade> cidadeOptional = cidades.findByNomeIgnoreCase(cidade.getNome());
		if (cidadeOptional.isPresent()) {
			throw new NomeEstiloJaCadastradoException("Nome da cidade já cadastrada");
		}
		cidades.save(cidade);
	}
}
