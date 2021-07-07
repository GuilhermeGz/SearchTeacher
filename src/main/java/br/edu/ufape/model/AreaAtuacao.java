package br.edu.ufape.model;


import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.*;

@Entity 
@Table(name="areaatuacao")
public class AreaAtuacao {

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
	@JoinColumn(name = "id_prof")
	private Professor professor;
	
	
	@OneToMany(cascade = CascadeType.REMOVE,mappedBy="areaatuacao")
	List<AreaMenor> areaMenor;
	
	@OneToMany(cascade = CascadeType.REMOVE,mappedBy="areaatuacao")
	List<AtividadeDesenvolvida> AtividadeDesenvolvida;
	

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

	public List<AreaMenor> getAreaMenor() {
		return areaMenor;
	}

	public void setAreaMenor(List<AreaMenor> areaMenor) {
		this.areaMenor = areaMenor;
	}

	public List<AtividadeDesenvolvida> getAtividadeDesenvolvida() {
		return AtividadeDesenvolvida;
	}

	public void setAtividadeDesenvolvida(List<AtividadeDesenvolvida> atividadeDesenvolvida) {
		AtividadeDesenvolvida = atividadeDesenvolvida;
	}

	@Override
	public String toString() {
		return "AreaAtuacao [id=" + id + ", nome=" + nome + ", ano=" + ano + ", descricao=" + descricao + ", professor="
				+ professor + "]";
	}




}