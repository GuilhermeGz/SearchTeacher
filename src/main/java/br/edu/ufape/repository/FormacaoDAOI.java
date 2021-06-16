package br.edu.ufape.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufape.model.Formacao;

@Repository
public interface FormacaoDAOI  extends JpaRepository<Formacao, Long>{
	
	//Procura o elemento pelo id.
	Optional<Formacao> findById(Long id);

}
