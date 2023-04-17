package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {
	/** Módulo de conexão **/
	// Parâmetros de conexão

	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/dbagenda?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "aluno123";
	// Métodos de conexão

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

	/** CRUDE CREATE **/
	public void inserirContato(JavaBeans contato) {
		String create = "INSERT INTO contatos (nome,fone,email) VALUES (?,?,?)";
		try {
			// Abrir conexao
			Connection con = conectar();

			// Preparar a query para execução no banco de dados
			PreparedStatement pst = con.prepareStatement(create);

			// Substituir os parâmetros (?) pelo oconteúdo das variáveis JavaBeans.
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getFone());
			pst.setString(3, contato.getEmail());
			// Executar a query
			pst.executeUpdate();

			// Encerrar a conexão com o Banco
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * teste de conexão public void testeConexao() { try { Connection con =
	 * conectar(); System.out.println(con); con.close(); } catch (Exception e) {
	 * System.out.println(e); }
	 * 
	 * }
	 **/

	/** CRUD READ **/

	public ArrayList<JavaBeans> listarContatos() {
		// Criando um objeto para acessar a classe JavaBeans
		ArrayList<JavaBeans> contatos = new ArrayList<>();

		String read = "SELECT * FROM contatos ORDER BY nome";
		try {

			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			
			// O laço abaixo será executado enquanto houver contatos
			while (rs.next()) {
				// variáveis de apoio que recebem os dados do banco
				String idcon = rs.getString(1);
				String nome = rs.getString(2);
				String fone = rs.getString(3);
				String email = rs.getString(4);
				// Populando a Array list
				contatos.add(new JavaBeans(idcon, nome, fone, email));

			}
			con.close();
			return contatos;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
}
