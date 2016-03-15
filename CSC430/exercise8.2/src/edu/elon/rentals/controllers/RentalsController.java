package edu.elon.rentals.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.elon.rental.business.RentalLocation;
import edu.elon.rentals.service.RentalService;

@Controller
public class RentalsController {

	private RentalService service;
	
	@Autowired
	public void setService(RentalService service) {
		this.service = service;
	}

	@RequestMapping({"/","/showrentals"})
	public String method1(Model model){
		model.addAttribute("rentalList", service.getRentalLocations());
		
		return"displayLocations";
	}
	
	@RequestMapping("/createrental")
	public String method2(Model model){
		model.addAttribute("rentalLocation", new RentalLocation());
		return "enterData";
	}
	
	@RequestMapping("/registerrental")
	public String method3(Model model, @Valid RentalLocation rentalLocation, BindingResult result) {
		
		if(result.hasErrors())
			return "enterData";
		else{
			service.createRentalLocation(rentalLocation);
			return "redirect:/showrentals";
		}
	}
	
	
}
