package com.app.data;

import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.app.data.interfaces.DataAccessInterface;
import com.app.models.ForumPost;

public class ForumDAO implements DataAccessInterface<ForumPost> {

	@SuppressWarnings("unused")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	@Override
	public boolean create(ForumPost model) {
		String sql = "INSERT INTO forumposts(userID, content, category) VALUES(?, ?, ?)";
		try
		{
			int rows = jdbcTemplateObject.update(sql, model.getUserID(), model.getContent(), model.getCategory());
			
			return rows == 1 ? true : false;
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return false;
	}
	
	@Override
	public List<ForumPost> findAll() {
		String sql = "SELECT * FROM forumposts ORDER BY `id` DESC";
		List<ForumPost> list = new ArrayList<ForumPost>();
		try
		{
			SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql);
			while(srs.next())
			{
				ForumPost post = new ForumPost(srs.getInt("id"), srs.getInt("userID"), srs.getString("content"), srs.getString("category"));
				list.add(post);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public ForumPost find(ForumPost model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ForumPost find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ForumPost find(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(ForumPost model) {
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
