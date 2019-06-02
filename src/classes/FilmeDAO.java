package classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FilmeDAO {

	public void AdicionarFilme(Filme filme) throws SQLException {
		Connection connection = CulttechDao.conectar();
		String sql = " insert into Filmes (nome, nota, personagens, descricao, genero) values (?,?,?,?,?)";
		PreparedStatement comando = connection.prepareStatement(sql);
		comando.setString(1, filme.getNome());
		comando.setInt(2, filme.getNota());
		comando.setString(3, filme.getPersonagens());
		comando.setString(4, filme.getDescricao());
		comando.setString(5, filme.getGenero());
		comando.execute();
		comando.close();
	}
	
	public void ListarFilme(Filme filme) throws SQLException {
		Connection connection = CulttechDao.conectar();
		String sql = " select nome from Filmes ";
		PreparedStatement comando = connection.prepareStatement(sql);
		ResultSet r = comando.executeQuery();
		while(r.next()) {
			String nome = r.getString(0);
			System.out.println(nome);
			
		}
		
		comando.close();
	}
}
