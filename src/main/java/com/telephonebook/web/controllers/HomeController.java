package com.telephonebook.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.telephonebook.web.dao.ContatoDAO;
import com.telephonebook.web.models.Contato;

@Controller
public class HomeController {
	
	@Autowired
	private ContatoDAO contatoDao;
	
	@RequestMapping(value="/contato/home")
	public ModelAndView home(Contato contato){
		List<Contato> contatos = contatoDao.list(contato.getName(), contato.getPhone(), contato.getEmail());
		
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("contatos",contatos);
		return modelAndView;		
	}
	
	
}
