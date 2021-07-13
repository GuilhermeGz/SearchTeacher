package br.edu.ufape.model;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


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

	@Past (message="Não é aceito datas futuras")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull
	private Date ano;

	@NotEmpty (message = "Informe sua descrição")
	private String descricao;

	
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
	

}