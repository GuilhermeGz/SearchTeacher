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

import br.edu.ufape.repository.AreaMenorDAOI;
import br.edu.ufape.model.AreaMenor;

@Controller
// Definindo a "url" quando estamos nos referindo a AreaMenor.
@RequestMapping ("/areamenor")
public class AreaMenorController {
	// Nota geral:
	// Foi definido no properties qual o caminho a ser procurado quando estamos nos referindo as views.
	// "{}" Se faz para adaptar ao id do que foi selecionado.

	// Para a persistencia de dados.
	@Autowired
	AreaMenorDAOI areaMenorDAOI;


	// Encaminhamento e captação no banco da pagina apresentada inicialmente.
	// OBS:RequestMappin com dois "caminhos", podendo ser utilizado /all e / para o acesso.
	@RequestMapping(value= {"/all", "/"})
	public String findAllAreaMenor(Model model) {

		// Retorna uma lista de todos os obejtos de "AreaMenor".
		List<AreaMenor> areasMenores = areaMenorDAOI.findAll();
		// Passando para o modelo a colection/lista.
		model.addAttribute("areasMenores", areasMenores);		
		// Encaminha o fluxo para a view.
		return "AreaMenor/listaareamenor";
	}


	// Atualização de uma "AreaMenor" escolhida e encaminhamento para a pagina de update.
	@RequestMapping(value= "/update/{id}" )
	public String update(@PathVariable("id") Long id, Model model) {

		// Procura o objeto AreaMenor pelo seu id.
		Optional<AreaMenor> areaMenor = areaMenorDAOI.findById(id);
		// Passando para o modelo o objeto captado acima.
		model.addAttribute("areaMenorForm", areaMenor.get());
		// Verifica se o obejto está vazio.			
		if (!areaMenor.isEmpty()) {
			// Encaminha o fluxo para a view.
			return "AreaMenor/updateareamenor";
		}else {
			// Caso ocorra um "erro" na verificação, será mostrada uma mensagem logo acima da tabela apresentada na view.
			model.addAttribute("errors","Area Menor não encontrada!");
			// Encaminha o fluxo para a view.
			return "AreaMenor/listaareamenor";
		}
	}


	// Validação e ação de mudança no bando. Encaminhamento para a pagina de listagem das areas menores.
	@RequestMapping(value= "/update2" , method = RequestMethod.POST)
	public String update2(@Valid @ModelAttribute("areaMenorForm") AreaMenor form,
			BindingResult bindingResult,
			Model model
			) {


		//Verificação de erro
		if(bindingResult.hasErrors( )) {
			return "AreaMenor/updateareamenor";
		}

		// Salvando as alterações realizadas através do form.
		areaMenorDAOI.save(form);
		// Mensagem que irá ser apresentada logo acima da tabela apresentada.
		model.addAttribute("msgs", "Area Menor alterada com sucesso!");
		// Encaminha o fluxo para a url.
		return "forward:/areamenor/all";
	}


	// Deletar o elemento selecionado.
	@RequestMapping(value= "/delete/{id}" , method = RequestMethod.GET)
	public String delete(@PathVariable("id") Long id, Model model) {

		// Procura o objeto AreaMenor pelo seu id.
		Optional<AreaMenor> areaMenor = areaMenorDAOI.findById(id);
		// Verifica se o obejto está vazio.
		if (!areaMenor.isEmpty()) {
			// Deleta o objeto captado anteriormente.
			areaMenorDAOI.delete(areaMenor.get());
			// Mensagem que irá ser apresentada logo acima da tabela apresentada.
			model.addAttribute("msgs", "Area Menor deletada com sucesso!");
		} else {
			// Caso ocorra um "erro" na verificação, será mostrada uma mensagem logo acima da tabela apresentada na view.
			model.addAttribute("errors","Area Menor não encontrada!");
		}
		// Encaminha o fluxo para a url.
		return "forward:/areamenor/all";	
	}


	//Cria uma nova AreaMenor.
	@RequestMapping(value= "/new")
	public String novo(Long id, Model model) {

		//Cria e passa para o model uma "AreaMenor" vazia.
		model.addAttribute("areaMenorForm", new AreaMenor());
		//Encaminha o fluxo para a view, que irá possibilitar o preenchimento dos dados.
		return "AreaMenor/newareamenor";
	}


	// Conclui as mudanças realizadas na view de criação.
	@RequestMapping(value= "/new2")
	public String novo2 (@Valid @ModelAttribute("areaMenorForm") AreaMenor form,
			BindingResult bindingResult,
			Model model
			) {

		//Verificação de erro
		if(bindingResult.hasErrors( )) {
			return "AreaMenor/newareamenor";
		}

		// Salva as alterações realizadas através do form.
		areaMenorDAOI.save(form);
		// Mensagem que irá ser apresentada logo acima da tabela apresentada.
		model.addAttribute("msgs", "Area Menor cadastrada com sucesso");
		// Encaminha o fluxo para a url.
		return "forward:/areamenor/all";
	} 

}
