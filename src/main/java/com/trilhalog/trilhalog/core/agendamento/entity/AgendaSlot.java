package com.trilhalog.trilhalog.core.agendamento.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

import com.trilhalog.trilhalog.core.agendamento.enums.AgendaSlotStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "agenda_slots")
public class AgendaSlot {

	@Id
	@Column(name = "agenda_slot_id")
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;

	@Column(name = "data")
	private LocalDate data;

	@Column(name = "hora")
	private LocalTime hora;

	@Column(name = "vagas_totais")
	private int vagasTotais;

	@Column(name = "vagas_disponiveis")
	private int vagasDisponiveis;

	@Column(name = "agenda_slot_status")
	@Enumerated(EnumType.STRING)
	private AgendaSlotStatus status;

	@ManyToOne
	@JoinColumn(name = "doca_id")
	private Doca doca;

	public AgendaSlot(LocalDate data, LocalTime hora, int vagasTotais) {
		this.data = data;
		this.hora = hora;
		this.vagasTotais = vagasTotais;
		this.vagasDisponiveis = vagasTotais;
		this.status = AgendaSlotStatus.DISPONIVEL;

	}
	public AgendaSlot(LocalDate data, LocalTime hora, int vagasTotais, Doca doca) {
	    this.data = data;
	    this.hora = hora;
	    this.vagasTotais = vagasTotais;
	    this.vagasDisponiveis = vagasTotais;
	    this.doca = doca;
	    this.status = AgendaSlotStatus.DISPONIVEL;
	}

	public AgendaSlotStatus getStatus() {
		return status;
	}

	public void setStatus(AgendaSlotStatus status) {
		this.status = status;
	}

	public AgendaSlot() {

	}

	public Doca getDoca() {
		return doca;
	}

	public void setDoca(Doca doca) {
		this.doca = doca;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public int getVagasTotais() {
		return vagasTotais;
	}

	public void setVagasTotais(int vagasTotais) {
		this.vagasTotais = vagasTotais;
	}

	public int getVagasDisponiveis() {
		return vagasDisponiveis;
	}

	public void setVagasDisponiveis(int vagasDisponiveis) {
		this.vagasDisponiveis = vagasDisponiveis;
	}

	@Override
	public String toString() {
		return "AgendaSlot [id=" + id + ", data=" + data + ", hora=" + hora + ", vagasTotais=" + vagasTotais
				+ ", vagasDisponiveis=" + vagasDisponiveis + ", doca=" + doca + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(data, doca, hora, id, vagasDisponiveis, vagasTotais);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AgendaSlot other = (AgendaSlot) obj;
		return Objects.equals(data, other.data) && Objects.equals(doca, other.doca) && Objects.equals(hora, other.hora)
				&& Objects.equals(id, other.id) && vagasDisponiveis == other.vagasDisponiveis
				&& vagasTotais == other.vagasTotais;
	}

}
