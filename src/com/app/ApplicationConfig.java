package com.app;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import com.app.controllers.LoginController;
import com.app.data.UserDAO;
import com.app.data.interfaces.DataAccessInterface;
import com.app.models.User;

@Configuration
public class ApplicationConfig {
	
	@Bean(name="loginController")
	public LoginController loginController()
	{
		return new LoginController();
	}
	
	@Bean(name="friendDAO")
	@Scope(value="singleton", proxyMode=ScopedProxyMode.TARGET_CLASS)
	public DataAccessInterface<User> getFriendDAO() {
		return new UserDAO();
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
		dataSource.setPassword(""); 
		dataSource.setInitialSize(6);
		dataSource.setTestOnBorrow(true);
		dataSource.setValidationQuery("SELECT 1");
		dataSource.setValidationInterval(30000);
		return dataSource;
	}
}
