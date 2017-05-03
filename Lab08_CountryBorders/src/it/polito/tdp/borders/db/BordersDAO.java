package it.polito.tdp.borders.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.borders.model.Border;
import it.polito.tdp.borders.model.Country;

public class BordersDAO {

	public List<Country> loadAllCountries() {
		List<Country> countries = new ArrayList<Country>();

		String sql = "SELECT ccode,StateAbb,StateNme " + "FROM country " + "ORDER BY StateAbb ";

		try {
			Connection conn = DBConnect.getInstance().getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String abb = rs.getString("StateAbb");
				String id = rs.getString("StateNme");
				countries.add(new Country(abb,id));
			}

			conn.close();
			return countries;

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Database Error -- loadAllCountries");
			throw new RuntimeException("Database Error");
		}
	}

	public List<Border> getCountryPairs(int anno) {
		
		List<Border> borders = new ArrayList<>();
		
		String sql = "SELECT state1ab,state2ab FROM contiguity WHERE year<=? AND conttype=1";
		
		
		try {
			Connection connection = DBConnect.getInstance().getConnection() ;
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, anno);
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				String abb1 = rs.getString("state1ab");
				String abb2 = rs.getString("state2ab");
				borders.add(new Border(new Country("",abb1),new Country("",abb2)));
			}

			connection.close();
			return borders ;
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Database Error -- loadAllCountries");
			throw new RuntimeException("Database Error");

		}
		
	}
}
