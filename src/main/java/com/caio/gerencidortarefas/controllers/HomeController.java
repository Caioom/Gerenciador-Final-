package com.caio.gerencidortarefas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

//Uma das funções do controler é entender as requisições feitas para a aplicação java

//Um controller tem várias acctions q atendem as requisições
@Controller
public class HomeController {
	//Para funcionar como action precisa entender requisições HTPP (verbos) principais: Get, Post, Put, Delete
	@GetMapping("/")
	public ModelAndView home(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home/home");
		mv.addObject("mensagem", "Mensagem do controller");
		return mv;
	}
}
