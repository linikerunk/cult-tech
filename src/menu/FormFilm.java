package menu;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import tipografia.Fonte;
import javax.swing.JButton;
public class FormFilm {

private JFrame frame;
private JTextField textField;
private JTextField textField_1;
private JTextField textField_2;

/**
 * Launch the application.
 */
public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
        public void run() {
            try {
                FormFilm window = new FormFilm();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    });
}

Fonte tipoFonte;
public FormFilm() {
    initialize();
}

/**
 * Initialize the contents of the frame.
 */
private void initialize() {
    frame = new JFrame();
    frame.getContentPane().setBackground(Color.DARK_GRAY);
    frame.getContentPane().setLayout(null);

    JLabel lblNome = new JLabel("Nome");
    lblNome.setForeground(Color.ORANGE);
    lblNome.setBackground(Color.ORANGE);
    lblNome.setBounds(24, 43, 46, 14);
    frame.getContentPane().add(lblNome);

    JLabel lblNota = new JLabel("Nota");
    lblNota.setForeground(Color.ORANGE);
    lblNota.setBounds(24, 18, 46, 14);
    frame.getContentPane().add(lblNota);

    JLabel lblNewLabel = new JLabel("Personagens");
    lblNewLabel.setForeground(Color.ORANGE);
    lblNewLabel.setBounds(24, 68, 94, 14);
    frame.getContentPane().add(lblNewLabel);

    JLabel lblDesc = new JLabel("Descri\u00E7\u00E3o");
    lblDesc.setForeground(Color.ORANGE);
    lblDesc.setBounds(24, 113, 79, 14);
    frame.getContentPane().add(lblDesc);

    JTextPane textPane = new JTextPane();
    textPane.setBounds(139, 93, 243, 74);
    frame.getContentPane().add(textPane);

    textField = new JTextField();
    textField.setBounds(139, 65, 243, 25);
    frame.getContentPane().add(textField);
    textField.setColumns(10);

    textField_1 = new JTextField();
    textField_1.setBounds(139, 40, 243, 20);
    frame.getContentPane().add(textField_1);
    textField_1.setColumns(10);

    JSlider slider = new JSlider();
    slider.setMaximum(5);
    slider.setBackground(Color.ORANGE);
    slider.setForeground(Color.ORANGE);
    slider.setBounds(139, 18, 243, 14);
    frame.getContentPane().add(slider);

    JLabel lblGenero = new JLabel("Genero");
    lblGenero.setForeground(Color.ORANGE);
    lblGenero.setBackground(Color.ORANGE);
    lblGenero.setBounds(24, 196, 46, 14);
    frame.getContentPane().add(lblGenero);

    textField_2 = new JTextField();
    textField_2.setBounds(139, 193, 236, 25);
    frame.getContentPane().add(textField_2);
    textField_2.setColumns(10);

    JButton btnSalvar = new JButton("Salvar");
    btnSalvar.setForeground(Color.DARK_GRAY);
    btnSalvar.setBackground(Color.ORANGE);
    btnSalvar.setBounds(102, 229, 89, 23);
    frame.getContentPane().add(btnSalvar);

    JButton btnVoltar = new JButton("Voltar");
    btnVoltar.setForeground(Color.DARK_GRAY);
    btnVoltar.setBackground(Color.ORANGE);
    btnVoltar.setBounds(238, 229, 89, 23);
    frame.getContentPane().add(btnVoltar);
    frame.setBounds(100, 100, 450, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}