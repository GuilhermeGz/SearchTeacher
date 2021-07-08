package br.edu.ufape.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.ufape.model.Instituicao;
import br.edu.ufape.model.Professor;
import br.edu.ufape.repository.ProfessorDAOI;


@Controller
// Definindo a "url" quando estamos nos referindo a Professor.
@RequestMapping ("/professor")
public class ProfessorController {
	// Nota geral:
	// Foi definido no properties qual o caminho a ser procurado quando estamos nos referindo as views.
	// "{}" Se faz para adaptar ao id do que foi selecionado.

	// Para a persistencia de dados.
	@Autowired
	ProfessorDAOI professorDAOI;


	// Encaminhamento e captação no banco da pagina apresentada inicialmente.
	// OBS:RequestMappin com dois "caminhos", podendo ser utilizado /all e / para o acesso.
	@RequestMapping(value= {"/all", "/"})
	public String findAllProfessor(Model model) {

		// Retorna uma lista de todos os obejtos de "Professor".
		List<Professor> professores = professorDAOI.findAll();
		// Passando para o modelo a colection/lista.
		model.addAttribute("professores", professores);
		// Encaminha o fluxo para a view.
		return "Professor/listaprofessor";	
	}


	// Atualização de um "professor" escolhido e encaminhamento para a pagina de update.
	@RequestMapping(value= "/update/{id}" )
	public String update(@PathVariable("id") Long id, Model model) {

		// Procura o objeto Professor pelo seu id.
		Optional<Professor> professor = professorDAOI.findById(id);
		// Passando para o modelo o objeto captado acima.
		model.addAttribute("professorForm", professor.get());
		// Verifica se o obejto está vazio.			
		if (!professor.isEmpty()) {
			// Encaminha o fluxo para a view.
			return "Professor/updateprofessor";
		}else {
			// Caso ocorra um "erro" na verificação, será mostrada uma mensagem logo acima da tabela apresentada na view.
			model.addAttribute("errors","Professor não encontrado!");
			// Encaminha o fluxo para a view.
			return "Professor/listaprofessor";
		}
	}


	// Validação e ação de mudança no bando. Encaminhamento para a pagina de listagem dos professores.
	@RequestMapping(value= "/update2" , method = RequestMethod.POST)
	public String update2(@Valid @ModelAttribute("professorForm") Professor form,
			BindingResult bindingResult,
			Model model
			) {

		//Verificação de erro
		if(bindingResult.hasErrors( )) {
			return "Professor/updateprofessor";
		}

		// Salvando as alterações realizadas através do form.
		professorDAOI.save(form);
		// Mensagem que irá ser apresentada logo acima da tabela apresentada.
		model.addAttribute("msgs", "Professor alterado com sucesso!");
		// Encaminha o fluxo para a url.
		return "redirect:/professor/all";
	}


	// Deletar o elemento selecionado.
	@RequestMapping(value= "/delete/{id}" , method = RequestMethod.GET)
	public String delete(@PathVariable("id") Long id, Model model) {

		// Procura o objeto Professor pelo seu id.
		Optional<Professor> professor = professorDAOI.findById(id);
		// Verifica se o obejto está vazio.		
		if (!professor.isEmpty()) {
			// Deleta o objeto captado anteriormente.
			professorDAOI.delete(professor.get());
			// Mensagem que irá ser apresentada logo acima da tabela apresentada.
			model.addAttribute("msgs", "Professor deletado com sucesso!");
		} else {
			// Caso ocorra um "erro" na verificação, será mostrada uma mensagem logo acima da tabela apresentada na view.
			model.addAttribute("errors","Professor não encontrado!");
		}
		// Encaminha o fluxo para a url.		
		return "redirect:/professor/all";	
	}


	// Cria um novo Professor.		
	@RequestMapping(value= "/new")
	public String novo(Long id, Model model) {

		// Cria e passa para o model uma "Professor" vazia.
		model.addAttribute("professorForm", new Professor());
		// Encaminha o fluxo para a view, que irá possibilitar o preenchimento dos dados.
		return "Professor/newprofessor";

	}


	// Conclui as mudanças realizadas na view de criação.
	@RequestMapping(value= "/new2")
	public String novo2 (@Valid @ModelAttribute("professorForm") Professor form,
			BindingResult bindingResult,
			Model model
			) {
		//Verificação de erro
		if(bindingResult.hasErrors( )) {
			return "Professor/newprofessor";
		}
		// Salva as alterações realizadas através do form.
		professorDAOI.save(form);
		// Mensagem que irá ser apresentada logo acima da tabela apresentada.
		model.addAttribute("msgs", "Professor cadastrado com sucesso");
		// Encaminha o fluxo para a url.
		return "redirect:/professor/all";
	}

}