package com.cruds.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cruds.entity.Cart;
import com.cruds.entity.Product;

/**
 * Servlet implementation class AddCartServlet
 */
public class AddCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		int pid1 = Integer.parseInt(request.getParameter("pid"));
		String pname1 = request.getParameter("pname");
		float price1 = Float.parseFloat(request.getParameter("price"));
		Product p = new Product(pid1, pname1, price1);
		
		HttpSession session = request.getSession(true);
		
		
		
		//Cart cart = (Cart) session.getAttribute("CART");
		
		List<Product> list= (List<Product>) session.getAttribute("CART");

		  if(list==null){
		    list =new ArrayList<>();
		 }
		   //Add the name & cost to List
		  	list.add(p);

		  session.setAttribute("CART",list);
		/*if(cart == null){
			
			 cart = new Cart();
		}	 
			cart.addToCart(p);
			
			List<Product> list = cart.getList();
			session.setAttribute("CART",cart);*/
			
			
		
			
			
			
		
		
		RequestDispatcher rd = request.getRequestDispatcher("cart.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
