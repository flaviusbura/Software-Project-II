package be.nmbs.userInterface;


import java.sql.*;
import java.sql.Connection;

public class PersoonDAO2 {

	
	public Persoon getPersoon(int nr)
	{
		
		Persoon s = new Persoon();
		s.nr = 2;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://dt5.ehb.be/SP2G8","SP2G8","Groep8");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from gebruiker");
			rs.next();
			String name = rs.getString("voornaam");
			System.out.println(name);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return s;
	}
}
