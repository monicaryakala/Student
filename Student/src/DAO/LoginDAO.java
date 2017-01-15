package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.LoginModel;



public class LoginDAO {

	public String ValidateLogin(String username) {
		LoginModel login=new LoginModel();
		String password ="";
		ResultSet rs = null;
		Connection c;
		DBconnect db = new DBconnect();
		c = db.getConnection();

		try {
			PreparedStatement ps = c.prepareStatement("select PASSWORD from register where USERNAME = '" + username+ "' ");
			rs = ps.executeQuery();
		    
			
			System.out.println(rs);
			while(rs.next())
			{
			 password=rs.getString("PASSWORD");
			 }
			 
			/* if(password.equals(password))
			 //{
				 return "SUCCESS";
			 }
			 else
			 {
				 System.out.println(rs);
					//return String ;
					return "invalid";
			 }
			}
			*/
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		return password;
		
	}
}
