package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySQL {
	
	private static String status = "STATUS: N�o conectado";
	private static Connection con = null;

	public ConexaoMySQL(){
		
	}
	
	public static Connection getConexao(){
		
		String servername = "localhost";
		String database = "mydb";
		String user = "root";
		String password = "SENHA";
		String url = "jdbc:mysql://"+servername+":3306/"+database;
		
		try {
			con=DriverManager.getConnection(url, user, password);
			if(con!=null){
				status="STATUS: Conectado.";
				System.out.println(status);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
		
	}
	
	public static boolean fecharConexao(){
		
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

}
