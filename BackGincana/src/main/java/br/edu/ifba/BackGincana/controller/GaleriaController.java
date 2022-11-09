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

import br.edu.ifba.BackGincana.model.GaleriaModel;
import br.edu.ifba.BackGincana.repository.GaleriaRepository;

@RestController
@RequestMapping(value = "/galeria")
public class GaleriaController {

	@Autowired
	private GaleriaRepository repository;

	@GetMapping("/teste")
	public String teste() {
		System.out.println("Entrou");
		return "Testando Rota";
	}

	@GetMapping("/listall")
	public List<GaleriaModel> findall() {
		System.out.println("Entrou aqui");
		return (List<GaleriaModel>) repository.findAll();
	}

	@GetMapping("/{id}")
	public GaleriaModel findById(@PathVariable("id") Long id) {
		Optional<GaleriaModel> obj = repository.findById(id);
		if (obj.isPresent())
			return obj.get();
		return null;
	}

	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public boolean insert(@RequestBody GaleriaModel model) {
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
	public ResponseEntity<GaleriaModel> update(@PathVariable("id") Long id, @RequestBody GaleriaModel galeriaModel) {
		var p = repository.findById(id);
		if (p.isPresent()) {
			var galeria = p.get();
			if (galeriaModel.getNome_Galeria() != null)
				galeriaModel.setNome_Galeria(galeriaModel.getNome_Galeria());
			if (galeriaModel.getDescricao_Galeria() != null)
				galeriaModel.setDescricao_Galeria(galeriaModel.getDescricao_Galeria());

			repository.save(galeria);
			return ResponseEntity.ok(galeria);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
