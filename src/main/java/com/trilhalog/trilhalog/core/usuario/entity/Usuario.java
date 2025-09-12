package com.trilhalog.trilhalog.core.usuario.entity;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.trilhalog.trilhalog.core.transportadora.entity.Transportadora;
import com.trilhalog.trilhalog.core.usuario.enums.StatusDoCadastroDoUsuario;
import com.trilhalog.trilhalog.core.usuario.enums.TipoPerfil;

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
@Table(name = "usuarios")
public class Usuario {

	@Id
	@Column(name = "usuario_id")
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;

	@Column(name = "nome_completo")
	private String nome;

	@Column(name = "telefone")
	private String telefone;

	@Column(name = "email")
	private String email;

	@Column(name = "senha")
	private String senha;

	@Column(name = "tipo_perfil")
	@Enumerated(EnumType.STRING)
	private TipoPerfil tipoPerfil;
	
	@Column(name = "status_cadastro")
	@Enumerated(EnumType.STRING)
	private StatusDoCadastroDoUsuario status;

	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "transportadora_id")
	private Transportadora transportadora;

	public Usuario(String nome, String telefone, String email, String senha, TipoPerfil tipoPerfil) {
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.senha = senha;
		this.tipoPerfil = tipoPerfil;

	}

	public Usuario() {
		this.status = null;

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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public TipoPerfil getTipoPerfil() {
		return tipoPerfil;
	}

	public void setTipoPerfil(TipoPerfil tipoPerfil) {
		this.tipoPerfil = tipoPerfil;
	}

	public StatusDoCadastroDoUsuario getStatus() {
		return status;
	}

	public void setStatus(StatusDoCadastroDoUsuario status) {
		this.status = status;
	}

	public Transportadora getTransportadora() {
		return transportadora;
	}

	public void setTransportadora(Transportadora transportadora) {
		this.transportadora = transportadora;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, id, nome, senha, status, telefone, tipoPerfil, transportadora);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(email, other.email) && Objects.equals(id, other.id) && Objects.equals(nome, other.nome)
				&& Objects.equals(senha, other.senha) && status == other.status
				&& Objects.equals(telefone, other.telefone) && tipoPerfil == other.tipoPerfil
				&& Objects.equals(transportadora, other.transportadora);
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", telefone=" + telefone + ", email=" + email + ", senha="
				+ senha + ", tipoPerfil=" + tipoPerfil + ", status=" + status + ", transportadora=" + transportadora
				+ "]";
	}


	}


