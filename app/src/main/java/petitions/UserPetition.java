package petitions;

import java.io.Serializable;

public class UserPetition implements Serializable{
	String user;
	String pass;
	private static final long serialVersionUID = 1L;

	public UserPetition(String user, String pass) {
		this.user = user;
		this.pass = pass;
	}

	public String getUser() {
		return user;
	}

	public String getPass() {
		return pass;
	}
}
