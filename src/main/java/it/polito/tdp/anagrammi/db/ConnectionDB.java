package it.polito.tdp.anagrammi.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
	
	public static Connection getConnection() {
		String s = "jdbc:mysql://localhost/dizionario?user=root&password=root";
		try {
			Connection connection = DriverManager.getConnection(s);
			return connection;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Errore connessione db");
			return null;
		}
		
	}

}
