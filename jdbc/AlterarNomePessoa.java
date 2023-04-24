package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AlterarNomePessoa {

	public static void main(String[] args) throws SQLException {

		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Informe o codigo da pessoa: ");
		int codigo = entrada.nextInt();

		String selectSQL = "SELECT * FROM pessoas WHERE codigo = ?";
		String updateSQL= "UPDATE pessoas SET nome = ? Where codigo = ?";
		
		Connection conexao = FabricaConexao.getConexao();
		PreparedStatement stmt = conexao.prepareStatement(selectSQL);
		stmt.setInt(1, codigo);
		ResultSet r = stmt.executeQuery();
		
		if (r.next()) {
			Pessoa p = new Pessoa(r.getInt(1), r.getString(2));
			System.out.println("Seu nome atual é " + p.getNome());
			entrada.nextLine();
			
			System.out.println("Informe o novo nome da pessoa: ");
			String novonome = entrada.nextLine();
			
			stmt.close();
			stmt = conexao.prepareStatement(updateSQL);
			stmt.setString(1, novonome);
			stmt.setInt(2, codigo);
			stmt.execute();
			
			System.out.println("Nome alterada com sucesso!");	
		} else {
			System.out.println("Nome não encontrada!");
		}
		
		
		conexao.close();
		entrada.close();
	}
}
