package com.trilhalog.trilhalog.core.agendamento.entity;

import java.util.Objects;

import com.trilhalog.trilhalog.core.agendamento.enums.StatusAProvacao;
import com.trilhalog.trilhalog.core.agendamento.enums.StatusDoAgendamento;
import com.trilhalog.trilhalog.core.agendamento.enums.TipoDoAgendamento;
import com.trilhalog.trilhalog.core.carga.entity.Carga;
import com.trilhalog.trilhalog.core.usuario.entity.Usuario;

public class Agendamento {
	
	private String id;
	
	private StatusDoAgendamento status;
	
	private TipoDoAgendamento tipoDoAgendamento;
	
	private StatusAProvacao aprovacao;
	
	private AgendaSlot agendaSlot; 
	
	private Carga carga; 
	
	private Usuario usuario;

	public Agendamento(StatusDoAgendamento status, TipoDoAgendamento tipoDoAgendamento, StatusAProvacao aprovacao,
			Carga carga, Usuario usuario,AgendaSlot agendaSlot) {
		this.status = status;
		this.tipoDoAgendamento = tipoDoAgendamento;
		this.aprovacao = aprovacao;
		this.carga = carga;
		this.usuario = usuario;
		this.agendaSlot = agendaSlot; 
		
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

	public StatusAProvacao getAprovacao() {
		return aprovacao;
	}

	public void setAprovacao(StatusAProvacao aprovacao) {
		this.aprovacao = aprovacao;
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
				+ ", aprovacao=" + aprovacao + ", agendaSlot=" + agendaSlot + ", carga=" + carga + ", usuario="
				+ usuario + "]";
	}





	@Override
	public int hashCode() {
		return Objects.hash(agendaSlot, aprovacao, carga, id, status, tipoDoAgendamento, usuario);
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
		return Objects.equals(agendaSlot, other.agendaSlot) && aprovacao == other.aprovacao
				&& Objects.equals(carga, other.carga) && Objects.equals(id, other.id) && status == other.status
				&& tipoDoAgendamento == other.tipoDoAgendamento && Objects.equals(usuario, other.usuario);
	}




}
