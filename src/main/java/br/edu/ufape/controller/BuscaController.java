package br.edu.ufape.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ufape.model.AreaAtuacao;
import br.edu.ufape.model.AreaMenor;
import br.edu.ufape.model.Professor;
import br.edu.ufape.model.Usuario;
import br.edu.ufape.repository.AreaAtuacaoDAOI;
import br.edu.ufape.repository.ProfessorDAOI;
import br.edu.ufape.repository.UsuarioDAOI;

@Controller
public class BuscaController {

	@Autowired
	ProfessorDAOI professorDAOI;


	
	@RequestMapping(method= RequestMethod.POST,path="/buscar")
	public String buscar( @RequestParam String busca, Model model) {
		List<Professor> professores = professorDAOI.findByNome(busca);
		/*for (Professor professor : professores) {
			System.out.println(professor.getIdLattes());
		}*/
		model.addAttribute("professores", professores);
		return "TelasBuscas/busca";
	}
	
	@RequestMapping(method= RequestMethod.GET,path="/perfil/{id}")
	public String update(@PathVariable("id") Long id, Model model) {

		// Procura o objeto Professor pelo seu id.
		Optional<Professor> professor = professorDAOI.findById(id);
		// Passando para o modelo o objeto captado acima.
		model.addAttribute("professor", professor.get());
		// Verifica se o obejto está vazio.			
		if (!professor.isEmpty()) {
			// Encaminha o fluxo para a view.
			return "TelasBuscas/perfil";
		}else {
			// Caso ocorra um "erro" na verificação, será mostrada uma mensagem logo acima da tabela apresentada na view.
			model.addAttribute("errors","Professor não encontrado!");
			// Encaminha o fluxo para a view.
			return "TelasBuscas/busca";
		}
	}



}
