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

/**
 * Representa uma doca de carga/descarga no sistema.
 * 
 * <p>Esta classe é uma entidade JPA, mapeada para a tabela "docas".
 * Cada doca tem um nome único e pode ter vários slots de agenda associados a ela.</p>
 * 
 * <p>Relacionamentos:
 * <ul>
 *   <li>{@link AgendaSlot}: Uma doca para muitos slots de agenda ({@code @OneToMany}).</li>
 * </ul>
 * </p>
 */
@Entity
@Table(name = "docas")
public class Doca {

	/**
	 * O identificador único da doca.
	 * É gerado automaticamente como um UUID.
	 */
	@Id
	@Column(name = "doca_id")
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;

	/**
	 * O nome da doca, que deve ser único.
	 */
	@Column(name = "nome", unique = true)
	private String nome;

	/**
	 * A lista de slots de agenda associados a esta doca.
	 * O relacionamento é mapeado pelo campo "doca" na entidade {@link AgendaSlot}.
	 */
	@OneToMany(mappedBy = "doca")
	List<AgendaSlot> agendaSlots;

	/**
     * Construtor padrão.
     */
	public Doca() {

	}

	/**
     * Construtor que inicializa a doca com um nome.
     * 
     * @param nome O nome da doca.
     */
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
