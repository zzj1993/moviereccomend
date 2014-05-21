package controller;

public class User {
	
	private int UsersID;
	private String NickName;
	private String Password;
	private String Email;
	
	public User() {
		super();
	}
	
	public User(int usersID, String nickName, String password, String email) {
		super();
		UsersID = usersID;
		NickName = nickName;
		Password = password;
		Email = email;
	}

	public int getUsersID() {
		return UsersID;
	}

	public void setUsersID(int usersID) {
		UsersID = usersID;
	}

	public String getNickName() {
		return NickName;
	}

	public void setNickName(String nickName) {
		NickName = nickName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

}
