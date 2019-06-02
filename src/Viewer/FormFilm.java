package Viewer;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import Controler.ControleFilme;
import Model.ModeloFilme;
import Model.ModeloTabela;
import tipografia.Fonte;
import Controler.ConexaoBD;

public class FormFilm extends JFrame {

	private JTextField textField_Personagens;
	private JTextField textField_nome;
	private JTextField textField_Genero;
	private JTextField textField_Id;
	private JTextField textField_Pesquisar;
	private JPanel contentPane;
	private JTextField textField_Nota;
	private JTextPane textPane_descricao;
	private JTable table_listar;
	Fonte tipoFonte;
	ControleFilme filme = new ControleFilme();
	ModeloFilme mod = new ModeloFilme();
	ConexaoBD conexao = new ConexaoBD();
	int flag = 0;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormFilm window = new FormFilm();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FormFilm() {

		tipoFonte = new Fonte();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366, 768);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBackground(new Color(52, 54, 58));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JSeparator separator = new JSeparator();
		separator.setBounds(25, 172, 462, -40);
		contentPane.add(separator);

		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				flag = 1;

			}
		});
		btnAdicionar.setForeground(new Color(52, 54, 58));
		btnAdicionar.setBackground(new Color(243, 156, 18));
		btnAdicionar.setBounds(34, 18, 89, 23);
		contentPane.add(btnAdicionar);

		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				flag = 2;

			}
		});
		btnEditar.setForeground(new Color(52, 54, 58));
		btnEditar.setBackground(new Color(243, 156, 18));
		btnEditar.setBounds(134, 18, 89, 23);
		contentPane.add(btnEditar);

		JButton bntRemover = new JButton("Remover");
		bntRemover.setForeground(new Color(52, 54, 58));
		bntRemover.setBackground(new Color(243, 156, 18));
		bntRemover.setBounds(234, 18, 89, 23);
		contentPane.add(bntRemover);

		table_listar = new JTable();
		table_listar.setSurrendersFocusOnKeystroke(true);
		table_listar.setRowSelectionAllowed(false);
		table_listar.setColumnSelectionAllowed(true);
		table_listar.setForeground(Color.BLACK);
		table_listar.setBackground(Color.WHITE);
		table_listar.setBounds(520, 50, 800, 600);
		contentPane.add(table_listar);

		JButton lblListar = new JButton("Listar");
		lblListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarFilmes("select *from filmes order by nome");

			}
		});
		lblListar.setForeground(new Color(52, 54, 58));
		lblListar.setBackground(new Color(243, 156, 18));
		lblListar.setBounds(334, 18, 89, 23);
		contentPane.add(lblListar);

		JLabel lblId = new JLabel("ID");
		lblId.setFont(tipoFonte.fonte(tipoFonte.Big, 0, 18));
		lblId.setForeground(new Color(243, 156, 18));
		lblId.setBounds(24, 75, 46, 14);
		contentPane.add(lblId);

		textField_Id = new JTextField();
		textField_Id.setEditable(false);
		textField_Id.setBounds(139, 75, 46, 20);
		contentPane.add(textField_Id);
		textField_Id.setColumns(10);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(tipoFonte.fonte(tipoFonte.Big, 0, 18));
		lblNome.setForeground(new Color(243, 156, 18));
		lblNome.setBounds(24, 100, 46, 20);
		contentPane.add(lblNome);

		textField_nome = new JTextField();
		textField_nome.setBounds(139, 100, 243, 20);
		contentPane.add(textField_nome);
		textField_nome.setColumns(10);

		JLabel lblNota = new JLabel("Nota");
		lblNota.setFont(tipoFonte.fonte(tipoFonte.Big, 0, 18));
		lblNota.setForeground(new Color(243, 156, 18));
		lblNota.setBounds(24, 125, 46, 14);
		contentPane.add(lblNota);

		textField_Nota = new JTextField();
		textField_Nota.setBounds(139, 125, 243, 20);
		contentPane.add(textField_Nota);
		textField_Nota.setColumns(10);

		JLabel lbPersonagens = new JLabel("Personagens");
		lbPersonagens.setFont(tipoFonte.fonte(tipoFonte.Big, 0, 18));
		lbPersonagens.setForeground(new Color(243, 156, 18));
		lbPersonagens.setBounds(24, 150, 94, 14);
		contentPane.add(lbPersonagens);

		textField_Personagens = new JTextField();
		textField_Personagens.setBounds(139, 150, 243, 25);
		contentPane.add(textField_Personagens);
		textField_Personagens.setColumns(10);

		JLabel lblDesc = new JLabel("Descri\u00E7\u00E3o");
		lblDesc.setFont(tipoFonte.fonte(tipoFonte.Big, 0, 18));

		lblDesc.setForeground(new Color(243, 156, 18));
		lblDesc.setBounds(24, 220, 79, 14);
		contentPane.add(lblDesc);

		JTextPane textPane_descricao = new JTextPane();
		textPane_descricao.setBounds(139, 180, 243, 74);
		contentPane.add(textPane_descricao);

		JLabel lblGenero = new JLabel("Genero");
		lblGenero.setFont(tipoFonte.fonte(tipoFonte.Big, 0, 18));
		lblGenero.setForeground(new Color(243, 156, 18));
		lblGenero.setBounds(24, 263, 46, 14);
		contentPane.add(lblGenero);

		textField_Genero = new JTextField();
		textField_Genero.setBounds(139, 260, 243, 25);
		contentPane.add(textField_Genero);
		textField_Genero.setColumns(10);

		JButton btnPesquisar = new JButton("Pesquisar");

		btnPesquisar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mod.setPesquisa(textField_Pesquisar.getText());
				ModeloFilme modFilm = ControleFilme.pesquisaFilme(mod);
				textField_Id.setText(String.valueOf(modFilm.getId()));
				textField_nome.setText(modFilm.getNome());
				textField_Nota.setText(String.valueOf(modFilm.getNota()));
				textField_Personagens.setText(modFilm.getPersonagens());
				textPane_descricao.setText(modFilm.getDescricao());
				textField_Genero.setText(modFilm.getGenero());
			}
		});
		btnPesquisar.setForeground(new Color(52, 54, 58));
		btnPesquisar.setBackground(new Color(243, 156, 18));
		btnPesquisar.setBounds(385, 290, 95, 25);
		contentPane.add(btnPesquisar);

		textField_Pesquisar = new JTextField();
		textField_Pesquisar.setBounds(139, 290, 243, 25);
		contentPane.add(textField_Pesquisar);
		textField_Pesquisar.setColumns(10);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (flag == 1) {
					mod.setNome(textField_nome.getText());
					mod.setNotas(Integer.valueOf(textField_Nota.getText()));
					mod.setGenero(textField_Genero.getText());
					mod.setDescricao(textPane_descricao.getText());
					mod.setPersonagens(textField_Personagens.getText());
					textField_Id.setText("");
					textField_nome.setText("");
					textField_Nota.setText("");
					textField_Personagens.setText("");
					textPane_descricao.setText("");
					textField_Genero.setText("");
					try {
						filme.AdicionarFilme(mod);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					mod.setId(Integer.parseInt(textField_Id.getText()));
					mod.setNome(textField_nome.getText());
					mod.setNotas(Integer.parseInt(textField_Nota.getText()));
					mod.setPersonagens(textField_Personagens.getText());
					mod.setDescricao(textPane_descricao.getText());
					mod.setGenero(textField_Genero.getText());
					textField_Id.setText("");
					textField_nome.setText("");
					textField_Nota.setText("");
					textField_Personagens.setText("");
					textPane_descricao.setText("");
					textField_Genero.setText("");
					try {
						filme.EditarFilme(mod);

					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}

			}
		});
		btnSalvar.setForeground(new Color(52, 54, 58));
		btnSalvar.setBackground(new Color(243, 156, 18));
		btnSalvar.setBounds(200, 380, 89, 23);
		contentPane.add(btnSalvar);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				InterfaceMenu men = new InterfaceMenu();
				men.setVisible(true);
				dispose();

			}
		});
		btnVoltar.setForeground(new Color(52, 54, 58));
		btnVoltar.setBackground(new Color(243, 156, 18));
		btnVoltar.setBounds(300, 380, 89, 23);
		contentPane.add(btnVoltar);

		JButton bntExcluir = new JButton("Deletar");
		bntExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControleFilme c = new ControleFilme();
				try {
					c.excluirFilme(textField_Pesquisar.getText());
					textField_Id.setText("");
					textField_nome.setText("");
					textField_Nota.setText("");
					textField_Personagens.setText("");
					textPane_descricao.setText("");
					textField_Genero.setText("");

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		bntExcluir.setForeground(new Color(52, 54, 58));
		bntExcluir.setBackground(new Color(243, 156, 18));
		bntExcluir.setBounds(100, 380, 89, 23);
		contentPane.add(bntExcluir);

	}

	public void ListarFilmes(String Sql) {
		ArrayList dados = new ArrayList();
		String[] colunas = new String[] { "ID", "Nome", "Notas", "Personagens", "Descricao", "Genero" };
		conexao.conexao();
		conexao.executaSql(Sql);
		try {
			conexao.rs.first();
			do {
				dados.add(new Object[] { conexao.rs.getInt("id"), conexao.rs.getString("nome"),
						conexao.rs.getInt("notas"), conexao.rs.getString("personagens"),
						conexao.rs.getString("descricao"), conexao.rs.getString("genero_do_filme") });
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

}
