package br.edu.ifba.BackGincana.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifba.BackGincana.model.GincanaModel;

public interface GincanaRepository extends JpaRepository<GincanaModel, Long> {

}
