package br.edu.ufape.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "perfil")
public class Perfil {

	// Atributos da classe.
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)	
	private Long id;
	
	@NotBlank
	private String descricao;

	// Getters e Setters.
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
