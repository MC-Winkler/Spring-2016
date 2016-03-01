package edu.elon.mwinkler.DAO;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import edu.elon.mwinkler.business.RentalLocation;

@Component("rentalLocationDAO")
public class RentalLocationDAOImpl implements RentalLocationDAO {

	private JdbcTemplate jdbc;
	
	public List<RentalLocation> getRentalLocations() {
		 return jdbc.query("select * from rentallocations", new RowMapper<RentalLocation>(){

			public RentalLocation mapRow(ResultSet rs, int id) throws SQLException {
				RentalLocation r = new RentalLocation();
				r.setAddress1(rs.getString("address1"));
				r.setAddress2(rs.getString("address2"));
				r.setCity(rs.getString("city"));
				r.setName(rs.getString("name"));
				r.setPostalCode(rs.getString("postalCode"));
				r.setRentalLocationId(rs.getInt("rentalLocationId"));
				r.setState(rs.getString("state"));
				return r;
			}
			 
		 });
	}
	
	@Autowired 
	public void setDataSource(DataSource jdbc){
		this.jdbc = new JdbcTemplate(jdbc);
	}
}
