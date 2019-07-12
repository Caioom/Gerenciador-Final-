package com.caio.gerencidortarefas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caio.gerencidortarefas.models.Usuarios;

public interface RepositorioUsuario extends JpaRepository<Usuarios, Long>{
	Usuarios findByEmail(String email);
}	
