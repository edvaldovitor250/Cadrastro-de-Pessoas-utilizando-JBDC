package jdbc;

public class DAOteste1 {
	public static void main(String[] args) {
		
		DAO dao = new DAO();
	
		String sql = "INSERT INTO Pessoas (Nome) VALUES (?)";
	System.out.println(dao.incluir(sql, "Vitor"));
	dao.incluir(sql, "Caio");
		
	
	dao.close();
	}

}
