package DAO;

import java.sql.Connection;

import java.sql.SQLException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Model.CoursesModel;

public class CoursesDAO {
public int addCourses(CoursesModel coursesmodel){
	int i=0;
	Connection con;
	DBconnect db = new DBconnect();
	con = db.getConnection();
	try{
		PreparedStatement stmt = con.prepareStatement("insert into courses values(?,?,?)");
	//set model class values to DB values
    stmt.setString(1, coursesmodel.getCourseId());
	stmt.setString(2, coursesmodel.getCourseName());
	stmt.setString(3,coursesmodel.getCourseContent());
	
	/*= if (inputStream != null) {
         // fetches input stream of the upload file for the blob column
         stmt.setBlob(4, inputStream);
     }*/
	// sends the statement to the database server
     
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
public static String getCourseid(CoursesModel coursesmodel){
	String i="";
	ResultSet resultset = null;
	Connection con;
	DBconnect db = new DBconnect();
	con=db.getConnection();
	try{
		PreparedStatement stmt = con.prepareStatement("select COURSEID from courses where COURSENAME = '"+coursesmodel.getCourseName()+"'");
	    resultset=stmt.executeQuery();
	    
	    while(resultset.next()){
	    	i = resultset.getString("PASSWORD");
	    }
	}
	    catch(SQLException e){
	    	e.printStackTrace();
	    }
	finally{
	    	try{
	    		con.close();
	    	}catch(SQLException e){
	    		e.printStackTrace();
	    	}
	    }
	return i;
	
}
}
