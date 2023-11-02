package br.com.fiap.gestao.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		// Abrir a conexão com o banco
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl", "rm95003",
				"050703");
		return conn;
	}
}
