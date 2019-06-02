package Controler;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

import Model.ModeloFilme;
import Model.ModeloTabela;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class ControleFilme {
	private JTable table_listar;

	static ConexaoBD conexao = new ConexaoBD();
	ModeloFilme filme = new ModeloFilme();

	public void AdicionarFilme(ModeloFilme filme) throws SQLException {
		conexao.conexao();
		String sql = " insert into Filmes (nome, notas, personagens, descricao, genero_do_filme) values (?,?,?,?,?)";
		PreparedStatement comando = conexao.con.prepareStatement(sql);
		comando.setString(1, filme.getNome());
		comando.setInt(2, filme.getNota());
		comando.setString(3, filme.getPersonagens());
		comando.setString(4, filme.getDescricao());
		comando.setString(5, filme.getGenero());
		comando.execute();
		comando.close();
	}

	public static ModeloFilme pesquisaFilme(ModeloFilme filme) {
		conexao.conexao();
		conexao.executaSql("select *from Filmes where nome like '%" + filme.getPesquisa() + "%'");

		try {
			conexao.rs.first();
			filme.setId(conexao.rs.getInt("id"));
			filme.setNome(conexao.rs.getString("nome"));
			filme.setNotas(conexao.rs.getInt("notas"));
			filme.setPersonagens(conexao.rs.getString("personagens"));
			filme.setDescricao(conexao.rs.getString("descricao"));
			filme.setGenero(conexao.rs.getString("genero_do_filme"));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao realizar a pesquisa");
		}
		return filme;

	}
	
	public void ListarFilmes(String Sql) {
		ArrayList dados = new ArrayList();
		String[] colunas = new String[] { "ID", "Nome", "Notas", "Personagens", "Descricao", "Genero" };
		conexao.conexao();
		conexao.executaSql(Sql);
		try {
			conexao.rs.first();
			do {
				dados.add(new Object[]
						{ conexao.rs.getInt("id"),
								conexao.rs.getString("nome"),
								conexao.rs.getInt("notas"),
								conexao.rs.getString("personagens"),
								conexao.rs.getString("descricao"),
								conexao.rs.getString("genero_do_filme") });
			} while (conexao.rs.next());
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao preencher a tabela" + e);
		}
		ModeloTabela mod = new ModeloTabela(dados, colunas);
		table_listar.setModel(mod);
		table_listar.getColumnModel().getColumn(0).setPreferredWidth(23);
		table_listar.getColumnModel().getColumn(0).setResizable(false);
		table_listar.getColumnModel().getColumn(1).setPreferredWidth(100);
		table_listar.getColumnModel().getColumn(1).setResizable(false);
		table_listar.getColumnModel().getColumn(2).setPreferredWidth(100);
		table_listar.getColumnModel().getColumn(2).setResizable(false);
		table_listar.getColumnModel().getColumn(3).setPreferredWidth(100);
		table_listar.getColumnModel().getColumn(3).setResizable(false);
		table_listar.getColumnModel().getColumn(4).setPreferredWidth(100);
		table_listar.getColumnModel().getColumn(4).setResizable(false);
		table_listar.getColumnModel().getColumn(5).setPreferredWidth(100);
		table_listar.getColumnModel().getColumn(5).setResizable(false);
		table_listar.getTableHeader().setReorderingAllowed(true);
		table_listar.setAutoResizeMode(table_listar.AUTO_RESIZE_OFF);// não pode redimensionar a tabela.coluna
		table_listar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// só pode selecionar uma linha por vez

	}

	public void EditarFilme(ModeloFilme filme) throws SQLException {
		conexao.conexao();
		try {
			PreparedStatement pst = conexao.con.prepareStatement(
					"update filmes set nome=?,notas=?,personagens=?,descricao=?,genero_do_filme=? where id=?");
			pst.setString(1, filme.getNome());
			pst.setInt(2, filme.getNota());
			pst.setString(3, filme.getPersonagens());
			pst.setString(4, filme.getDescricao());
			pst.setString(5, filme.getGenero());
			pst.setInt(6, filme.getId());
			pst.execute();
			JOptionPane.showMessageDialog(null, "Dados alterados com sucesso");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Dados não alterados" + e);
		}

	}

	public void excluirFilme(String filme) throws SQLException {
		conexao.conexao();
		String sql = "delete from Filmes where nome like '%" + filme + "%'";
		PreparedStatement comando = conexao.con.prepareStatement(sql);
		JOptionPane.showMessageDialog(null, "Registro do filme removido com sucesso");
		comando.execute();
		comando.close();

	}

}