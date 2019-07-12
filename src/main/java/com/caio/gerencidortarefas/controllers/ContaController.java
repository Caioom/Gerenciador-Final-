package com.caio.gerencidortarefas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.caio.gerencidortarefas.models.Usuarios;
import com.caio.gerencidortarefas.servicos.ServicoUsuario;

@Controller
public class ContaController {
	@Autowired
	private ServicoUsuario servicoUsuario;
	
	@GetMapping("/login")
	public String login(){
		return "conta/login";
	}
	
	@GetMapping("/registration")
	public ModelAndView registrar(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("conta/registrar");
		mv.addObject("usuario", new Usuarios());
		
		return mv;
	}
	
	@PostMapping("/registration")
	public ModelAndView registrar(@Valid @ModelAttribute("usuario") Usuarios usuario, BindingResult result){
		ModelAndView mv = new ModelAndView();
		Usuarios usr = servicoUsuario.encontrarPorEmail(usuario.getEmail());
		if(usr != null){
			result.rejectValue("email", "", "Usuário já cadastrado");
		}
		if(result.hasErrors()){
			mv.setViewName("conta/registrar");
			mv.addObject("usuario", usuario);
		}else{
			servicoUsuario.salvar(usuario);
			mv.setViewName("redirect:/login");
		}
		
		return mv;	
	}
	
}
