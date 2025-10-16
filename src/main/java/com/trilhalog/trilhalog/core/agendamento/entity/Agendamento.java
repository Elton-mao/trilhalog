package com.trilhalog.trilhalog.core.agendamento.entity;

import java.util.Objects;

import com.trilhalog.trilhalog.core.agendamento.enums.StatusDoAgendamento;
import com.trilhalog.trilhalog.core.agendamento.enums.TipoDoAgendamento;
import com.trilhalog.trilhalog.core.carga.entity.Carga;
import com.trilhalog.trilhalog.core.usuario.entity.Usuario;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 * Representa a entidade Agendamento no banco de dados.
 * 
 * <p>Esta classe é uma entidade JPA, mapeada para a tabela "agendamentos".
 * Ela armazena as informações sobre um agendamento de carga ou descarga em uma doca.</p>
 * 
 * <p>Relacionamentos:
 * <ul>
 *   <li>{@link AgendaSlot}: Muitos agendamentos para um slot de agenda ({@code @ManyToOne}).</li>
 *   <li>{@link Carga}: Um agendamento para uma carga ({@code @OneToOne}).</li>
 *   <li>{@link Usuario}: Muitos agendamentos para um usuário ({@code @ManyToOne}).</li>
 * </ul>
 * </p>
 */
@Entity
@Table(name = "agendamentos")
public class Agendamento {

	/**
	 * O identificador único do agendamento.
	 * É gerado automaticamente como um UUID.
	 */
	@Id
	@Column(name = "agendamento_id")
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;

	/**
	 * O status atual do agendamento (ex: AGENDADO, CANCELADO, CONCLUIDO).
	 * Mapeado como uma String no banco de dados.
	 */
	@Enumerated(EnumType.STRING)
	@Column(name = "status_agendamento")
	private StatusDoAgendamento status;

	/**
	 * O tipo do agendamento (ex: CARGA, DESCARGA).
	 * Mapeado como uma String no banco de dados.
	 */
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_agendamento")
	private TipoDoAgendamento tipoDoAgendamento;

	/**
	 * O slot de agenda (horário) associado a este agendamento.
	 */
	@ManyToOne
	@JoinColumn(name = "agenda_slot_id")
	private AgendaSlot agendaSlot;

	/**
	 * A carga associada a este agendamento.
	 * A operação em cascata ALL garante que a carga seja salva/atualizada/removida junto com o agendamento.
	 */
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "carga_id")
	private Carga carga;

	/**
	 * O usuário que realizou o agendamento.
	 */
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	/**
     * Construtor que inicializa o agendamento com o tipo.
     * 
     * @param tipoDoAgendamento O tipo do agendamento.
     */
	public Agendamento( TipoDoAgendamento tipoDoAgendamento) {
		this.tipoDoAgendamento = tipoDoAgendamento;
		

	}
    /**
     * Construtor padrão.
     */
	public Agendamento() {

	}

	public AgendaSlot getAgendaSlot() {
		return agendaSlot;
	}

	public void setAgendaSlot(AgendaSlot agendaSlot) {
		this.agendaSlot = agendaSlot;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public StatusDoAgendamento getStatus() {
		return status;
	}

	public void setStatus(StatusDoAgendamento status) {
		this.status = status;
	}

	public TipoDoAgendamento getTipoDoAgendamento() {
		return tipoDoAgendamento;
	}

	public void setTipoDoAgendamento(TipoDoAgendamento tipoDoAgendamento) {
		this.tipoDoAgendamento = tipoDoAgendamento;
	}

	public Carga getCarga() {
		return carga;
	}

	public void setCarga(Carga carga) {
		this.carga = carga;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Agendamento [id=" + id + ", status=" + status + ", tipoDoAgendamento=" + tipoDoAgendamento
				+ ", agendaSlot=" + agendaSlot + ", carga=" + carga + ", usuario=" + usuario + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(agendaSlot, carga, id, status, tipoDoAgendamento, usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agendamento other = (Agendamento) obj;
		return Objects.equals(agendaSlot, other.agendaSlot) && Objects.equals(carga, other.carga)
				&& Objects.equals(id, other.id) && status == other.status
				&& tipoDoAgendamento == other.tipoDoAgendamento && Objects.equals(usuario, other.usuario);
	}

}
