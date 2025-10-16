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

/**
 * Representa um slot (intervalo de tempo) na agenda de uma doca.
 * 
 * <p>Esta classe é uma entidade JPA, mapeada para a tabela "agenda_slots".
 * Ela define um período de tempo em uma data específica para uma doca, com um número
 * de vagas para agendamentos.</p>
 * 
 * <p>Relacionamentos:
 * <ul>
 *   <li>{@link Doca}: Muitos slots de agenda para uma doca ({@code @ManyToOne}).</li>
 * </ul>
 * </p>
 */
@Entity
@Table(name = "agenda_slots")
public class AgendaSlot {

	/**
	 * O identificador único do slot de agenda.
	 * É gerado automaticamente como um UUID.
	 */
	@Id
	@Column(name = "agenda_slot_id")
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;

	/**
	 * A data do slot de agenda.
	 */
	@Column(name = "data")
	private LocalDate data;

	/**
	 * A hora de início do slot de agenda.
	 */
	@Column(name = "hora")
	private LocalTime hora;

	/**
	 * O número total de vagas disponíveis neste slot.
	 */
	@Column(name = "vagas_totais")
	private int vagasTotais;

	/**
	 * O número de vagas que ainda estão disponíveis para agendamento.
	 */
	@Column(name = "vagas_disponiveis")
	private int vagasDisponiveis;

	/**
	 * O status do slot (ex: DISPONIVEL, LOTADO).
	 * Mapeado como uma String no banco de dados.
	 */
	@Column(name = "agenda_slot_status")
	@Enumerated(EnumType.STRING)
	private AgendaSlotStatus status;

	/**
	 * A doca à qual este slot de agenda pertence.
	 */
	@ManyToOne
	@JoinColumn(name = "doca_id")
	private Doca doca;

	/**
     * Construtor para criar um slot de agenda.
     * 
     * @param data A data do slot.
     * @param hora A hora de início do slot.
     * @param vagasTotais O número total de vagas.
     */
	public AgendaSlot(LocalDate data, LocalTime hora, int vagasTotais) {
		this.data = data;
		this.hora = hora;
		this.vagasTotais = vagasTotais;
		this.vagasDisponiveis = vagasTotais;
		this.status = AgendaSlotStatus.DISPONIVEL;

	}
    /**
     * Construtor para criar um slot de agenda associado a uma doca.
     * 
     * @param data A data do slot.
     * @param hora A hora de início do slot.
     * @param vagasTotais O número total de vagas.
     * @param doca A doca associada.
     */
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

	/**
     * Construtor padrão.
     */
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
