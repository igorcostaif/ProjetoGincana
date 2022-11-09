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

import br.edu.ifba.BackGincana.model.EventoModel;
import br.edu.ifba.BackGincana.repository.EventoRepository;

@RestController
@RequestMapping(value = "/evento")
public class EventoController {

	@Autowired
	private EventoRepository repository;

	@GetMapping("/teste")
	public String teste() {
		System.out.println("Entrou");
		return "Testando Rota";
	}

	@GetMapping("/listall")
	public List<EventoModel> findall() {
		System.out.println("Entrou aqui");
		return (List<EventoModel>) repository.findAll();
	}

	@GetMapping("/{id}")
	public EventoModel findById(@PathVariable("id") Long id) {
		Optional<EventoModel> obj = repository.findById(id);
		if (obj.isPresent())
			return obj.get();
		return null;
	}

	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public boolean insert(@RequestBody EventoModel model) {
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
	public ResponseEntity<EventoModel> update(@PathVariable("id") Long id, @RequestBody EventoModel eventoModel) {
		var p = repository.findById(id);
		if (p.isPresent()) {
			var evento = p.get();
			if (eventoModel.getNome_Evento() != null)
				eventoModel.setNome_Evento(eventoModel.getNome_Evento());
			if (eventoModel.getLocal_Evento() != null)
				eventoModel.setLocal_Evento(eventoModel.getLocal_Evento());
			if (eventoModel.getData_Evento() != null)
				eventoModel.setData_Evento(eventoModel.getData_Evento());
			if (eventoModel.getHorario_Evento() != null)
				eventoModel.setHorario_Evento(eventoModel.getHorario_Evento());
			if (eventoModel.getDescricao_Evento() != null)
				eventoModel.setDescricao_Evento(eventoModel.getDescricao_Evento());
			repository.save(evento);
			return ResponseEntity.ok(evento);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
