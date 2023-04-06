package it.polito.tdp.anagrammi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DizionarioDAO {
	
	public boolean findOut(String parola) {
		String sql = "SELECT nome FROM parola WHERE nome=?";
		
		Connection conn = ConnectionDB.getConnection();
		
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, parola);
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				if(rs.getString("nome")!=null)
					return true;
			}
			
			rs.close();
			st.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}

}
