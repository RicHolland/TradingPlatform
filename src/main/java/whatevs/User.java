package whatevs;

import java.io.Serializable;

public class User implements Serializable{

	private String username;
	private String password;
	//private transient String confirmpsswd;
	private String firstName;
	private String lastName;

	public void setUsername(String usrnm){
		username = usrnm;
	}

	public String getUsername(){
		return username;
	}

	public void setPassword(String psswd){
		password = psswd;
	}

	public String getPassword(){
		return password;
	}

/*	public void setConfirmPsswd(String cp){
		confirmpsswd = cp;
	}

	public String getConfirmPsswd(){
		return confirmpsswd;
	}
*/
	public void setFirstName(String fstnm){
		username = fstnm;
	}

	public String getFirstName(){
		return firstName;
	}

	public void setLastName(String lstnm){
		username = lstnm;
	}

	public String getLastName(){
		return lastName;
	}

}
