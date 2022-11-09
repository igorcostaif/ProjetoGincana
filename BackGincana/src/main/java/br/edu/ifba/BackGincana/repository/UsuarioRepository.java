package br.edu.ifba.BackGincana.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifba.BackGincana.model.UsuarioModel;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long>{

}
