package Controler;

import java.sql.*;

import javax.swing.JOptionPane;

public class ConexaoBD {
	public Statement stm;
	public ResultSet rs;
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String caminho = "jdbc:mysql://localhost:3306/laat?useTimezone=true&serverTimezone=UTC";
	private String usuario = "root";
	private String senha = "root123";
	public Connection con;

	public void conexao() {
		System.setProperty("jdbc.Drivers", driver);
		try {
			con = DriverManager.getConnection(caminho, usuario, senha);

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao se conectar:\n" + e);

		}

	}

	public void desconecta() {
		try {
			con.close();
			JOptionPane.showInternalMessageDialog(null, "Voce foi desconectado");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao finalizar a conexão com o BD:\n" + e.getMessage());
		}
	}

	public void executaSql(String sql) {
		try {
			stm = con.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
			rs = stm.executeQuery(sql);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ExecutaSql:\n" + e.getMessage());
		}
	}

}
