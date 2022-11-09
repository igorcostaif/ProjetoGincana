package br.edu.ifba.BackGincana.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifba.BackGincana.model.EventoModel;

public interface EventoRepository extends JpaRepository<EventoModel, Long> {

}
