package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class DAO {

	private Connection conexao;
	
	public int incluir(String sql, Object... atributos) {
		try {
			PreparedStatement stmt = getConnection().prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
			adicionarAtributos(stmt, atributos);
		
		if (stmt.executeUpdate() > 0) {
			ResultSet resultado = stmt.getGeneratedKeys();
			
			if (resultado.next()) {
				return resultado.getInt(1);
				
			}
		}
		
		return -1;
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
		public  void close() {
			try {
				getConnection().close();
				
			} catch (SQLException e) {
			} finally {
				conexao = null;
			}
	}
	int indice = 1;
	private void adicionarAtributos(PreparedStatement stmt, Object[] atributos) throws SQLException {
		for (Object atributo: atributos) {
if (atributo instanceof String) {
	stmt.setString(indice,(String) atributo);
}else if (atributo instanceof Integer) {
	stmt.setInt(indice,(Integer) atributo);

}
		
		
		
		}
	}
	
	private Connection getConnection()  {
		try {
			if (conexao != null && !conexao.isClosed()) {
				return conexao;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		conexao = FabricaConexao.getConexao();
		return conexao;
	}
}
