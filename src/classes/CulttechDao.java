package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CulttechDao {
	static protected Connection connection = null;
	static protected Statement statement = null;
	protected ResultSet resultset = null;

	public static Connection conectar() {
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/culttech?useTimezone=true&serverTimezone=UTC", "root", "root123");
			statement = connection.createStatement();
			System.out.println(" Sua conexão foi feita com sucesso!");
			return connection;
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
			return null;
		}
	}



}
