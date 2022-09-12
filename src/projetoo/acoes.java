package projetoo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class acoes {
	private int id;
	private String nome;
	private String senha;
	
	public acoes(int id_p) {
		this.id = id_p;
	}
	
	public acoes(String nm, String se) {
		this.nome = nm;
		this.senha = se;
	}
	
	public acoes(int id_p, String nm, String se) {
		this.id = id_p;
		this.nome = nm;
		this.senha = se;
	}
	
	public void salvar() {
		
		try {	
			
			Connection con = conexão_bd.faz_conexao();
			String sql = "insert into dados(nome, senha) values (?,?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1, nome);
			stmt.setString(2, senha);
			
			stmt.execute();
			
			stmt.close();
			con.close();
			
			JOptionPane.showMessageDialog(null, "Paciente cadastrado!");
			
			
			
		}catch (SQLException e1) {
			
			e1.printStackTrace();
			
		}
	}
	
	public void atualizar() {
		try {	
			
			Connection con = conexão_bd.faz_conexao();
			String sql = "UPDATE dados set nome=?, senha=? where id=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1, nome);
			stmt.setString(2, senha);
			stmt.setInt(3, id);
			
			
			stmt.execute();
			
			
			stmt.close();
			con.close();
			
			JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
			
		}catch (SQLException e1) {
			
			e1.printStackTrace();
			
		}
		
	}
	
	public void deletar() {
		
		try {	
			
			Connection con = conexão_bd.faz_conexao();
			String sql = "DELETE from dados where id=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setInt(1, id);
			
			
			
			
			stmt.execute();
			stmt.close();
			con.close();
			
			
			
			JOptionPane.showMessageDialog(null, "Paciente excluido!");
			
		}catch (SQLException e1) {
			
			e1.printStackTrace();
			
		}
	}
	
}
