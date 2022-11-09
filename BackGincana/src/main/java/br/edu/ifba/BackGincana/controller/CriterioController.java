package br.edu.ifba.BackGincana.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifba.BackGincana.model.CriterioModel;
import br.edu.ifba.BackGincana.repository.CriterioRepository;

@RestController
@RequestMapping(value = "/criterio")
public class CriterioController {

	@Autowired
	private CriterioRepository repository;

	@GetMapping("/teste")
	public String teste() {
		System.out.println("Entrou");
		return "Testando Rota";
	}

	@GetMapping("/listall")
	public List<CriterioModel> findall() {
		System.out.println("Entrou aqui");
		return (List<CriterioModel>) repository.findAll();
	}

	@GetMapping("/{id}")
	public CriterioModel findById(@PathVariable("id") Long id) {
		Optional<CriterioModel> obj = repository.findById(id);
		if (obj.isPresent())
			return obj.get();
		return null;
	}

	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public boolean insert(@RequestBody CriterioModel model) {
		System.out.println("server - insert: " + model);
		try {
			repository.save(model);
			System.out.println("server - insert: TRUE");
			return true;
		} catch (Exception e) {
			System.out.println("server - insert: FALSE");
			e.printStackTrace();
			return false;
		}
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public boolean delete(@PathVariable("id") Long id) {
		System.out.println("delete");
		try {
			repository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<CriterioModel> update(@PathVariable("id") Long id, @RequestBody CriterioModel criterioModel) {
		var p = repository.findById(id);
		if (p.isPresent()) {
			var criterio = p.get();
			if (criterioModel.getNome_Criterio() != null)
				criterioModel.setNome_Criterio(criterioModel.getNome_Criterio());
			if (criterioModel.getPontuacao_min_Criterio() != 0)
				criterioModel.setPontuacao_min_Criterio(criterioModel.getPontuacao_min_Criterio());
			if (criterioModel.getPontuacao_max_Criterio() != 0)
				criterioModel.setPontuacao_max_Criterio(criterioModel.getPontuacao_max_Criterio());
			repository.save(criterio);
			return ResponseEntity.ok(criterio);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
