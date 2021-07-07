package br.edu.ufape.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import br.edu.ufape.model.Perfil;

@Entity 
//Referindo-se a tebela no banco.
@Table(name="usuario")
public class Usuario {

	// Atributos da classe.
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Login não pode ser nulo")
	private String login;
	
	@NotBlank(message="errou")
	private String senha;
	
	private Integer Ativo;
	
	 @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	 @JoinTable(
	            name = "usuario_perfil",
	            joinColumns = @JoinColumn(name = "idusuario"),
	            inverseJoinColumns = @JoinColumn(name = "idperfil"))
	private List<Perfil> perfis = new ArrayList<Perfil>();
	 
	
	// Getters e Setters.
	 
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Perfil> getPerfis() {
		return perfis;
	}

	public void setPerfis(List<Perfil> perfis) {
		this.perfis = perfis;
	}

	public Integer getAtivo() {
		return Ativo;
	}

	public void setAtivo(Integer ativo) {
		Ativo = ativo;
	}



}
