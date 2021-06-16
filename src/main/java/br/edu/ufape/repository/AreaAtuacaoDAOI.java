package br.edu.ufape.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufape.model.AreaAtuacao;

@Repository
public interface AreaAtuacaoDAOI  extends JpaRepository<AreaAtuacao, Long>{
	
	//Procura o elemento pelo id.
	Optional<AreaAtuacao> findById(Long id);

}
