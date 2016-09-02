package com.algaworks.brewer.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "cerveja")
public class Cerveja {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	@NotBlank(message = "SKU é obrigatório.")
	private String sku;
	@NotBlank(message = "Nome é obrigatório.")
	private String nome;
	@Size(min = 1, max = 50, message = "O tamanho da descricao deve estar entre 1 a 50 caracteres.")
	private String descricao;

	private BigDecimal valor;
	@Column(name = "teor_alcoolico")
	private BigDecimal teorAlcoolico;
	private BigDecimal comissao;
	@Column(name = "quantidadeEstoque")
	private Integer quantidadeEstoque;
	@Enumerated(EnumType.STRING)
	private Origem origem;
	@Enumerated(EnumType.STRING)
	private Sabor sabor;
	@ManyToOne
	@JoinColumn(name = "codigo_estilo")
	private Estilo estilo;

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
