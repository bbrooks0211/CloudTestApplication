<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div align="center">
	<div class="forum-form">
		<h1>Forum Main Page</h1>
		<form:form method="POST" modelAttribute="post" action="submitPost">
  <div class="form-group">
  	<h2>User: ${user.getUsername()}</h2>
  	<div class="col-4 log-field">
		<form:label path="content">Add to the forum</form:label>
		<form:textarea class="form-control" path="content" rows="5" cols="30" />
	 </div>
	 <form:errors path="content"/>
  </div>
  <input type="submit" value="Submit" class="btn btn-default" />
</form:form>
	</div>
	<div class="row">
		<div class="col-md-4"></div>
		<div class="col-md-4">
		<c:forEach items="${ posts }" var="p">
			<div class="forum-post">
				<h3 align="left" style="text-align: left">${p.getUsername()}</h3>
				<p style="text-align: left">${p.getContent()}</p>
			</div>
		</c:forEach>
		</div>
	</div>
</div>