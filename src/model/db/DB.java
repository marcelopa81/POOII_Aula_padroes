package model.db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import jdbc.db;

public class DB {
	
private static Connection conexao;
	
	private static Properties getProperties() throws IOException {
		
		Properties propriedades = new Properties();
		FileInputStream file = new FileInputStream("./propriedades/db.properties");
		propriedades.load(file);
		return propriedades;
	}
	
	public static Connection getConexao() throws IOException, SQLException {
		if (conexao == null) {
			Properties p = DB.getProperties();
			conexao = DriverManager.getConnection(p.getProperty("host"), 
												  p.getProperty("user"), 
												  p.getProperty("password"));
		}
		return conexao;
	}
	
	public static void closeConexao() throws SQLException {
		if (conexao != null) {
			conexao.close();
		}
	}
}
