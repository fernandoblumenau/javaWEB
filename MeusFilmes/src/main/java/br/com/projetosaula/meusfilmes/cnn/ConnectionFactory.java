package br.com.projetosaula.meusfilmes.cnn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public static Connection getMySQLConnection() {

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cnn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/meusfilmes?useTimezone=true&serverTimezone=UTC&useSSL=false", "root",
					"admin");

			return cnn;

		} catch (SQLException sex) {
			sex.printStackTrace();
		} catch (ClassNotFoundException cex) {
			cex.printStackTrace();
		}
			return null;
	}
}
