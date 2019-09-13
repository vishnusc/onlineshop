<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/login.css">
<link rel="stylesheet" type="text/css" href="css/new.css">
<title></title>
</head>
<body>
	
	<ul>
  <li role="presentation" class="active"><a href="#">HOME</a></li>
  
  
</ul>

	<form name="registerform" action="RegisterServlet" method="POST">
  

  <div class="container">
  <div class ="imgcontainer">
	  <label for="login"><b><h2>Registration Form</h2></b></label>
  </div>
  	
    <label for="uname"><b>Username</b></label>
    <input type="text" placeholder="Enter Username" name="uname" required>

    <label for="psw"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" required>
	<div class="button">
    <input type="submit" name="btn" value="Register"/>
    </div>
    <label>
       <span class="psw"><a href="login.jsp">Login?</a></span>
    </label>
  </div>

  
</form>
</body>
</html>