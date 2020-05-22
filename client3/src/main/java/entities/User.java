package entities;

public class User {
	
	int id;
	String username;
	String password;
	int caloric_goal;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getCaloric_goal() {
		return caloric_goal;
	}
	public void setCaloric_goal(int caloric_goal) {
		this.caloric_goal = caloric_goal;
	}

}
