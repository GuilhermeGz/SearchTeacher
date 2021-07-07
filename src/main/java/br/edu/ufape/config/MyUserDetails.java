package br.edu.ufape.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.edu.ufape.model.Perfil;
import br.edu.ufape.model.Usuario;

public class MyUserDetails implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userName;
	private String password;
	private boolean active;
	private List<GrantedAuthority> authorities; //equivalente ao PERFIL/ROLE


	public MyUserDetails(String userName) {
		this.userName=userName;
	}

	public MyUserDetails() {

	}



	public MyUserDetails(Usuario usuario) {
		// TODO Auto-generated constructor stub
		this.userName= usuario.getLogin();
		this.password= usuario.getSenha();
		this.active=(usuario.getAtivo())>0 ? true : false;

		List<Perfil> perfis = usuario.getPerfis();
		//System.out.println("Um dos perfis de "+ usuario.getLogin() + " é "+ perfis.get(0).getDescricao());
		List<GrantedAuthority> lista = new ArrayList<>();

		for (int i=0; i< perfis.size(); i++){
			lista.add(new SimpleGrantedAuthority(perfis.get(i).getDescricao().toUpperCase()));	
		}

		this.authorities = lista;



	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return this.authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return this.active;
	}


}
