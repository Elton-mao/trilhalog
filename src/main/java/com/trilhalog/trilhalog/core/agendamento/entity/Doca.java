package com.trilhalog.trilhalog.core.agendamento.entity;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "docas")
public class Doca {

	@Id
	@Column(name = "doca_id")
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;

	@Column(name = "nome", unique = true)
	private String nome;

	@OneToMany(mappedBy = "doca")
	List<AgendaSlot> agendaSlots;

	public Doca() {

	}

	public Doca(String nome) {
		this.nome = nome;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Doca other = (Doca) obj;
		return Objects.equals(id, other.id) && Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return "Doca [id=" + id + ", nome=" + nome + "]";
	}

}
