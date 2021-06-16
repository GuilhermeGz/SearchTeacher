package br.edu.ufape.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufape.model.Professor;

@Repository
public interface ProfessorDAOI extends JpaRepository<Professor, Long>{
	
	//Procura o elemento pelo id.
	Optional<Professor> findById(Long id);

}
