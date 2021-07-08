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

import br.edu.ufape.repository.AreaAtuacaoDAOI;
import br.edu.ufape.model.AreaAtuacao;

@Controller
// Definindo a "url" quando estamos nos referindo a AreaAtuacao.
@RequestMapping ("/areaatuacao")
public class AreaAtuacaoController {
	// Nota geral:
	// Foi definido no properties qual o caminho a ser procurado quando estamos nos referindo as views.
	// "{}" Se faz para adaptar ao id do que foi selecionado.

	// Para a persistencia de dados.
	@Autowired
	AreaAtuacaoDAOI areaAtuacaoDAOI;


	// Encaminhamento e captação no banco da pagina apresentada inicialmente.
	// OBS:RequestMappin com dois "caminhos", podendo ser utilizado /all e / para o acesso.
	@RequestMapping(value= {"/all", "/"})
	public String findAllAreaAtuacao(Model model) {

		// Retorna uma lista de todos os obejtos de "AreaAtuacao".
		List<AreaAtuacao> areasAtuacao = areaAtuacaoDAOI.findAll();
		System.out.println(areasAtuacao.get(0).getProfessor().getNome()); 
		// Passando para o modelo a colection/lista.
		model.addAttribute("areasAtuacao", areasAtuacao);		
		// Encaminha o fluxo para a view.
		return "AreaAtuacao/listaareaatuacao";
	}


	// Atualização de uma "AreaAtuacao" escolhida e encaminhamento para a pagina de update.
	@RequestMapping(value= "/update/{id}" )
	public String update(@PathVariable("id") Long id, Model model) {

		// Procura o objeto AreaAtuacao pelo seu id.
		Optional<AreaAtuacao> areaAtuacao = areaAtuacaoDAOI.findById(id);
		// Passando para o modelo o objeto captado acima.
		model.addAttribute("areaAtuacaoForm", areaAtuacao.get());
		// Verifica se o obejto está vazio.			
		if (!areaAtuacao.isEmpty()) {
			// Encaminha o fluxo para a view.
			return "AreaAtuacao/updateareaatuacao";
		}else {
			// Caso ocorra um "erro" na verificação, será mostrada uma mensagem logo acima da tabela apresentada na view.
			model.addAttribute("errors","Area de Atuacao não encontrada!");
			// Encaminha o fluxo para a view.
			return "AreaAtuacao/listaareaatuacao";
		}
	}


	// Validação e ação de mudança no bando. Encaminhamento para a pagina de listagem das areas de atuações.
	@RequestMapping(value= "/update2" , method = RequestMethod.POST)
	public String update2(@Valid @ModelAttribute("areaAtuacaoForm") AreaAtuacao form,
			BindingResult bindingResult,
			Model model
			) {

		//Verificação de erro
		if(bindingResult.hasErrors( )) {
			return "AreaAtuacao/updateareaatuacao";
		}

		// Salvando as alterações realizadas através do form.
		areaAtuacaoDAOI.save(form);
		// Mensagem que irá ser apresentada logo acima da tabela apresentada.
		model.addAttribute("msgs", "Area de Atuacao alterada com sucesso!");
		// Encaminha o fluxo para a url.
		return "redirect:/areaatuacao/all";
	}



	// Deletar o elemento selecionado.
	@RequestMapping(value= "/delete/{id}" , method = RequestMethod.GET)
	public String delete(@PathVariable("id") Long id, Model model) {

		// Procura o objeto AreaAtuacao pelo seu id.
		Optional<AreaAtuacao> areaAtuacao = areaAtuacaoDAOI.findById(id);
		// Verifica se o obejto está vazio.
		if (!areaAtuacao.isEmpty()) {
			// Deleta o objeto captado anteriormente.
			areaAtuacaoDAOI.delete(areaAtuacao.get());
			// Mensagem que irá ser apresentada logo acima da tabela apresentada.
			model.addAttribute("msgs", "Area de Atuacao deletada com sucesso!");
		} else {
			// Caso ocorra um "erro" na verificação, será mostrada uma mensagem logo acima da tabela apresentada na view.
			model.addAttribute("errors","Area de Atuacao não encontrada!");
		}
		// Encaminha o fluxo para a url.
		return "redirect:/areaatuacao/all";	
	}


	//Cria uma nova AreaAtuacao.
	@RequestMapping(value= "/new")
	public String novo(Long id, Model model) {

		//Cria e passa para o model uma "AreaAtuacao" vazia.
		model.addAttribute("areaAtuacaoForm", new AreaAtuacao());
		//Encaminha o fluxo para a view, que irá possibilitar o preenchimento dos dados.
		return "AreaAtuacao/newareaatuacao";
	}


	// Conclui as mudanças realizadas na view de criação.
	@RequestMapping(value= "/new2")
	public String novo2 (@Valid @ModelAttribute("areaAtuacaoForm") AreaAtuacao form,
			BindingResult bindingResult,
			Model model
			) {

		//Verificação de erro
		if(bindingResult.hasErrors( )) {
			return "AreaAtuacao/newareaatuacao";
		}

		// Salva as alterações realizadas através do form.
		areaAtuacaoDAOI.save(form);
		// Mensagem que irá ser apresentada logo acima da tabela apresentada.
		model.addAttribute("msgs", "Area de Atuacao cadastrada com sucesso");
		// Encaminha o fluxo para a url.
		return "redirect:/areaatuacao/all";
	} 

}
