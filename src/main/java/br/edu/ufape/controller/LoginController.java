package br.edu.ufape.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ufape.model.Professor;
import br.edu.ufape.model.Usuario;
import br.edu.ufape.repository.UsuarioDAOI;

@Controller
public class LoginController {

	@Autowired
	UsuarioDAOI usuarioDAOI;

	
	@RequestMapping(method= RequestMethod.GET,path="/login")
	public String entrar() {

		return "login";
	}
	/*@RequestMapping("/login")
	public ModelAndView login() {

		Usuario usuarioForm = new Usuario();
		ModelAndView mv= new ModelAndView();
		mv.addObject("usuarioForm", usuarioForm);
		mv.setViewName("/Login/login");

		return mv;
	}*/


	@RequestMapping("/efetuarlogin")
	public ModelAndView efetuarlogin(@Valid @ModelAttribute("usuarioForm") Usuario usuarioForm, HttpServletRequest request,
			BindingResult bindingResult) {

		ModelAndView mv= new ModelAndView();
	
		//Verificação de Erro
		if(bindingResult.hasErrors()) {
	        System.out.println(bindingResult.getAllErrors());
	    	//
	    	 mv.setViewName("login");
		}

		Usuario usuario = usuarioDAOI.findUsuario(usuarioForm.getLogin(),usuarioForm.getSenha());
		
		//login existente, senha correta
		if (usuario!=null && usuario.getId()>0) {
		
			request.getSession().setAttribute("usuarioLogado", usuarioForm);
			mv.setViewName("Professor/listaprofessor");
			System.out.println("usuário logado com sucesso="+ usuarioForm.getLogin());
		}
		
		else{
			mv.addObject("errors", "Usuário ou Senha inválido");
			mv.setViewName("/Login/login");
			
		}
		
		return mv;
	}


}
