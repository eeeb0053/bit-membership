package viewer;

import java.util.Scanner;

import user.UserController;
import user.UserDTO;

public class UserMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		UserController controller = new UserController();
		UserDTO user = null;
		
		
		while(true) {
			System.out.print("Menu: 1.회원가입 2.로그인 3.비밀번호 수정 4.회원탈퇴 5.아이디 중복체크 "
					+ "\n6.마이페이지 7.회원목록 8.아이디검색 9.이름검색 10.전체 회원수 0.종료 \n>> ");
			switch (scanner.next()) {
			case "1":
				user = new UserDTO();
				System.out.print("[회원가입]\n이름 >> ");
				user.setName(scanner.next());
				System.out.print("아이디 >> ");
				user.setUserid(scanner.next());
				System.out.print("비밀번호 >> ");
				user.setPassword(scanner.next());
				controller.postJoin(user);
				break;
			case "2":
				user = new UserDTO();
				System.out.print("[로그인]\n아이디 >> ");
				user.setUserid(scanner.next());
				System.out.print("비밀번호 >> ");
				user.setPassword(scanner.next());
				UserDTO loginUser = controller.postLogin(user);
				if(loginUser == null) {
					System.out.println("로그인 실패");
				}else {
					System.out.println(loginUser.toString());					
				}
				break;
			case "3":
				user = new UserDTO();
				System.out.print("[비밀번호 변경]\n아이디 >> ");
				user.setUserid(scanner.next());
				System.out.print("변경할 비밀번호 >> ");
				user.setPassword(scanner.next());
				controller.putPassword(user);
				break;
			case "4":
				user = new UserDTO();
				System.out.print("[회원탈퇴]\n아이디 >> ");
				user.setUserid(scanner.next());
				System.out.print("비밀번호 >> ");
				user.setPassword(scanner.next());
				controller.deleteUser(user);
				break;
			case "5":
				System.out.print("[아이디 중복체크]\n아이디 >> ");
				boolean exist = controller.getExistId(scanner.next());
				if(exist) {
					System.out.println("사용 가능한 아이디입니다.");
				}else {
					System.out.println("이미 존재하는 아이디입니다.");
				}
				break;
			case "6":
				user = new UserDTO();
				System.out.print("[마이페이지]\n아이디 >> ");
				user.setUserid(scanner.next());
				System.out.print("비밀번호 >> ");
				user.setPassword(scanner.next());
				UserDTO mypage = controller.getUser(user);
				if(mypage == null) {
					System.out.println("존재하지 않습니다.");
				}else {
					System.out.printf("이름: %s 아이디: %s 비밀번호: %s\n", 
							mypage.getName(), mypage.getUserid(), mypage.getPassword());
				}
				break;
			case "7":
				System.out.println("[회원목록]");
				UserDTO[] list = controller.getUserList();
				for(int i = 0; i < controller.getCount(); i++) {
					System.out.println(list[i].toString());
				}
				break;
			case "8":
				System.out.print("[아이디 검색]\n아이디 >> ");
				UserDTO idSearch = controller.getById(scanner.next());
				if(idSearch == null) {
					System.out.println("존재하지 않는 아이디입니다.");
				}else {
					System.out.println(idSearch.getUserid());
				}
				break;
			case "9":
				System.out.print("[이름 검색]\n이름 >> ");
				String name = scanner.next();
				UserDTO[] nameSearch = controller.getByName(name);
				if(nameSearch == null) {
					System.out.println("존재하지 않는 이름입니다.");
				}else {
					for(int i = 0; i < controller.getCountSameName(name); i++) {
						System.out.println(nameSearch[i].getName());
					}
				}
				break;
			case "10":
				System.out.printf("전체 회원수는 %d명입니다.\n",controller.getCount());
				break;
			case "0":
				System.out.println("시스템 종료");
				return;
			}
			
		}
		
	}
}











