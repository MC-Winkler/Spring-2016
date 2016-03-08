package edu.elon.helloelon.service;

import org.springframework.stereotype.Service;

@Service
public class HelloElonService {
	
	public String getElon(){
		return "Hello Elon";
	}
	
	public String getElonAgain() {
		return "Hello Elon Again";
	}
	
}
