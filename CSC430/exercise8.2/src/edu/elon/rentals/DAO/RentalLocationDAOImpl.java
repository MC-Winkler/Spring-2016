package edu.elon.rentals.DAO;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;



import edu.elon.rental.business.RentalLocation;

@Component("rentalLocationDAO")
public class RentalLocationDAOImpl implements RentalLocationDAO {

	private NamedParameterJdbcTemplate jdbc;
	
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
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}
	
	@Transactional
	public boolean create(RentalLocation rentalLocation) {
			BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(rentalLocation);
			return jdbc.update("insert into rentallocations (name, address1, address2, city, state, postalcode) values (:name, :address1, :address2, :city, :state, :postalCode)", params) == 1;
			
			
	}
}
