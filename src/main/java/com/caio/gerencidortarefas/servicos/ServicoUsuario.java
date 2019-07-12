package com.caio.gerencidortarefas.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.caio.gerencidortarefas.models.Usuarios;
import com.caio.gerencidortarefas.repositories.RepositorioUsuario;

@Service
public class ServicoUsuario {
	@Autowired
	private RepositorioUsuario repositorioUsuario;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public Usuarios encontrarPorEmail(String email){
		return repositorioUsuario.findByEmail(email);
	}
	
	public void salvar(Usuarios usuario){
		usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
		repositorioUsuario.save(usuario);
	}
}
