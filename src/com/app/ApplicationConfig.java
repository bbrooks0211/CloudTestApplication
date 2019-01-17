package com.app;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import com.app.controllers.LoginController;
import com.app.data.ForumDAO;
import com.app.data.UserDAO;
import com.app.data.interfaces.DataAccessInterface;
import com.app.models.ForumPost;
import com.app.models.User;
import com.app.services.ForumBusinessService;
import com.app.services.UserBusinessService;
import com.app.services.interfaces.ForumBusinessServiceInterface;
import com.app.services.interfaces.UserBusinessServiceInterface;

@Configuration
public class ApplicationConfig {
	
	@Bean(name="loginController")
	public LoginController loginController()
	{
		return new LoginController();
	}
	
	@Bean(name="userDAO")
	@Scope(value="singleton", proxyMode=ScopedProxyMode.TARGET_CLASS)
	public DataAccessInterface<User> getUserDAO() {
		return new UserDAO();
	}
	
	@Bean(name="forumDAO")
	@Scope(value="singleton", proxyMode=ScopedProxyMode.TARGET_CLASS)
	public DataAccessInterface<ForumPost> getForumDAO() {
		return new ForumDAO();
	}
	
	@Bean(name="userBusinessService")
	@Scope(value="singleton")
	public UserBusinessServiceInterface getUserBusinessService() {
		return new UserBusinessService();
	}
	
	@Bean(name="forumBusinessService")
	@Scope(value="singleton")
	public ForumBusinessServiceInterface getForumBusinessService() {
		return new ForumBusinessService();
	}
	
	/**
	* Getter for DataSource SpringBean (singleton scoped)
	* @return DataSource
	*/
	@Bean(name="dataSource", destroyMethod = "close")
	@Scope(value="singleton", proxyMode=ScopedProxyMode.TARGET_CLASS)
	public DataSource getDataSource()
	{
		DataSource dataSource = new DataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/cloudtestapp");
		dataSource.setUsername("root");
		dataSource.setPassword("root"); 
		dataSource.setInitialSize(6);
		dataSource.setTestOnBorrow(true);
		dataSource.setValidationQuery("SELECT 1");
		dataSource.setValidationInterval(30000);
		return dataSource;
	}
}
