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

import br.edu.ifba.BackGincana.model.CursoModel;
import br.edu.ifba.BackGincana.repository.CursoRepository;

@RestController
@RequestMapping("/curso")
public class CursoController {

	@Autowired
	private CursoRepository repository;

	@GetMapping("/teste")
	public String teste() {
		System.out.println("Entrou");
		return "Testando Rota";
	}

	@GetMapping("/listall")
	public List<CursoModel> findall() {
		System.out.println("Entrou aqui");
		return (List<CursoModel>) repository.findAll();
	}

	@GetMapping("/{id}")
	public CursoModel findById(@PathVariable("id") Long id) {
		Optional<CursoModel> obj = repository.findById(id);
		if (obj.isPresent())
			return obj.get();
		return null;
	}

	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public boolean insert(@RequestBody CursoModel model) {
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
	public ResponseEntity<CursoModel> update(@PathVariable("id") Long id, @RequestBody CursoModel cursoModel) {
		var p = repository.findById(id);
		if (p.isPresent()) {
			var curso = p.get();
			if (cursoModel.getNome_Curso() != null)
				cursoModel.setNome_Curso(cursoModel.getNome_Curso());
			if (cursoModel.getModalidade_Curso() != null)
				cursoModel.setModalidade_Curso(cursoModel.getModalidade_Curso());

			repository.save(curso);
			return ResponseEntity.ok(curso);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
