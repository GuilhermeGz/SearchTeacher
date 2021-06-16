package br.edu.ufape.model;


import java.util.List;
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
	@Size(min=3,max=20, message="O nome deve conter de 3 a 20 letras")
	private String nome;
	
	@NotNull
	@NotEmpty (message = "Informe seu endereco")
	private String endereco;
	
	@OneToMany(mappedBy="instituicao")
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
