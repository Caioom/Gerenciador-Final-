package com.caio.gerencidortarefas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.caio.gerencidortarefas.models.Tarefa;

public interface RepositorioTarefa extends JpaRepository<Tarefa, Long>{
	
	@Query("SELECT t FROM Tarefa t WHERE t.usuario.email = :emailUsuario")
	List<Tarefa> CarregarTarefaPorUsuario(@Param("emailUsuario") String email); 
}
