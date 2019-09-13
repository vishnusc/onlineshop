<%@page import="com.cruds.entity.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.cruds.entity.Order"%>
<%@page import="com.cruds.entity.Login" %>
<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" type="text/css" href="css/new.css">
</head>
<body>

	<%
	 	Order order = null;
		Login login = null;
		order = (Order)session.getAttribute("ORDER");
		login = (Login) session.getAttribute("LOGIN");
	%>
	
<ul>
	
	<%
		if(order!= null || login != null){
		session.setAttribute("ORDER", null);
	%>
  <li style="float:right"><a class="active" href="LogoutServlet">LOGOUT</a></li>
  <li role="presentation" class="active"><a href="#">HOME</a></li>
  <li style="float:right"><a class="active" href="cart.jsp">CART</a></li>
  <li style="float:right"><a class="active" href="ViewOrder">ORDERS</a></li>
 <li style="float:right"><a class="active" href="#"><%=login.getUserName()%></a></li>
  
  <%
		}else{
  %>
  <li role="presentation" class="active"><a href="#">HOME</a></li>
  
  <li style="float:right"><a class="active" href="login.jsp">LOGIN</a></li>
  <li style="float:right"><a class="active" href="cart.jsp">CART</a></li>
  
  
  <%} %>
</ul>
  
  
 
 <div class="gallery">
 
    <img src="img/iphone.jpg" alt="Cinque Terre" width="300" height="200">
  
  <div class="desc"> Apple iPhone X(64GB) <br/> <br/>
  <a href ="AddCartServlet?pid=101&pname=iPhone&price=86000" ><img src="img/btn.PNG"/></a>
   </div>
</div>

<div class="gallery">
 
    <img src="img/mi.jpg" alt="Cinque Terre" width="300" height="200">
  
  <div class="desc"> MI A1(64GB) <br/> <br/>
  <a href ="AddCartServlet?pid=102&pname=MI&price=30000" ><img src="img/btn.PNG"/></a>
   </div>
</div>

<div class="gallery">
 
    <img src="img/oppo.jpg" alt="Cinque Terre" width="300" height="200">
  
  <div class="desc">Oppo F6 (64GB)<br/> <br/> <a href ="AddCartServlet?pid=103&pname=Oppo&price=36000" ><img src="img/btn.PNG"/></a></div>
</div>

<div class="gallery">
 
    <img src="img/pixel.jpg" alt="Cinque Terre" width="300" height="200">
  
  <div class="desc">Google Pixel(64GB)<br/> <br/> <a href ="AddCartServlet?pid=104&pname=Pixel&price=80000" ><img src="img/btn.PNG"/></a> </div>
</div>


</body>
</html>
