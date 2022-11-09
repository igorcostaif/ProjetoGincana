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

import br.edu.ifba.BackGincana.model.Notas_CriterioModel;
import br.edu.ifba.BackGincana.repository.Notas_CriterioRepository;

@RestController
@RequestMapping(value = "/notas_criterio")
public class Notas_CriterioController {

	@Autowired
	private Notas_CriterioRepository repository;

	@GetMapping("/teste")
	public String teste() {
		System.out.println("Entrou");
		return "Testando Rota";
	}

	@GetMapping("/listall")
	public List<Notas_CriterioModel> findall() {
		System.out.println("Entrou aqui");
		return (List<Notas_CriterioModel>) repository.findAll();
	}

	@GetMapping("/{id}")
	public Notas_CriterioModel findById(@PathVariable("id") Long id) {
		Optional<Notas_CriterioModel> obj = repository.findById(id);
		if (obj.isPresent())
			return obj.get();
		return null;
	}

	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public boolean insert(@RequestBody Notas_CriterioModel model) {
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
	public ResponseEntity<Notas_CriterioModel> update(@PathVariable("id") Long id,
			@RequestBody Notas_CriterioModel notas_criterioModel) {
		var p = repository.findById(id);
		if (p.isPresent()) {
			var notas_criterio = p.get();
			if (notas_criterioModel.getNota_Criterio() != 0)
				notas_criterioModel.setNota_Criterio(notas_criterioModel.getNota_Criterio());

			repository.save(notas_criterio);
			return ResponseEntity.ok(notas_criterio);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
