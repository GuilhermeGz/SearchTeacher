package br.edu.ufape.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.edu.ufape.model.Usuario;

@Repository
public interface UsuarioDAOI extends JpaRepository<Usuario, Long>{
	
	//Procura o elemento pelo id.
	Optional<Usuario> findById(Long id);
	
	@Query("select u from Usuario u where u.login=:login and u.senha=:senha")
	public Usuario findUsuario(String login, String senha);
		
	public Optional<Usuario> findByLogin(String login);
}
