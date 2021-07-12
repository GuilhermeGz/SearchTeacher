package br.edu.ufape.apirest;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.context.HttpRequestResponseHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufape.model.AreaMenor;
import br.edu.ufape.repository.AreaMenorDAOI;

@RestController
@RequestMapping("/api/areamenor")
public class AreaMenotRESTController {
	
	@Autowired
	AreaMenorDAOI areaMenorDAOI;
	
	@GetMapping
	@RequestMapping("/all")
	public List<AreaMenor> findAllAreaMenor(){
		
		return areaMenorDAOI.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AreaMenor> getAllAreaMenorById(@PathVariable Long id){
		
		Optional<AreaMenor> optAreaMenor = areaMenorDAOI.findById(id);
		if(optAreaMenor.isPresent()) {
			AreaMenor areamenor= optAreaMenor.get();
			return new ResponseEntity<AreaMenor>(areamenor,HttpStatus.OK);
		}
		
		return new ResponseEntity<AreaMenor>(HttpStatus.NOT_FOUND);
	}
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public AreaMenor addAreaMenor(@RequestBody AreaMenor areamenor) {
		
		AreaMenor novaAreaMenor = areaMenorDAOI.save(areamenor);
		
		return novaAreaMenor;
	}
	
	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<AreaMenor> updateAreaMenor(@RequestBody AreaMenor areamenor) {
		
		Optional<AreaMenor> optAreaMenor = areaMenorDAOI.findById(areamenor.getId());
		if(optAreaMenor.isPresent()) {
			areaMenorDAOI.save(areamenor);
			return new ResponseEntity<AreaMenor>(areamenor,HttpStatus.OK);
		}
		
		return new ResponseEntity<AreaMenor>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<AreaMenor> deleteAreaMenor(@PathVariable Long id){
		
		Optional<AreaMenor> optAreaMenor = areaMenorDAOI.findById(id);
		if(optAreaMenor.isPresent()) {
			AreaMenor areamenor= optAreaMenor.get();
			areaMenorDAOI.delete(areamenor);
			return new ResponseEntity<AreaMenor>(HttpStatus.OK);
		}
		
		return new ResponseEntity<AreaMenor>(HttpStatus.NOT_FOUND);
	}

	
}
