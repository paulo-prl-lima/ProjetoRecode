package controller;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

	// Nome do usuário do mysql
	private static final String USERNAME = "root";

	// Senha do mysql
	private static final String PASSWORD = "root";

	// Dados de caminho, porta e nome da base dados que irá ser feita a conexao
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/turismo";

	public static Connection createConnectionToMySQL() throws Exception {

		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

		return connection;
	}

}
