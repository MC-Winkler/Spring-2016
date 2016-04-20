package edu.elon.rentals.controllers;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;



@Component
@Aspect
public class BanElon {
		
	@Before("execution(boolean edu.elon.rentals.DAO.RentalLocationDAOImpl.create(RentalLocation))")
	public void doSomething(){
		System.out.println("Running...");	
	}
}
