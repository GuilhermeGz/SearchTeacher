package br.edu.ufape.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufape.model.Instituicao;

@Repository
public interface InstituicaoDAOI extends JpaRepository<Instituicao, Long>{
	
	//Procura o elemento pelo id.
	Optional<Instituicao> findById(Long id);
	
}
