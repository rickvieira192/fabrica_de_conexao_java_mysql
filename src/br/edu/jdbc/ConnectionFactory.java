package br.edu.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

	//Construtor declarado como privado assim evitando criar instâncias na fábrica
	private ConnectionFactory() {
		throw new UnsupportedOperationException();
	}
	
	// Não esquecer de baixar o driver 

	public static Connection getConnection() {

		
		//Declarar objeto conexão (Irá receber uma conexão após os passos abaixo)
		Connection connection = null;

		//Carregar arquivos do properties para pegar os arquivos necessários para se comunicar com o banco de dados
		try (InputStream input = ConnectionFactory.class.getClassLoader()
				.getResourceAsStream("connection.properties")) {


			//Definier parametros para se conectar ao banco de dados 
			Properties prop = new Properties();
			prop.load(input);

			String driver = prop.getProperty("jdbc.driver");
			String dataBaseAdress = prop.getProperty("db.adress");
			String dataBaseName = prop.getProperty("db.name");
			String user = prop.getProperty("db.user.login");
			String password = prop.getProperty("db.user.password");

			// CONSTRUÇÃO DA STRING DE CONEXÃO
            StringBuilder sb = new StringBuilder("jdbc:").append(driver).append("://").append(dataBaseAdress)
					.append("/").append(dataBaseName);

			String connectionurl = sb.toString(); //sb.toString = "jdbc:mysql://localhost:3306/db_digital_innovation/" ||"jdbc:mysql://127.0.0.1:3306/db_digital_innovation/"

			
			//Criar conexão usando DriverManager, passando como parametros a string conexao,usuario e senha
			try {
				connection = DriverManager.getConnection(connectionurl, user, password);
			} catch (SQLException e) {
				System.out.println("Falha ao se conectar ao banco");
				throw new RuntimeException(e);
			}

		} catch (IOException e) {
			System.out.println("Falha ao se conectar ao banco");
			e.printStackTrace();

		}

		return connection;

	}
}