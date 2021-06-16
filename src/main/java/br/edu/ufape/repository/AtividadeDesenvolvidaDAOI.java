package br.edu.ufape.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufape.model.AtividadeDesenvolvida;

@Repository
public interface AtividadeDesenvolvidaDAOI  extends JpaRepository<AtividadeDesenvolvida, Long>{
	
	//Procura o elemento pelo id.
	Optional<AtividadeDesenvolvida> findById(Long id);

}
