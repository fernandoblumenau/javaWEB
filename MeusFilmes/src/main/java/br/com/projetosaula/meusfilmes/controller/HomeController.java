package br.com.projetosaula.meusfilmes.controller;

import java.io.IOException;

import org.apache.catalina.connector.Response;

import br.com.projetosaula.meusfilmes.beans.Filme;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(name="HomeController", urlPatterns = "/")
public class HomeController extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;


    public HomeController() {

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/home.jsp");
		rd.forward(request, response);
		
		

		
		
	}	

	
}
