package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TesteConexao {

	public static void main(String[] args) throws SQLException {

		// Observação todos os dados passados precisão estar ligados ao sql.
		// o mais importante é a Porta

		final String Url = "jdbc:mysql://localhost?verifyServerCertificate=false&useSSL=true"; // serve para entrar em
																								// contato com o
																								// servidor do Mysql
		final String usuario = "root"; // o usuario do Mysql
		final String senha = "909012345"; // e a senha

		// Connection serve para fazer a conexão
		// o DriverManager server para passar o acesso ao Mysql

		Connection conexao = DriverManager.getConnection(Url, usuario, senha);

		System.out.println("Conexão efetuada com sucesso");
		conexao.close();
	}

}
