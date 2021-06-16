package br.edu.ufape.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity 
// Referindo-se a tebela no banco.
@Table(name="areamenor")
public class AreaMenor {
	
	// Atributos da classe.
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min=5,max=20, message="O nome deve conter de 5 a 20 letras")
	private String nome;
	
	@NotEmpty (message = "Informe sua descrição")
	private String descricao;
	
	
	@OneToOne
	// Chave estrangeira
	@JoinColumn(name = "id_area")
	private AreaAtuacao areaatuacao;
	
	
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
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public AreaAtuacao getAreaatuacao() {
		return areaatuacao;
	}

	public void setAreaatuacao(AreaAtuacao areaatuacao) {
		this.areaatuacao = areaatuacao;
	}
	
	

}
