package classes;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.ResultSet;

import java.sql.Statement;




public class Controller {
	protected Connection connection = null;
	protected Statement statement = null;
	protected ResultSet resultset = null;

	public void Conectar() {
		try {
			this.connection = DriverManager.getConnection("jdbc:mysql://localhost/culttech?useTimezone=true&serverTimezone=UTC", "root", "root123");
			this.statement = this.connection.createStatement();
			System.out.println(" Sua conexão foi feita com sucesso!");
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}


	


}



