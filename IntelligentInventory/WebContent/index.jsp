<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>iNTiNV</title>
<link rel="stylesheet" href="resources/style.css" type="text/css"/>
<link rel="stylesheet" href="resources/bootstrap.min.css" type="text/css"/>
<link rel="stylesheet" href="resources/blue.css" type="text/css"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
<script src="resources/jQuery/jQuery-2.2.0.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
<script src="resources/js/icheck.min.js"></script>

<script>
  $(function () {
    $('input').iCheck({
      checkboxClass: 'icheckbox_square-blue',
      radioClass: 'iradio_square-blue',
      increaseArea: '20%' // optional
    });
  });
</script>

</head>
<body class="welcome">
	<br>
	<img src="resources/images/Logo4.png" height="150" width="300"/>
		<div class="modal-dialog">
		<div class="login-logo">
	    	<a href="#"><b>iNTELLIGENT</b>iNVENTORY</a>
	  	</div>
	  	<h2>Welcome 
	  		<c:choose>
				<c:when test="${empty loggedInUser}">
					Guest!
				</c:when>
				<c:otherwise>
					${loggedInUser}!
				</c:otherwise>
		</c:choose>
	  	
	  	
	  	</h2>	
	  	  	
	  	<div>
	  		  	
			<c:choose>
					<c:when test="${empty loggedInUser}">
						<br>
		  				<br>
		  				Proceed to Login or Register if you are not already a member.<br>
						<a href="register" style="color:white">Register</a>&nbsp; &nbsp;|&nbsp;&nbsp;
						<a href="login" style="color:white">Login</a>
					</c:when>
					<c:otherwise>
						<a href="welcome" style="color:white">Home</a>&nbsp; &nbsp;|&nbsp;&nbsp;
						<a href="logout" style="color:white">Logout</a>
					</c:otherwise>
			</c:choose>
		</div>
		
		<br>
		<br>
		<br>
		
		Powered by Sunetos Systems.
		
 	</div>
</body>
</html>