package com.telephonebook.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.telephonebook.web.dao.ContatoDAO;
import com.telephonebook.web.models.Contato;

@Controller
public class ContatoController {
	
	@Autowired
	private ContatoDAO contatoDao;
	
	@RequestMapping("/contato/form")
	public ModelAndView form(Contato contato){
		ModelAndView mv = new ModelAndView("formNew");
		
		return mv;		
	}
	
	@RequestMapping()
	public ModelAndView write(Contato contato){
		contatoDao.write(contato);
		
		return new ModelAndView("redirect:contato/home");
	}
	
	
	@RequestMapping(value="/delete") //@RequestParam String name
	public ModelAndView delete(@RequestParam(name="name") String name){
		ModelAndView mv = new ModelAndView("redirect:contato/home");
		contatoDao.delete(name);
		return mv;
	}
	
	@RequestMapping("/edit")
	public ModelAndView modelUpdate(@RequestParam String name){
		Contato contato = contatoDao.searchByName(name);
		ModelAndView mv = new ModelAndView("formEdit");
		mv.addObject("contato", contato);
		return mv;
	}
	
	@RequestMapping("/update")
	public ModelAndView update(Contato contato){
		
		contatoDao.update(contato);
		
		
		return new ModelAndView("redirect:contato/home");
	}
	
}
