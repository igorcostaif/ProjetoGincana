package br.edu.ifba.BackGincana.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifba.BackGincana.model.CursoModel;

public interface CursoRepository extends JpaRepository<CursoModel, Long> {

}
