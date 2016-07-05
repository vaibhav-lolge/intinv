package com.inventory.dao;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import com.inventory.mapper.RolesMapper;
import com.inventory.model.Roles;

public class RolesDAO {
	
	@SuppressWarnings("unused")
	private DataSource dataSource;
	
	private JdbcTemplate jdbcTemplate;

	
	public List<Roles> getRoles() {
		String SQL="select * from roles";
		List<Roles> roles= jdbcTemplate.query(SQL,  new RolesMapper());
		return roles;
	}

	
	public Roles getRole(int id) {
		return null;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
}
