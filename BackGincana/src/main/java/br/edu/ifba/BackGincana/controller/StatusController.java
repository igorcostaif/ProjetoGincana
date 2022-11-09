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

import br.edu.ifba.BackGincana.model.StatusModel;
import br.edu.ifba.BackGincana.repository.StatusRepository;

@RestController
@RequestMapping(value = "/status")
public class StatusController {

	@Autowired
	private StatusRepository repository;

	@GetMapping("/teste")
	public String teste() {
		System.out.println("Entrou");
		return "Testando Rota";
	}

	@GetMapping("/listall")
	public List<StatusModel> findall() {
		System.out.println("Entrou aqui");
		return (List<StatusModel>) repository.findAll();
	}

	@GetMapping("/{id}")
	public StatusModel findById(@PathVariable("id") Long id) {
		Optional<StatusModel> obj = repository.findById(id);
		if (obj.isPresent())
			return obj.get();
		return null;
	}

	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public boolean insert(@RequestBody StatusModel model) {
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
	public ResponseEntity<StatusModel> update(@PathVariable("id") Long id, @RequestBody StatusModel statusModel) {
		var p = repository.findById(id);
		if (p.isPresent()) {
			var status = p.get();
			if (statusModel.getSituacao_Status() != null)
				statusModel.setSituacao_Status(statusModel.getSituacao_Status());

			repository.save(status);
			return ResponseEntity.ok(status);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}