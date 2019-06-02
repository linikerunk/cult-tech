package Viewer;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;

import tipografia.Fonte;


// Classe de interface do menu da aplicação

public class InterfaceMenu extends JFrame {

	private JPanel contentPane;
	ImageIcon logo = new ImageIcon(getClass().getResource("/Imagens/LogoMenu.png"));

	// Método que inicia a aplicação

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceMenu frame = new InterfaceMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Fonte tipoFonte;

	public InterfaceMenu() {
		tipoFonte = new Fonte();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBackground(new Color(52, 54, 58));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JSeparator separator = new JSeparator();
		separator.setBounds(25, 172, 462, -40);
		contentPane.add(separator);

		
		JLabel lblLogo = new JLabel(logo);
		lblLogo.setBounds(220, 0, 110, 110);
		contentPane.add(lblLogo);
		

		JButton btFilms = new JButton("Filmes");
		btFilms.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FormFilm filme = new FormFilm();
				filme.setVisible(true);
				setVisible(false);
				
				
			}
		});
		btFilms.setFont(tipoFonte.fonte(tipoFonte.Big, 0, 10));
		btFilms.setBackground(new Color(243, 156, 18));
		btFilms.setBounds(230, 105, 90, 23);
		contentPane.add(btFilms);

		JButton btnBook = new JButton("Livros");
		btnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnBook.setFont(tipoFonte.fonte(tipoFonte.Big, 0, 10));
		btnBook.setBackground(new Color(243, 156, 18));
		btnBook.setBounds(230, 135, 90, 23);
		contentPane.add(btnBook);

		JButton btnMusic = new JButton("Músicas");
		btnMusic.setBounds(230, 165, 90, 23);
		contentPane.add(btnMusic);
		btnMusic.setFont(tipoFonte.fonte(tipoFonte.Big, 0, 10));
		btnMusic.setBackground(new Color(243, 156, 18));

		JButton btnSerie = new JButton("Séries");
		btnSerie.setBounds(230, 195, 90, 23);
		contentPane.add(btnSerie);
		btnSerie.setFont(tipoFonte.fonte(tipoFonte.Big, 0, 10));
		btnSerie.setBackground(new Color(243, 156, 18));

		JButton btnAnime = new JButton("Animes");
		btnAnime.setBounds(230, 225, 90, 23);
		contentPane.add(btnAnime);
		btnAnime.setFont(tipoFonte.fonte(tipoFonte.Big, 0, 10));
		btnAnime.setBackground(new Color(243, 156, 18));

	}
}