package br.com.projetosaula.meusfilmes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;


import br.com.projetosaula.meusfilmes.beans.Filme;
import br.com.projetosaula.meusfilmes.cnn.ConnectionFactory;

public class FilmeDAO {

	private static final String SQL_LIST_FILMES ="SELECT * FROM filme;";
	
	public FilmeDAO() {	}
	
	public List<Filme> getListFilmes(){
		
		List<Filme> listaFilmes= new ArrayList<Filme>();		
		try {
			Connection cnn= ConnectionFactory.getMySQLConnection();
			PreparedStatement pstm = cnn.prepareStatement(SQL_LIST_FILMES);
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()) {
			Filme filme = new Filme(rs.getInt("id"), 
					rs.getString("titulo"), 
					rs.getString("genero"),
					rs.getInt("restricao"), 
					rs.getBoolean("favorito"));	
				listaFilmes.add(filme);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaFilmes;
	}
	
	

}
