package br.edu.ufape.model;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.edu.ufape.validation.CPFValid;
import br.edu.ufape.validation.MeuEmail;

import java.util.*;



@Entity 
// Referindo-se a tebela no banco.
@Table(name="professor")
public class Professor {

	// Atributos da classe.
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Size(min=4,max=20, message="O nome deve conter de 4 a 20 letras")
	private String nome;

	@MeuEmail
	private String email;

	@NotEmpty(message="Informe seu lattes")
	@Column(name="id_lattes")
	private String idLattes;

	@NotEmpty (message = "Informe sua descrição")
	private String descricao;

	@Column(name="citacao_bibliografica")
	private String citacaoBibliografica;
	
	 @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	 @JoinTable(
	            name = "professor_formacao",
	            joinColumns = @JoinColumn(name = "idprofessor"),
	            inverseJoinColumns = @JoinColumn(name = "idformacao"))
	private List<Formacao> formacoes = new ArrayList<Formacao>();
	
/*	@CPFValid
	private String cpf;*/

	@OneToOne
	// Chave estrangeira
	@JoinColumn(name = "id_instituicao")
	private Instituicao instituicao;

	@OneToMany(cascade = CascadeType.REMOVE,mappedBy="professor")
	List<AreaAtuacao> areaAtuacao;



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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdLattes() {
		return idLattes;
	}

	public void setIdLattes(String idLattes) {
		this.idLattes = idLattes;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCitacaoBibliografica() {
		return citacaoBibliografica;
	}

	public void setCitacaoBibliografica(String citacaoBibliografica) {
		this.citacaoBibliografica = citacaoBibliografica;
	}

	public Instituicao getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}

	public List<AreaAtuacao> getAreaAtuacao() {
		return areaAtuacao;
	}

	public void setAreaAtuacao(List<AreaAtuacao> areaAtuacao) {
		this.areaAtuacao = areaAtuacao;
	}

	public List<Formacao> getFormacoes() {
		return formacoes;
	}

	public void setFormacoes(List<Formacao> formacoes) {
		this.formacoes = formacoes;
	}


}