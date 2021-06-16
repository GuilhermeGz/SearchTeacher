package br.edu.ufape.model;



import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity 
// Referindo-se a tebela no banco.
@Table(name="ativdesenvolvida")
public class AtividadeDesenvolvida {
	
	// Atributos da classe.
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty (message = "Informe sua descrição")
	private String descricao;
	
	@NotNull
	@Size(min=5,max=20, message="O campo deve conter de 5 a 20 letras")
	@Column(name="tipo_atividade")
	private String tipoAtividade;
	
	@NotNull
	@Column(name="data_inicio")
	private Date dataInicio;
	
	@NotNull
	@Column(name="data_fim")
	private Date dataFim;
	
	@OneToOne
	// Chave estrangeira
	@JoinColumn(name = "id_area_atuacao")
	private AreaAtuacao areaatuacao;

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

	public String getTipoAtividade() {
		return tipoAtividade;
	}

	public void setTipoAtividade(String tipoAtividade) {
		this.tipoAtividade = tipoAtividade;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public AreaAtuacao getAreaatuacao() {
		return areaatuacao;
	}

	public void setAreaatuacao(AreaAtuacao areaatuacao) {
		this.areaatuacao = areaatuacao;
	}



}
