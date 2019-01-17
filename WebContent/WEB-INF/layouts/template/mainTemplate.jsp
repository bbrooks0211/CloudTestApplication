<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>This Is A Forum Site</title>
	 <meta charset="utf-8">
     <meta http-equiv="X-UA-Compatible" content="IE=edge">
     <meta name="viewport" content="width=device-width, initial-scale=1">
     <spring:url value="/assets/js/jquery-3.3.1.min.js" var="jQueryLink" />
     <spring:url value="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" var="bootstrapJsLink" />
     <spring:url value="/assets/js/script.js" var="scriptJsLink" />
     <spring:url value="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" var="bootstrapCssLink" />
     <spring:url value="/assets/css/style.css" var="styleLink" />
     <script type="text/javascript" src="${jQueryLink}"></script>
	 <script type="text/javascript" src="${bootstrapJsLink}"></script>
	 <script type="text/javascript" src="${scriptJsLink}"></script>
	 <link rel="stylesheet" href="${bootstrapCssLink}" />
	 <link rel="stylesheet" href="${styleLink}" />
	 <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet" />
	 <link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
	 <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet">
</head>
<body>
	<!-- Header -->
	<tiles:insertAttribute name="header" />

	<!-- Body Page -->
	<tiles:insertAttribute name="body" />

	<!-- Footer Page -->
	<tiles:insertAttribute name="footer" />
</body>
</html>