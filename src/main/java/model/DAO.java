package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {
/** Módulo de conexão**/
	//Parâmetros de conexão
	
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/dbagenda?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "aluno123";
	//Métodos de conexão
	
	private Connection conectar() {
		Connection con = null;
	try {
		Class.forName(driver);
		con = DriverManager.getConnection(url, user, password);
		return con;
	} catch (Exception e) {
		System.out.println(e);
		return null;
		}
	}
	
	/**CRUDE CREATE**/ 
	public void inserirContato(JavaBeans contato) {
		String create ="insert into contatos (nome,fone,email) values (?,?,?)";
		try {
			//abrir conexao
			Connection con = conectar();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	/**teste de conexão
	public void testeConexao() {
		try {
			Connection con = conectar();
			System.out.println(con);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		 
	}**/
}
