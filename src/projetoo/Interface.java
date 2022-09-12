package projetoo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Interface extends JFrame {

	private JPanel contentPane;
	private JTextField tfUsuario;
	private JPasswordField pfSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface frame = new Interface();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Interface() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 330, 361);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Georgia", Font.PLAIN, 18));
		lblNewLabel.setBounds(27, 63, 78, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Georgia", Font.PLAIN, 18));
		lblSenha.setBounds(27, 128, 78, 32);
		contentPane.add(lblSenha);
		
		tfUsuario = new JTextField();
		tfUsuario.setBackground(new Color(231, 242, 250));
		tfUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfUsuario.setBounds(115, 70, 133, 20);
		contentPane.add(tfUsuario);
		tfUsuario.setColumns(10);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBackground(new Color(240, 255, 255));
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				try {
					
					Connection con = conexão_bd.faz_conexao();
					String sql = "Select *from dados where nome=? and senha=?";
					PreparedStatement stmt = con.prepareStatement(sql);
					
					stmt.setString(1, tfUsuario.getText());
					stmt.setString(2, new String(pfSenha.getPassword()));
					
					ResultSet rs = stmt.executeQuery();
					
					if(rs.next()) {
						
						tela_cadastro exibir = new tela_cadastro();
						exibir.setVisible(true);		
						setVisible(false);
						
						
					}else {
						
						JOptionPane.showMessageDialog(null, "Esse usuario nao existe");
					}
					
					stmt.close();
					con.close();
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
			}
		});
		btnEntrar.setBounds(134, 182, 89, 23);
		contentPane.add(btnEntrar);
		
		pfSenha = new JPasswordField();
		pfSenha.setBackground(new Color(231, 242, 250));
		pfSenha.setBounds(115, 136, 133, 23);
		contentPane.add(pfSenha);
	}
}
