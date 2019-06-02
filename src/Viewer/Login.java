package Viewer;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Controler.ConexaoBD;
import tipografia.Fonte;

public class Login extends JFrame {
	private JPanel templateRun;
	private JTextField usuario;
	private JPasswordField senha;

	/**
	 * Método que cria a aplicação
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Fonte tipoFonte;
	ConexaoBD con = new ConexaoBD();
	ImageIcon logo = new ImageIcon(getClass().getResource("/Imagens/LogoLogin.png"));

	public Login() {
		tipoFonte = new Fonte();
		con.conexao();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 259);
		templateRun = new JPanel();
		templateRun.setBackground(new Color(52, 54, 58));
		templateRun.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(templateRun);
		templateRun.setLayout(null);

		JLabel lblTitle = new JLabel("Seja Bem Vindo");
		lblTitle.setBounds(60, 11, 300, 50);

		JLabel lblLogo = new JLabel(logo);
		lblLogo.setBounds(35, 50, 208, 150);
		templateRun.add(lblLogo);

		lblTitle.setFont(tipoFonte.fonte(tipoFonte.Big, 0, 35));
		lblTitle.setForeground(new Color(243, 156, 18));
		templateRun.add(lblTitle);

		JLabel lblLogin = new JLabel("Usuário:");
		lblLogin.setBounds(350, 83, 50, 14);
		lblLogin.setFont(tipoFonte.fonte(tipoFonte.Big, 0, 15));
		lblLogin.setForeground(new Color(243, 156, 18));
		templateRun.add(lblLogin);

		usuario = new JTextField();
		usuario.setBounds(400, 80, 115, 20);
		templateRun.add(usuario);

		JSeparator separator = new JSeparator();
		separator.setBounds(25, 172, 462, -40);
		templateRun.add(separator);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(350, 120, 60, 14);
		lblSenha.setFont(tipoFonte.fonte(tipoFonte.Big, 0, 15));
		lblSenha.setForeground(new Color(243, 156, 18));
		templateRun.add(lblSenha);

		senha = new JPasswordField();
		senha.setBounds(400, 120, 115, 20);
		templateRun.add(senha);

		JButton btnLogIn = new JButton("Entrar");

		btnLogIn.setBounds(350, 172, 83, 23);
		templateRun.add(btnLogIn);

		btnLogIn.setFont(tipoFonte.fonte(tipoFonte.Big, 0, 15));
		btnLogIn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					con.executaSql("select * from usuario where login = '" + usuario.getText() + "'");
					con.rs.first();

					if (con.rs.getString("senha").equals(String.valueOf(senha.getPassword()))) {
						InterfaceMenu menu = new InterfaceMenu();
						menu.setVisible(true);
						dispose();
					} else {
						JOptionPane.showMessageDialog(rootPane, "Senha ou usuario invalido");
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(rootPane, "Senha ou usuario invalido" + e2);
				}
			}
		});

		JButton btnVoltar = new JButton("Sair");
		btnVoltar.setBounds(450, 172, 83, 23);
		templateRun.add(btnVoltar);
		btnVoltar.setFont(tipoFonte.fonte(tipoFonte.Big, 0, 15));
		btnVoltar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});

	}

}
