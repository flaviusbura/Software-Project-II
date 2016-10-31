package be.nmbs.userInterface;


import java.sql.*;
import java.sql.Connection;

public class PersoonDAO2 {

	
	public Persoon getPersoon(int nr)
	{
		
		Persoon s = new Persoon();
		
		try {
			
			Connection con = DriverManager.getConnection("jdbc:mysql://dt5.ehb.be/SP2G8","SP2G8","Groep8");
			PreparedStatement updateemp = con.prepareStatement
				      ("insert into gebruiker values(null,?,?,?,?,?,?,?,?,?)");
				      updateemp.setString(1,"man");
				      updateemp.setString(2, "1/1/1");
				      updateemp.setString(3, "Sam2");
				      updateemp.setString(4, "leirens");
				      updateemp.setInt(5,1);
				      updateemp.setString(6, "xd");
				      updateemp.setString(7, "xd");
				      updateemp.setString(8, "xd");
				      updateemp.setInt(9,1);
				      updateemp.executeUpdate();
				      Statement stmt = con.createStatement();
				      String query = "select * from gebruiker";
				      ResultSet rs =  stmt.executeQuery(query);
				      while (rs.next()) {
				         String name = rs.getString("voornaam");
				         System.out.println(name);
				      }      
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return s;
	}
}
