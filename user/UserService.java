package user;

public interface UserService {
	public void join(UserDTO user);
	public UserDTO login(UserDTO user);
	public void editPassword(UserDTO user);
	public void deleteUser(UserDTO user);
	public boolean existId(String id);
	public UserDTO mypage(UserDTO user);
	public UserDTO[] userList();
	public UserDTO searchId(String id);
	public UserDTO[] searchName(String name);
	public int userCount();
}
