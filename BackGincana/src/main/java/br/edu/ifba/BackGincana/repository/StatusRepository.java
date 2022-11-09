package br.edu.ifba.BackGincana.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifba.BackGincana.model.StatusModel;

public interface StatusRepository extends JpaRepository<StatusModel, Long> {

}
