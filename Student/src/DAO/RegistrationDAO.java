package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Model.RegistrationModel;


public class RegistrationDAO {
	
		//RegistrationModel rm = new RegistrationModel();
	public int registrationMethod(RegistrationModel tt){
		int i=0;
		Connection con;
		DBconnect DB=new DBconnect();
		con=DB.getConnection();
		try{
		//get connection
		
		
		//create query
		PreparedStatement stmt = con.prepareStatement("insert into register values(?,?,?)");
		//set values to DB values
		stmt.setString(1, tt.getUsername());
		stmt.setString(2, tt.getEmail());
		stmt.setString(3, tt.getPassword());
		
		//execute query
	    i=stmt.executeUpdate();
		
	}
	 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	finally{
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		return i;

	}
}
