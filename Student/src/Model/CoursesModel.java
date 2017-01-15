package Model;

public class CoursesModel {
private String courseId;
private String courseName;
private String courseContent;

public String getCourseId() {
	return courseId;
}
public void setCourseId(String courseId) {
	this.courseId = courseId;
}
public String getCourseName() {
	return courseName;
}
public void setCourseName(String courseName) {
	this.courseName = courseName;
}
public String getCourseContent() {
	return courseContent;
}
public void setCourseContent(String courseContent) {
	this.courseContent = courseContent;
}
public CoursesModel(){
	
}
public CoursesModel(String courseName, String courseContent) {
	this.courseName = courseName;
	this.courseContent = courseContent;
}
@Override
public String toString() {
	return "CoursesModel [courseName=" + courseName + ", courseContent=" + courseContent + "]";
}

}
