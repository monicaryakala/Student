package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Model.CoursesModel;
import Model.MaterialModel;

public class MaterialDAO {
public int fileupload(MaterialModel materialmodel,CoursesModel coursesmodel){
	int i = 0;
	Connection con;
	DBconnect db = new DBconnect();
	con = db.getConnection();
	try{
	PreparedStatement stmt = con.prepareStatement("insert into material values(?,?,?,?,?)");
	//setting the values to the database columns
	stmt.setString(1, materialmodel.getField());
	stmt.setString(2, materialmodel.getFilename());
	stmt.setBlob(3, materialmodel.getInputstream());
	stmt.setString(4, materialmodel.getContenttype());
	stmt.setString(5, CoursesDAO.getCourseid(coursesmodel));
	i = stmt.executeUpdate();
	}catch(SQLException e){
		e.printStackTrace();
	}finally{
		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	return i;
}
}