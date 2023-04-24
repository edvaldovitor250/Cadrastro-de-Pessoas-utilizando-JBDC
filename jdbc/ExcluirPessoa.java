package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;


public class ExcluirPessoa {

	public static void main(String[] args) throws SQLException {
		
		Scanner entrada = new Scanner(System.in);
System.out.println("Informe o codigo: ");
		int codigo = entrada.nextInt();
		
		Connection conexao = FabricaConexao.getConexao();
		String sql = "DELETE FROM pessoas WHERE codigo = ?";
		
		PreparedStatement smtm = conexao.prepareStatement(sql);
		smtm.setInt(1, codigo);
		
		int contador = smtm.executeUpdate();
		
		if (contador > 0) {
			System.out.println("Pessoa excluidas com sucesso!");
		}else {
			System.out.println("Essa Pessoa não tem no Banco de Dados!");
		}
		System.out.println("Linhas afetadas: " + contador);
		
		conexao.close();
		entrada.close();
	}
	
}
