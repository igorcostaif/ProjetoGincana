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

import br.edu.ifba.BackGincana.model.GincanaModel;
import br.edu.ifba.BackGincana.repository.GincanaRepository;

@RestController
@RequestMapping(value = "/gincana")
public class GincanaController {

	@Autowired
	private GincanaRepository repository;

	@GetMapping("/listall")
	public List<GincanaModel> findall() {
		System.out.println("Entrou aqui");
		return (List<GincanaModel>) repository.findAll();
	}

	@GetMapping("/teste")
	public String teste() {
		System.out.println("Entrou");
		return "Testando Rota";
	}

	// Método que retornar o usuario associado ao ID passado como parametro
	@GetMapping("/{id}")
	public GincanaModel findById(@PathVariable("id") Long id) {
		System.out.println("entrou");

		Optional<GincanaModel> obj = repository.findById(id);
		if (obj.isPresent())
			return obj.get();
		return null;
	}

	@PostMapping("/insert")
	@ResponseStatus(HttpStatus.CREATED)
	public boolean insert(@RequestBody GincanaModel model) {
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
	public ResponseEntity<GincanaModel> update(@PathVariable("id") Long id, @RequestBody GincanaModel gincanaModel) {
		var p = repository.findById(id);
		if (p.isPresent()) {
			var gincana = p.get();
			if (gincanaModel.getNome_Gincana() != null)
				gincanaModel.setNome_Gincana(gincanaModel.getNome_Gincana());
			if (gincanaModel.getDescricao_Gincana() != null)
				gincanaModel.setDescricao_Gincana(gincanaModel.getDescricao_Gincana());
			if (gincanaModel.getData_inicio_Gincana() != null)
				gincanaModel.setData_inicio_Gincana(gincanaModel.getData_inicio_Gincana());
			if (gincanaModel.getData_fim_Gincana() != null)
				gincanaModel.setData_fim_Gincana(gincanaModel.getData_fim_Gincana());
			if (gincanaModel.getId_Status() != null)
				gincanaModel.setId_Status(gincanaModel.getId_Status());

			repository.save(gincana);
			return ResponseEntity.ok(gincana);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
