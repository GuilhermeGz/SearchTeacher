package br.edu.ufape.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.edu.ufape.model.AreaAtuacao;
import br.edu.ufape.model.Professor;
import br.edu.ufape.model.Usuario;

@Repository
public interface ProfessorDAOI extends JpaRepository<Professor, Long>{
	
	//Procura o elemento pelo id.
	Optional<Professor> findById(Long id);
	
	@Query("select u from Professor u where (u.nome like %:texto%) or (u.descricao like %:texto%) or (u.citacaoBibliografica like %:texto%)")
	public List<Professor> findByNome(String texto);

	
}
