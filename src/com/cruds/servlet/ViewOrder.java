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

import com.cruds.db.OrderDAO;
import com.cruds.entity.Login;
import com.cruds.entity.Order;
import com.cruds.entity.Product;

/**
 * Servlet implementation class ViewOrder
 */
public class ViewOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		Login login = null;
		Order order = null;
		Product product = null;
		
		HttpSession session = request.getSession(true);
		
		login = (Login) session.getAttribute("LOGIN");
		//order = (Order) session.getAttribute("ORDER");
		//product = (Product) session.getAttribute("PRODUCT");
		
		
		List<Product> list = null;
		ArrayList<Product> plist = new ArrayList<>();
		List<Order> olist = null;
		
		OrderDAO dao1 = new OrderDAO();
		olist = (List<Order>) dao1.getOrder(login.getLid());
		for(Order o: olist){
		System.out.println(o);
		}
		for(Order o : olist){
		OrderDAO dao = new OrderDAO();
		 
		
		list = (List<Product>) dao.getProduct(o.getOrderId());
		
		plist.addAll(list);
		
		System.out.println(list);
		}
		//System.out.println(list);
		session.setAttribute("VIEW", plist);
		session.setAttribute("VIEW1", olist);
		
		RequestDispatcher rd = request.getRequestDispatcher("order.jsp");
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
