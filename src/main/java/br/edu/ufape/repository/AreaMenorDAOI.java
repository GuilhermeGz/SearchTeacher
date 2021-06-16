package br.edu.ufape.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufape.model.AreaMenor;

@Repository
public interface AreaMenorDAOI  extends JpaRepository<AreaMenor, Long>{
	
	//Procura o elemento pelo id.
	Optional<AreaMenor> findById(Long id);

}
