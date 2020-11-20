package user;

public class UserServiceImpl implements UserService{
	private UserDTO[] users;
	private int count;
	
	public UserServiceImpl() {
		users = new UserDTO[3];
		count = 0;
	}
	
	public void join(UserDTO user) {
		users[count] = user;
		count++;
	}

	public UserDTO login(UserDTO user) {
		UserDTO result = null;
		for(int i = 0; i < count; i++) {
			if(user.getUserid().equals(users[i].getUserid()) &&
					user.getPassword().equals(users[i].getPassword())) {
				result = users[i];
				break;
			}
		}
		return result;
	}

	public void updatePassword(UserDTO user) {
		for(int i = 0; i < count; i++) {
			if(user.getUserid().equals(users[i].getUserid())) {
				users[i].setPassword(user.getPassword());
				break;
			}
		}
	}

	public void deleteUser(UserDTO user) {
		for(int i = 0; i < count; i++) {
			if(user.getUserid().equals(users[i].getUserid()) &&
					user.getPassword().equals(users[i].getPassword())) {
				users[i] = users[count-1];
				users[count-1] = null;
				count--;
				break;
			}
		}
	}

	public boolean existId(String id) {
		for(int i = 0; i < count; i++) {
			if(id.equals(users[i].getUserid())) {
				return false;
			}
		}
		return true;
	}

	public UserDTO mypage(UserDTO user) {
		UserDTO result = new UserDTO();
		for(int i = 0; i < count; i++) {
			if(user.getUserid().equals(users[i].getUserid()) &&
					user.getPassword().equals(users[i].getPassword())) {
				result = users[i];
				break;
			}
		}
		return result;
	}

	public UserDTO[] userList() {
		return users;
	}

	public UserDTO searchId(String id) {
		UserDTO user = new UserDTO();
		for(int i = 0; i < count; i++) {
			if(id.equals(users[i].getUserid())) {
				user = users[i];
				break;
			}
		}
		return user;
	}

	public int countSameName(String name) {
		int num = 0;
		for(int i = 0; i < count; i++) {
			if(name.equals(users[i].getName())) {
				num++;
			}
		}
		return num;
	}
	
	public UserDTO[] searchName(String name) {
		int num= countSameName(name);
		UserDTO[] usersWithSameName = null;
		if(num != 0) {
			usersWithSameName = new UserDTO[num];
		}
		int j = 0;
		for(int i = 0; i < count; i++) {
			if(name.equals(users[i].getName())) {
				usersWithSameName[j] = users[i];
				j++;
				if(j == num) {break;}
			}
		} 
		return usersWithSameName;
	}

	public int userCount() {
		return count;
	}

}
