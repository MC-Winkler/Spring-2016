package edu.elon.mwinkler.DAO;

import org.springframework.stereotype.Component;

import edu.elon.mwinkler.business.RentalLocation;

import java.util.List;

@Component
public interface RentalLocationDAO{
	public List<RentalLocation> getRentalLocations();
}
