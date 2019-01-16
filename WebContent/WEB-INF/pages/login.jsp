<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div align="center">
	<div class="login-module">
		<h1>Login</h1>
		<form:form method="POST" modelAttribute="user" action="registerUser">
  <div class="form-group">
  	<div class="col-4 log-field">
		<form:label path="username">Username</form:label>
		<form:input class="form-control" type="email" path="email" />
	 </div>
	 <form:errors path="email"/>
  </div>
  <div class="form-group">
  	<div class="col-4 log-field">
		<form:label path="password">Password</form:label>
		<form:password class="form-control" path="password" />
	</div>
	<form:errors path="password"/>
  </div>
  <div class="form-group">
  	<div class="col-4 log-field">
		<form:label path="passwordConfirmation">Confirm Password</form:label>
		<form:password class="form-control" path="passwordConfirmation" />
	</div>
	<form:errors path="passwordConfirmation"/>
  </div>
  
  <input type="submit" value="Submit" class="btn btn-default" />
	<p id="toLoginForm"><a href="#">Return to login</a></p>
</form:form>
	</div>
</div>