package br.edu.ufape.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.edu.ufape.model.Usuario;
import br.edu.ufape.repository.UsuarioDAOI;
import br.edu.ufape.config.MyUserDetails;

@Service
public class MyUserDetailsService implements UserDetailsService {

	
	@Autowired
	UsuarioDAOI usuarioDAOI;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		Optional<Usuario> oUsuario= usuarioDAOI.findByLogin(username);
		
		oUsuario.orElseThrow(() -> new UsernameNotFoundException("Not found "+ username));
		
		return new MyUserDetails(oUsuario.get());
		
		
	}

}
