package viewer;

import java.util.Scanner;

import user.UserController;
import user.UserDTO;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		UserController controller = new UserController();
		UserDTO user = new UserDTO();
		
		while(true) {
			System.out.println("Menu: 1.회원가입 2.로그인 3.비밀번호 수정 4.회원탈퇴 5.아이디 중복체크 "
					+ "6.마이페이지 7.회원목록 8.아이디검색 9.이름검색 10.전체 회원수 0.종료 \n>> ");
			switch (scanner.next()) {
			case "1":
				System.out.print("이름 >> ");
				user.setName(scanner.next());
				System.out.print("아이디 >> ");
				user.setUserid(scanner.next());
				System.out.print("비밀번호 >> ");
				user.setPassword(scanner.next());
				controller.postJoin(user);
				break;
			case "2":
				System.out.print("아이디 >> ");
				user.setUserid(scanner.next());
				System.out.print("비밀번호 >> ");
				user.setPassword(scanner.next());
				controller.postLogin(user);
				break;
			case "3":
				System.out.print("아이디 >> ");
				user.setUserid(scanner.next());
				System.out.print("변경할 비밀번호 >> ");
				user.setPassword(scanner.next());
				controller.putPassword(user);
				break;
			case "4":
				System.out.print("아이디 >> ");
				user.setUserid(scanner.next());
				System.out.print("비밀번호 >> ");
				user.setPassword(scanner.next());
				controller.deleteUser(user);
				break;
			case "5":
				System.out.print("아이디 >> ");
				boolean exist = controller.getExistId(scanner.next());
				break;
			case "6":
				System.out.print("아이디 >> ");
				user.setUserid(scanner.next());
				System.out.print("비밀번호 >> ");
				user.setPassword(scanner.next());
				UserDTO mypage = controller.getUser(user);
				break;
			case "7":
				UserDTO[] list = controller.getUserList();
				break;
			case "8":
				UserDTO idSearch = controller.getById(scanner.next());
				break;
			case "9":
				UserDTO[] nameSearch = controller.getByName(scanner.next());
				break;
			case "10":
				int count = controller.getCount();
				break;
			case "0":
				System.out.println("시스템 종료");
				return;
			}
			
		}
		
	}
}











