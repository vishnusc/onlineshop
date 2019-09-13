package com.cruds.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cruds.entity.Login;
import com.cruds.entity.Order;
import com.cruds.entity.Product;
import com.cruds.service.ShopingServices;

/**
 * Servlet implementation class OrderServlet
 */
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		int GST = 12;
		float price = 0;
		int oid = 0;
		HttpSession session = request.getSession(true);
		
		
		List<Product> list= (List<Product>) session.getAttribute("CART");
		int lid = 0;
		Login login = null;
		login =  (Login) session.getAttribute("LOGIN");
		
		System.out.println(login.getLid());
		float[] total = new float[list.size()];
		int i=0;
		
		if(list != null){
			for(Product p : list){
				total[i]=p.getPrice();
				i++;
			}
			
			price = total[0];
			if(list.size()==1){
				price = price * GST;	
			}else{
				for(int j=1;j<list.size();j++){
					price = price + total[j];
				}
				price = price * GST;
			}
			ShopingServices service = new ShopingServices();
			oid = service.addOrder(price,login.getLid());
			System.out.println(oid);
			for(Product p : list){
				
				ShopingServices service1 = new ShopingServices();
				service1.addProduct(oid, p);
			}
			Order order = new Order(oid, price);
			session.setAttribute("ORDER", order);
			
		}
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
