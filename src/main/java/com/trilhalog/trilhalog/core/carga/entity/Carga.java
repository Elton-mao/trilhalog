package com.trilhalog.trilhalog.core.carga.entity;

import java.math.BigDecimal;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cargas")
public class Carga {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "carga_id ")
	private String id;

	@Column(name = "descricao")
	private String descricao;

	@Column(name = "observacao")
	private String observacao;

	@Column(name = "quantidade")
	private BigDecimal quantidade;
	

	public Carga(String descricao, String observacao, BigDecimal quantidade) {
		this.descricao = descricao;
		this.observacao = observacao;
		this.quantidade = quantidade;
	}
	public Carga() {
	
	}

	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public BigDecimal getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public int hashCode() {
		return Objects.hash(descricao, id, observacao, quantidade);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carga other = (Carga) obj;
		return Objects.equals(descricao, other.descricao) && Objects.equals(id, other.id)
				&& Objects.equals(observacao, other.observacao) && Objects.equals(quantidade, other.quantidade);
	}

	@Override
	public String toString() {
		return "Carga [id=" + id + ", descricao=" + descricao + ", observacao=" + observacao + ", quantidade="
				+ quantidade + "]";
	}

}
