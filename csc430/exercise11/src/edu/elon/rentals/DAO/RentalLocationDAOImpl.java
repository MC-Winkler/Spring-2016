package edu.elon.rentals.DAO;


import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.elon.rental.business.RentalLocation;

@Repository
@Transactional
@Component("rentalLocationDAO")
public class RentalLocationDAOImpl implements RentalLocationDAO {

	private NamedParameterJdbcTemplate jdbc;
	
	@Autowired
	private SessionFactory sessionFactory;

	public Session session() {
		return sessionFactory.getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	public List<RentalLocation> getRentalLocations() {
		
		return session().createQuery("from RentalLocation").list();
		
		/*return jdbc.query("select * from rentallocations", new RowMapper<RentalLocation>(){

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
			 
		 });*/
	}
	
	@Autowired 
	public void setDataSource(DataSource jdbc){
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}
	
	@Transactional
	public void create(RentalLocation rentalLocation) {
		session().save(rentalLocation);
			
			
	}
}
