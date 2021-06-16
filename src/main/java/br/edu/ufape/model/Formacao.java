package br.edu.ufape.model;


import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity 
// Referindo-se a tebela no banco.
@Table(name="formacao")
public class Formacao {

	// Atributos da classe.
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Size(min=5,max=20, message="O nome deve conter de 5 a 20 letras")
	private String nome;

	@NotNull
	private Date ano;

	@NotEmpty (message = "Informe sua descrição")
	private String descricao;

	@OneToOne
	// Chave estrangeira
	@JoinColumn(name = "id_professor")
	private Professor professor;
	
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
	
	public Date getAno() {
		return ano;
	}
	
	public void setAno(Date ano) {
		this.ano = ano;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Professor getProfessor() {
		return professor;
	}
	
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

}