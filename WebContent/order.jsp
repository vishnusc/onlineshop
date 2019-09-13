<%@page import="java.util.ArrayList"%>
<%@page import="com.cruds.entity.Login" %>
<%@page import="com.cruds.entity.Order"%>
<%@page import="com.cruds.entity.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/new.css">

<title>Insert title here</title>
</head>
<body>

	<%
	List<Order> order = null;
	Login login = null;
	ArrayList<Product> product = null;
	//order = (Order)session.getAttribute("ORDER");
	login = (Login) session.getAttribute("LOGIN");
	product = (ArrayList<Product>) session.getAttribute("VIEW");
	order = (List<Order>) session.getAttribute("VIEW1");
	%>
	<ul>
  <li role="presentation" class="active"><a href="index.jsp">HOME</a></li>
  
  <%
  	if(login != null && order != null){
  
  %>
  
  
  <li style="float:right"><a class="active" href="LogoutServlet">LOGOUT</a></li>
  <li style="float:right"><a class="active" href="#"><%=login.getUserName()%></a></li>
  
  <%
  	}
  %>
  </ul>
  <%
 			 if(order != null){
			for(Order o : order){	  
  
 			 %>
  <table>
		<thead>
			<tr>
			
				<td>ORDER ID</td>	
				<td>PRODUCT ID</td>
				<td>PRODUCT NAME</td>
				<td>PRICE</td>
			</tr>
		</thead>	
			
			<%
			if(product != null){
				for(Product p : product ){
					if(o.getOrderId() == p.getPoid()){
			%>
			<tr>
				<td><%= o.getOrderId() %></td>
				<td><%= p.getPid() %></td>
				<td><%= p.getPname() %></td>
				<td><%= p.getPrice() %></td>
			<%}} } %>
			
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td> <%=o.getTotal() %> </td>
				<td>(GST 12%)</td>
			</tr>
					
	</table>
	<%}} %>
</body>
</html>