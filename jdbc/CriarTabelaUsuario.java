package jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarTabelaUsuario {
	
	public static void main(String[] args) throws SQLException {
		Connection conexao = FabricaConexao.getConexao();
		
		String sql = "CREATE TABLE IF NOT EXISTS Pessoas ("
				+"codigo INT AUTO_INCREMENT PRIMARY KEY,"
				+"Nome VARCHAR(225) NOT NULL"
				+")"; 
		
		
	// intrepretador de SQL
		Statement stmt = conexao.createStatement();
		stmt.execute(sql);
		
		System.out.println("Tabela Criada com sucesso!");
		
		conexao.close();
		
	}

}
