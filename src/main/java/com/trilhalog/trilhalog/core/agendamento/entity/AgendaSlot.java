package com.trilhalog.trilhalog.core.agendamento.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
	
	@Column(name ="data")
	private LocalDate data;
	
	@Column(name ="hora")
	private LocalTime hora;
	
	@Column(name ="vagas_totais")
	private int vagasTotais; 
	
	@Column(name ="vagas_disponiveis")
	private int vagasDisponiveis;
	
	@ManyToOne
	@JoinColumn( name= "doca_id")
	private Doca doca;
	
	public AgendaSlot(LocalDate data,LocalTime hora, int vagasTotais, int vagasDisponiveis) {
		this.data = data;
		this.hora = hora;
		this.vagasTotais = vagasTotais;
		this.vagasDisponiveis = vagasDisponiveis;
		
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
