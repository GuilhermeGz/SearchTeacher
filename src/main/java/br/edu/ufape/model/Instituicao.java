package br.edu.ufape.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import com.sun.istack.NotNull;

 

@Entity 
// Referindo-se a tebela no banco.
@Table(name="instituicao")
public class Instituicao {

	// Atributos da classe.
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min=3,max=30, message="O nome deve conter de 3 a 30 letras")
	private String nome;
	
	@NotNull
	@Size(min=3,max=20, message="A sigla deve conter de 2 a 6 letras")
	private String sigla;
	
	@NotNull
	@NotEmpty(message = "Informe seu endereco")
	private String endereco;
	
	@OneToMany(cascade = CascadeType.REMOVE,mappedBy="instituicao")
	List<Professor> professores;	
	
	// Getters e Setters.
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public List<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}
	
	
}
