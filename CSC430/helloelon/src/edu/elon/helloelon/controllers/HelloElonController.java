package edu.elon.helloelon.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.elon.helloelon.service.HelloElonService;


@Controller
public class HelloElonController {
	
	private HelloElonService helloElonService;
	
	@Autowired
	public void setHelloElonService(HelloElonService helloElonService) {
		this.helloElonService = helloElonService;
	}

	@RequestMapping("/")
	public String methodOne(Model model) {
		model.addAttribute("helloelon", helloElonService.getElon());
		return "helloelon";
	}
	
	@RequestMapping("/helloelonagain")
	public String methodTwo(Model model){
		model.addAttribute("helloelonagain", helloElonService.getElonAgain());
		return "helloelonagain";
	}
	
}
