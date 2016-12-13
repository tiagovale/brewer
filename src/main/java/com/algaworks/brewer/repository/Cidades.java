package com.algaworks.brewer.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworks.brewer.model.Cidade;
import com.algaworks.brewer.repository.filter.CidadeFilter;

public interface Cidades extends JpaRepository<Cidade, Long> {
	public List<Cidade> findByEstadoCodigo(Long codigoEstado);

	public Optional<Cidade> findByNomeIgnoreCase(String nome);

	public Page<Cidade> filtrar(CidadeFilter cidadeFilter, Pageable pageable);
}
