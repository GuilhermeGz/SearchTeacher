package br.edu.ufape.controller;

import java.security.Principal;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	
	@RequestMapping(value={"/", "/home"})
	public String home(HttpServletRequest request, Principal principal) {
			
				
		List <GrantedAuthority> authorities= (List<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		String perfis = authorities.toString();	
		
		if (principal!=null) {
		
			System.out.println(
				"Authorities do user" +principal.getName() + " =" +
				perfis
				
		);
		}
		
		return "Home/index";
		
	}
}
