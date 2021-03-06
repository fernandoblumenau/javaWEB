package br.com.projetosaula.meusfilmes.controller;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import br.com.projetosaula.meusfilmes.beans.Filme;
import br.com.projetosaula.meusfilmes.dao.FilmeDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(name="filmeControler", urlPatterns = "/filmes")
public class FilmeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private FilmeDAO filmeDao = new FilmeDAO();
       

    public FilmeController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		switch (action.toUpperCase()) {
		case "LIST":
			listFilmesAction(request,response);
			break;

		default:
			break;
		}
		
		
	}

	private void listFilmesAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Filme> filmes = filmeDao.getListFilmes();
		
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/listFilmes.jsp");
		
		request.setAttribute("listFilmes", filmes);
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		

	}
	
	
}
