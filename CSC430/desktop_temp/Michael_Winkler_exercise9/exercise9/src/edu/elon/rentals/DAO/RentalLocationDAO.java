package edu.elon.rentals.DAO;

import org.springframework.stereotype.Component;

import edu.elon.rental.business.RentalLocation;

import java.util.List;

public interface RentalLocationDAO{
	public List<RentalLocation> getRentalLocations();
}
