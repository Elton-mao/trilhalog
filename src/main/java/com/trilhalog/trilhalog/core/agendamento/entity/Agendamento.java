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

@Entity
@Table(name = "agendamentos")
public class Agendamento {

	@Id
	@Column(name = "agendamento_id")
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;

	@Enumerated(EnumType.STRING)
	@Column(name = "status_agendamento")
	private StatusDoAgendamento status;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_agendamento")
	private TipoDoAgendamento tipoDoAgendamento;

	@ManyToOne
	@JoinColumn(name = "agenda_slot_id")
	private AgendaSlot agendaSlot;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "carga_id")
	private Carga carga;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	public Agendamento( TipoDoAgendamento tipoDoAgendamento) {
		this.tipoDoAgendamento = tipoDoAgendamento;

	}
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
