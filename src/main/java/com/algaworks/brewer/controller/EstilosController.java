package com.algaworks.brewer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.algaworks.brewer.model.Estilo;

@Controller
public class EstilosController {
	@RequestMapping("/estilos/novo")
	public String novo(Estilo estilo) {
		return "estilo/CadastroEstilo";
	}

}
