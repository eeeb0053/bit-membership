package user;

public class UserDTO {
	private String userid, name, password;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String toString() {
		return "사용자정보 [아이디=" + userid + ", 이름=" + name + ", 비밀번호=" + password + "]";
	}
}
