package edu.elon.rentals.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.elon.rental.business.RentalLocation;
import edu.elon.rentals.DAO.RentalLocationDAOImpl;

@Service
public class RentalService {

	private RentalLocationDAOImpl rentalLocationDao;

	@Autowired
	public void setRentalDao(RentalLocationDAOImpl rentalDao) {
		this.rentalLocationDao = rentalDao;
	}
	
	
	public List<RentalLocation> getRentalLocations(){
		return rentalLocationDao.getRentalLocations();
	}


	public void createRentalLocation(RentalLocation rentalLocation) {
		rentalLocationDao.create(rentalLocation);
		
	}
}
