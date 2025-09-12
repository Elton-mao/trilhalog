package com.trilhalog.trilhalog.core.transportadora.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.trilhalog.trilhalog.core.transportadora.enums.StatusDoCadastroDaTransportadora;
import com.trilhalog.trilhalog.core.usuario.entity.Usuario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "transportadoras")
public class Transportadora {
	
	@Id
	@Column(name="transportadora_id")
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;

	@Column(name = "cnpj", nullable = false, unique = true)
	private String cnpj;
	
	@Column(name = "razao_social", nullable = false, unique = true)
	private String razaoSocial;

	@Column(name = "status_cadastro", nullable = false, unique = true)
	@Enumerated(EnumType.STRING)
	private StatusDoCadastroDaTransportadora statusDoCadastro;
	
	@Column(name = "data_cadastro", nullable = false, unique = true)
	private LocalDateTime dataDoCadastro;
	
	@OneToMany(mappedBy = "transportadora")
	@JsonManagedReference
	private List<Usuario> usuarios = new ArrayList<>(); 
	
	public Transportadora(String cnpj, String razaoSocial) {
		super();
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
	}

	public Transportadora() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public StatusDoCadastroDaTransportadora getStatusDoCadastro() {
		return statusDoCadastro;
	}

	public void setStatusDoCadastro(StatusDoCadastroDaTransportadora statusDoCadastro) {
		this.statusDoCadastro = statusDoCadastro;
	}

	public LocalDateTime getDataDoCadastro() {
		return dataDoCadastro;
	}

	public void setDataDoCadastro(LocalDateTime dataDoCadastro) {
		this.dataDoCadastro = dataDoCadastro;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	@Override
	public String toString() {
		return "Transportadora [id=" + id + ", cnpj=" + cnpj + ", razaoSocial=" + razaoSocial + ", statusDoCadastro="
				+ statusDoCadastro + ", dataDoCadastro=" + dataDoCadastro + ", usuarios=" + usuarios + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cnpj, dataDoCadastro, id, razaoSocial, statusDoCadastro, usuarios);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transportadora other = (Transportadora) obj;
		return Objects.equals(cnpj, other.cnpj) && Objects.equals(dataDoCadastro, other.dataDoCadastro)
				&& Objects.equals(id, other.id) && Objects.equals(razaoSocial, other.razaoSocial)
				&& statusDoCadastro == other.statusDoCadastro && Objects.equals(usuarios, other.usuarios);
	}

	

}
