package Model;


public class RegistrationModel {
private String username;
private String email;
private String password;


public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public RegistrationModel(){
	
}
public RegistrationModel(String username, String email, String password) {
	this.username = username;
	this.email = email;
	this.password = password;
}
@Override
public String toString() {
	return "RegistrationModel [username=" + username + ", email=" + email + ", password=" + password + "]";
}
 

}
