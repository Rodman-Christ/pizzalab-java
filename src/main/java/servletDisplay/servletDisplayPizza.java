package servletDisplay;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbconnect.pizza;
import servletpizza.ServletAddPizza1;

@WebServlet("/register")
public class servletDisplayPizza extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletAddPizza1 pizzaria;
	
	public void init() {
		pizzaria = new ServletAddPizza1();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		String prix = request.getParameter("prix");
		
		pizza pizza = new pizza();
		pizza.setName(name);
		pizza.setDescription(description);
		pizza.setPrix(prix);
		
		try {
			pizzaria.registerPizza(pizza);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("display.jsp");
	}
}
