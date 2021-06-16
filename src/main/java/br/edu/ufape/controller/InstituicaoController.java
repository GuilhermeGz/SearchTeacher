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

import br.edu.ufape.repository.InstituicaoDAOI;
import br.edu.ufape.model.Instituicao;

@Controller
// Definindo a "url" quando estamos nos referindo a Instituição.
@RequestMapping ("/instituicao")
public class InstituicaoController {
	// Nota geral:
	// Foi definido no properties qual o caminho a ser procurado quando estamos nos referindo as views.
	// "{}" Se faz para adaptar ao id do que foi selecionado.

	// Para a persistencia de dados.
	@Autowired
	InstituicaoDAOI instituicaoDAOI;


	// Encaminhamento e captação no banco da pagina apresentada inicialmente.
	// OBS:RequestMappin com dois "caminhos", podendo ser utilizado /all e / para o acesso.
	@RequestMapping(value= {"/all", "/"})
	public String findAllInstituicao(Model model) {

		// Retorna uma lista de todos os obejtos de "Instituição".
		List<Instituicao> instituicoes = instituicaoDAOI.findAll();
		// Passando para o modelo a colection/lista
		model.addAttribute("instituicoes", instituicoes);		
		// Encaminha o fluxo para a view.
		return "Instituicao/listainstituicao";
	}


	// Atualização de uma "instituicao" escolhida e encaminhamento para a pagina de update.
	@RequestMapping(value= "/update/{id}" )
	public String update(@PathVariable("id") Long id, Model model) {

		// Procura o objeto Instituicao pelo seu id.
		Optional<Instituicao> instituicao = instituicaoDAOI.findById(id);
		// Passando para o modelo o objeto captado acima.
		model.addAttribute("instituicaoForm", instituicao.get());
		// Verifica se o obejto está vazio.			
		if (!instituicao.isEmpty()) {
			// Encaminha o fluxo para a view.
			return "Instituicao/updateinstituicao";
		}else {
			// Caso ocorra um "erro" na verificação, será mostrada uma mensagem logo acima da tabela apresentada na view.
			model.addAttribute("errors","Instituicao não encontrada!");
			// Encaminha o fluxo para a view.
			return "Instituicao/listainstituicao";
		}
	}


	// Validação e ação de mudança no bando. Encaminhamento para a pagina de listagem das instituições.
	@RequestMapping(value= "/update2" , method = RequestMethod.POST)
	public String update2(@Valid @ModelAttribute("instituicaoForm") Instituicao form,
			BindingResult bindingResult,
			Model model
			) {

		//Verificação de erro
		if(bindingResult.hasErrors()) {
			return "Instituicao/updateinstituicao";
		}

		// Salvando as alterações realizadas através do form.
		instituicaoDAOI.save(form);
		// Mensagem que irá ser apresentada logo acima da tabela apresentada.
		model.addAttribute("msgs", "Instituicao alterada com sucesso!");
		// Encaminha o fluxo para a url.
		return "forward:/instituicao/all";
	}


	// Deletar o elemento selecionado.
	@RequestMapping(value= "/delete/{id}" , method = RequestMethod.GET)
	public String delete(@PathVariable("id") Long id, Model model) {

		// Procura o objeto Instituicao pelo seu id.
		Optional<Instituicao> instituicao = instituicaoDAOI.findById(id);
		// Verifica se o obejto está vazio.
		if (!instituicao.isEmpty()) {
			// Deleta o objeto captado anteriormente.
			instituicaoDAOI.delete(instituicao.get());
			// Mensagem que irá ser apresentada logo acima da tabela apresentada.
			model.addAttribute("msgs", "Instituicao deletada com sucesso!");
		} else {
			// Caso ocorra um "erro" na verificação, será mostrada uma mensagem logo acima da tabela apresentada na view.
			model.addAttribute("errors","Instituicao não encontrada!");
		}
		// Encaminha o fluxo para a url.
		return "forward:/instituicao/all";	
	}


	//Cria uma nova Instituição.
	@RequestMapping(value= "/new")
	public String novo(Long id, Model model) {

		//Cria e passa para o model uma "Instituição" vazia.
		model.addAttribute("instituicaoForm", new Instituicao());
		//Encaminha o fluxo para a view, que irá possibilitar o preenchimento dos dados.
		return "Instituicao/newinstituicao";
	}


	// Conclui as mudanças realizadas na view de criação.
	@RequestMapping(value= "/new2")
	public String novo2 (@Valid @ModelAttribute("instituicaoForm") Instituicao form,
			BindingResult bindingResult,
			Model model
			) {

		//Verificação de erro
		if(bindingResult.hasErrors()) {
			return "Instituicao/newinstituicao";
		}

		// Salva as alterações realizadas através do form.
		instituicaoDAOI.save(form);
		// Mensagem que irá ser apresentada logo acima da tabela apresentada.
		model.addAttribute("msgs", "Instituicao cadastrada com sucesso");
		// Encaminha o fluxo para a url.
		return "forward:/instituicao/all";
	} 

}
