package com.app.data;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.app.data.interfaces.DataAccessInterface;
import com.app.models.User;

public class UserDAO implements DataAccessInterface<User>{

	@SuppressWarnings("unused")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	@Override
	public boolean create(User model) {
		String sql = "INSERT INTO users(username, password) VALUES(?, ?)";
		try
		{
			int rows = jdbcTemplateObject.update(sql, model.getUsername(), model.getPassword());
			
			return rows == 1 ? true : false;
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public User find(User model) {
		String sql = "SELECT * FROM users WHERE username=? AND password=?";
		
		try
		{
			SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql, model.getUsername(), model.getPassword());
			if (srs.next())
			{
				System.out.println("Found the user");
				User user = new User(srs.getInt("id"), srs.getString("username"), null, null);
				return user;
			}
			else
			{
				return new User();
			}
		} catch (Exception e) {
			e.printStackTrace();
			
			return new User();
		}
	}

	@Override
	public User find(int id) {
		String sql = "SELECT * FROM users WHERE id=?";
		
		try
		{
			SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql, id);
			if (srs.next())
			{
				System.out.println("Found the user");
				User user = new User(srs.getInt("id"), srs.getString("username"), null, null);
				return user;
			}
			else
			{
				return new User();
			}
		} catch (Exception e) {
			e.printStackTrace();
			
			return new User();
		}
	}

	@Override
	public User find(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(User model) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Autowired
	private void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
}
