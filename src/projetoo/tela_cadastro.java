package projetoo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class tela_cadastro extends JFrame {

	private JPanel contentPane;
	private JTextField tfUsuario;
	private JTextField tfSenha;
	private JTextField tfId;

	private JButton btnCadas;
	private JButton btnDeletar;
	private JPanel panel_1;
	private JButton btnAbrir;
	private JTextField tfBusca;
	private JTable tbDados;
	private JButton btnListardados;
	private JButton btnAtualizar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tela_cadastro frame = new tela_cadastro();
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
	public tela_cadastro() {
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("id");
		lblNewLabel.setBounds(44, 34, 46, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Paciente:");
		lblNewLabel_1.setBounds(44, 84, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Convenio:");
		lblNewLabel_2.setBounds(44, 133, 61, 14);
		getContentPane().add(lblNewLabel_2);
		
		
		

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 414, 549);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel1 = new JLabel("Paciente:");
		lblNewLabel1.setFont(new Font("Georgia", Font.PLAIN, 16));
		lblNewLabel1.setBounds(47, 87, 92, 33);
		contentPane.add(lblNewLabel1);
		
		JLabel lblConvenio = new JLabel("Convenio:");
		lblConvenio.setFont(new Font("Georgia", Font.PLAIN, 16));
		lblConvenio.setBounds(47, 138, 92, 33);
		contentPane.add(lblConvenio);
		
		tfUsuario = new JTextField();
		tfUsuario.setBackground(new Color(231, 242, 250));
		tfUsuario.setBounds(132, 95, 155, 20);
		contentPane.add(tfUsuario);
		tfUsuario.setColumns(10);
		
		tfSenha = new JTextField();
		tfSenha.setBackground(new Color(231, 242, 250));
		tfSenha.setColumns(10);
		tfSenha.setBounds(132, 146, 155, 20);
		contentPane.add(tfSenha);
		
		JLabel lblNewLabel_11 = new JLabel("Numero º");
		lblNewLabel_11.setFont(new Font("Georgia", Font.PLAIN, 16));
		lblNewLabel_11.setBounds(47, 52, 70, 14);
		contentPane.add(lblNewLabel_11);
		
		tfId = new JTextField();
		tfId.setBackground(new Color(176, 196, 222));
		tfId.setBounds(132, 51, 78, 20);
		contentPane.add(tfId);
		tfId.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "A\u00E7\u00F5es", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(new Color(100, 149, 237));
		panel.setBounds(10, 347, 377, 78);
		contentPane.add(panel);
		panel.setLayout(null);
		
		btnCadas = new JButton("Cadastrar");
		btnCadas.setBackground(new Color(240, 255, 255));
		btnCadas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(tfUsuario.getText().equals("") || tfSenha.getText().equals("")) {
					
					JOptionPane.showMessageDialog(null, "Usuario ou senha em branco.");
				}else {
					
				
					acoes ac = new acoes(tfUsuario.getText(), tfSenha.getText());
					
					
					ac.salvar();
					
				
				}	
			}	
		
		});
		btnCadas.setBounds(10, 22, 102, 33);
		panel.add(btnCadas);
		
		btnDeletar = new JButton("Deletar");
		btnDeletar.setBackground(new Color(240, 255, 255));
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tfUsuario.getText().equals("") || tfSenha.getText().equals("")) {
					
					JOptionPane.showMessageDialog(null, "Informe o Id.");
				}else {

					acoes ac = new acoes(Integer.parseInt(tfId.getText()));
					
					ac.deletar();
				
			}		
			}
		});
		btnDeletar.setBounds(266, 23, 102, 31);
		panel.add(btnDeletar);
		
		btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBackground(new Color(240, 255, 255));
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(tfId.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Informe o id");
				}else {	
				
					acoes ac = new acoes(Integer.parseInt(tfId.getText()), tfUsuario.getText(), tfSenha.getText());
					
					ac.atualizar();
					
			}	
			}
		});
		btnAtualizar.setBounds(149, 22, 89, 33);
		panel.add(btnAtualizar);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Dados paciente", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBackground(new Color(100, 149, 237));
		panel_1.setBounds(10, 436, 377, 50);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		btnAbrir = new JButton("Consultar");
		btnAbrir.setBackground(new Color(240, 255, 255));
		btnAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(tfBusca.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Informe o id");
				}else {	
				
					try {	
						
						Connection con = conexão_bd.faz_conexao();
						String sql = "Select *from dados where id like ?";
						PreparedStatement stmt = con.prepareStatement(sql);
						
						stmt.setString(1,"%"+tfBusca.getText());
						
						ResultSet rs = stmt.executeQuery();
						
						while(rs.next()) {
							tfId.setText(rs.getString("id"));
							tfUsuario.setText(rs.getString("nome"));
							tfSenha.setText(rs.getString("senha"));
						}
						
						
						
						rs.close();
						con.close();
						
						
						

						
					}catch (SQLException e1) {
						
						e1.printStackTrace();
						
					}
			}	
			}
		});
		btnAbrir.setBounds(10, 16, 89, 23);
		panel_1.add(btnAbrir);
		
		tfBusca = new JTextField();
		tfBusca.setBackground(new Color(231, 242, 250));
		tfBusca.setBounds(102, 17, 89, 20);
		panel_1.add(tfBusca);
		tfBusca.setColumns(10);
		
		btnListardados = new JButton("Listar dados");
		btnListardados.setBackground(new Color(240, 255, 255));
		btnListardados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {	
					
					Connection con = conexão_bd.faz_conexao();
					String sql = "Select *from dados";
					PreparedStatement stmt = con.prepareStatement(sql);
					
					
					
					ResultSet rs = stmt.executeQuery();
					
					DefaultTableModel modelo = (DefaultTableModel) tbDados.getModel();
					modelo.setNumRows(0);
					
					
					while(rs.next()) {
						modelo.addRow(new Object[]{rs.getString("id"), rs.getString("nome"), rs.getString("senha")});
					}
					
						
					rs.close();
					con.close();
					
				}catch (SQLException e1) {
					
					e1.printStackTrace();
					
				}
				
				
				
			}
		});
		btnListardados.setBounds(246, 16, 121, 23);
		panel_1.add(btnListardados);
		

		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 245, 377, 91);
		contentPane.add(scrollPane);
		
		tbDados = new JTable();
		tbDados.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Nome", "Senha"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(tbDados);
		
		
	}
}
