<%@page import="com.cruds.entity.Product"%>
<%@page import="com.cruds.entity.Cart"%>
<%@page import="java.util.List"%>
<%@page import="com.cruds.entity.Login" %>
<%@page import="com.cruds.entity.Order"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/new.css">
<link rel="stylesheet" type="text/css" href="css/login.css">
<title></title>
</head>
<body>

	<% 
	Login login =null;
	String oid = null;
	String price1 = null;
	List<Product> cart = null;
	
	cart = (List<Product>) session.getAttribute("CART");
	login = (Login) session.getAttribute("LOGIN");
	
		
	%>
	<ul>
  <li role="presentation" class="active"><a href="index.jsp">HOME</a></li>
  
  <%
  	if(login != null){
  
  %>
  
  <li style="float:right"><a class="active" href="OrderServlet">CHECHOUT</a></li>
  <li style="float:right"><a class="active" href="ViewOrder">ORDERS</a></li>
  <li style="float:right"><a class="active" href="LogoutServlet">LOGOUT</a></li>
  <li style="float:right"><a class="active" href="#"><%=login.getUserName()%></a></li>
  
  <%
  	}else{
  %>
  <li style="float:right"><a class="active" href="login.jsp">CHECHOUT</a></li>
  <%} %>
</ul>

<table>
		<thead>
			<tr>
				
				<td>PRODUCT ID</td>
				<td>PRODUCT NAME</td>
				<td>PRICE</td>
			</tr>
		</thead>
		
		<%
		if(cart != null){
		float[] total = new float[cart.size()];
		float price = 0;
		int i =0;
		int GST =12;
		if(cart != null){
			for(Product c :cart ){
		%>
		
			<tr>
				<td> <%= c.getPid() %> </td>
				<td> <%= c.getPname() %> </td>
				<td> <%= c.getPrice() %> </td>
			</tr>
					
		<%
			total[i]=c.getPrice();
			i++;
			}}
		%>
		
		<%
		 price = total[0];
		if(cart.size()==1){
			price = price * GST;	
		}else{
			for(int j=1;j<cart.size();j++){
				price = price + total[j];
			}
			price = price * GST;
		}
		
		%>
		
		<tr>
				<td></td>
				<td></td>
				<td> <%= price %> </td>
				<td>(GST 12%)</td>
			</tr>
		
				
		</table>
	
	
	
	
	<%} %>
	<%
		Order order = null;
		order = (Order)session.getAttribute("ORDER");
		
	%>
	<%if(order != null){ %>
	<div class ="gallery1">
	<label><b><h2>Order Placed Successfully</h2></b></label><br/> <br/>
	<label><b>Order Id :<%= order.getOrderId() %></b> </label><br/> <br/>
	<label><b>Total Price : <%= order.getTotal() %></b> </label><br/> <br/>
	</div>
	
	<%
	
	
	session.setAttribute("CART", null);
	%>
  	<%} %>
  	
  	
</body>
</html>