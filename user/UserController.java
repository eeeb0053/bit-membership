package user;

public class UserController {
	private UserService userService;

	public UserController() {
		userService = new UserServiceImpl();
	}

	public void postJoin(UserDTO user) {
		userService.join(user);
	}

	public UserDTO postLogin(UserDTO user) {
		return userService.login(user);
	}

	public void putPassword(UserDTO user) {
		userService.updatePassword(user);
	}
	
	public void deleteUser(UserDTO user) {
		userService.deleteUser(user);
	}

	public boolean getExistId(String id) {
		return userService.existId(id);
	}

	public UserDTO getUser(UserDTO user) {
		return userService.mypage(user);
	}

	public UserDTO[] getUserList() {
		return userService.userList();
	}

	public UserDTO getById(String id) {
		return userService.searchId(id);	
	}
	
	public int getCountSameName(String name) {
		return userService.countSameName(name);
	}

	public UserDTO[] getByName(String name) {
		return userService.searchName(name);
	}

	public int getCount() {
		return userService.userCount();
	}
}