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
import br.edu.ufape.repository.AtividadeDesenvolvidaDAOI;
import br.edu.ufape.model.AreaAtuacao;
import br.edu.ufape.model.AtividadeDesenvolvida;

@Controller
// Definindo a "url" quando estamos nos referindo a  AtividadeDesenvolvida.
@RequestMapping ("/atividadedesenvolvida")
public class AtividadeDesenvolvidaController {
	// Nota geral:
	// Foi definido no properties qual o caminho a ser procurado quando estamos nos referindo as views.
	// "{}" Se faz para adaptar ao id do que foi selecionado.

	// Para a persistencia de dados.
	@Autowired
	AtividadeDesenvolvidaDAOI atividadeDesenvolvidaDAOI;
	@Autowired
	AreaAtuacaoDAOI areaAtuacaoDAOI;


	// Encaminhamento e captação no banco da pagina apresentada inicialmente.
	// OBS:RequestMappin com dois "caminhos", podendo ser utilizado /all e / para o acesso.
	@RequestMapping(value= {"/all", "/", ""})
	public String findAllAtividadeDesenvolvida(Model model) {

		// Retorna uma lista de todos os obejtos de " AtividadeDesenvolvida".
		List<AtividadeDesenvolvida> atividadesDesenvolvidas = atividadeDesenvolvidaDAOI.findAll();
		// Passando para o modelo a colection/lista.
		model.addAttribute("atividadesDesenvolvidas", atividadesDesenvolvidas);		
		// Encaminha o fluxo para a view.
		return "AtividadeDesenvolvida/listaatividadedesenvolvida";
	}


	// Atualização de uma " AtividadeDesenvolvida" escolhida e encaminhamento para a pagina de update.
	@RequestMapping(value= "/update/{id}" )
	public String update(@PathVariable("id") Long id, Model model) {

		// Procura o objeto  AtividadeDesenvolvida pelo seu id.
		Optional<AtividadeDesenvolvida> atividadeDesenvolvida = atividadeDesenvolvidaDAOI.findById(id);
		// Passando para o modelo o objeto captado acima.
		model.addAttribute("atividadeDesenvolvidaForm", atividadeDesenvolvida.get());
		// Verifica se o obejto está vazio.			
		if (!atividadeDesenvolvida.isEmpty()) {
			// Encaminha o fluxo para a view.
			return "AtividadeDesenvolvida/updateatividadedesenvolvida";
		}else {
			// Caso ocorra um "erro" na verificação, será mostrada uma mensagem logo acima da tabela apresentada na view.
			model.addAttribute("errors","Atividade Desenvolvida não encontrada!");
			// Encaminha o fluxo para a view.
			return "AtividadeDesenvolvida/listaatividadedesenvolvida";
		}
	}


	// Validação e ação de mudança no bando. Encaminhamento para a pagina de listagem das atividades.
	@RequestMapping(value= "/update2" , method = RequestMethod.POST)
	public String update2(@Valid @ModelAttribute("atividadeDesenvolvidaForm") AtividadeDesenvolvida form,
			BindingResult bindingResult,
			Model model
			) {

		//Verificação de erro
		if(bindingResult.hasErrors()) {
			return "AtividadeDesenvolvida/newatividadedesenvolvida";
		}

		// Salvando as alterações realizadas através do form.
		atividadeDesenvolvidaDAOI.save(form);
		// Mensagem que irá ser apresentada logo acima da tabela apresentada.
		model.addAttribute("msgs", "Atividade Desenvolvida alterada com sucesso!");
		// Encaminha o fluxo para a url.
		return "redirect:/atividadedesenvolvida/all";
	}


	// Deletar o elemento selecionado.
	@RequestMapping(value= "/delete/{id}" , method = RequestMethod.GET)
	public String delete(@PathVariable("id") Long id, Model model) {

		// Procura o objeto  AtividadeDesenvolvida pelo seu id.
		Optional<AtividadeDesenvolvida> atividadeDesenvolvida = atividadeDesenvolvidaDAOI.findById(id);
		// Verifica se o obejto está vazio.
		if (!atividadeDesenvolvida.isEmpty()) {
			// Deleta o objeto captado anteriormente.
			atividadeDesenvolvidaDAOI.delete(atividadeDesenvolvida.get());
			// Mensagem que irá ser apresentada logo acima da tabela apresentada.
			model.addAttribute("msgs", "Atividade Desenvolvida deletada com sucesso!");
		} else {
			// Caso ocorra um "erro" na verificação, será mostrada uma mensagem logo acima da tabela apresentada na view.
			model.addAttribute("errors","Atividade Desenvolvida não encontrada!");
		}
		// Encaminha o fluxo para a url.
		return "redirect:/atividadedesenvolvida/all";	
	}


	//Cria uma nova  AtividadeDesenvolvida.
	@RequestMapping(value= "/new")
	public String novo(Long id, Model model) {

		List<AreaAtuacao> areasAtuacao = areaAtuacaoDAOI.findAll();
		// Passando para o modelo a colection/lista.
		model.addAttribute("areasAtuacao", areasAtuacao);
		//Cria e passa para o model uma "AreaMenor" vazia.
		//Cria e passa para o model uma " AtividadeDesenvolvida" vazia.
		model.addAttribute("atividadeDesenvolvidaForm", new AtividadeDesenvolvida());
		//Encaminha o fluxo para a view, que irá possibilitar o preenchimento dos dados.
		return "AtividadeDesenvolvida/newatividadedesenvolvida";
	}


	// Conclui as mudanças realizadas na view de criação.
	@RequestMapping(value= "/new2")
	public String novo2 (@Valid @ModelAttribute("atividadeDesenvolvidaForm") AtividadeDesenvolvida form,
			BindingResult bindingResult,
			Model model
			) {

		//Verificação de erro
		if(bindingResult.hasErrors()) {
			return "AtividadeDesenvolvida/newatividadedesenvolvida";
		}

		// Salva as alterações realizadas através do form.
		atividadeDesenvolvidaDAOI.save(form);
		// Mensagem que irá ser apresentada logo acima da tabela apresentada.
		model.addAttribute("msgs", "Atividade Desenvolvida cadastrada com sucesso");
		// Encaminha o fluxo para a url.
		return "redirect:/atividadedesenvolvida/all";
	} 

}
