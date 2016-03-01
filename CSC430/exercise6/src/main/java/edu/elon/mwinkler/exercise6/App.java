package edu.elon.mwinkler.exercise6;

import java.util.List;

import org.springframework.*;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.elon.mwinkler.DAO.RentalLocationDAO;
import edu.elon.mwinkler.business.RentalLocation;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
    
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"edu/elon/mwinkler/beans/beans.xml");

		RentalLocationDAO rentalDao = (RentalLocationDAO) context.getBean("rentalLocationDAO");

		List<RentalLocation> rentalLocations = rentalDao.getRentalLocations();

		for (RentalLocation rentalLocation : rentalLocations) {
			System.out.println(rentalLocation);
		}
		
		((ClassPathXmlApplicationContext)context).close();
		
    }
}
