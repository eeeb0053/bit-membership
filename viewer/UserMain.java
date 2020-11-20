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
			System.out.print("Menu: 1.ȸ������ 2.�α��� 3.��й�ȣ ���� 4.ȸ��Ż�� 5.���̵� �ߺ�üũ "
					+ "\n6.���������� 7.ȸ����� 8.���̵�˻� 9.�̸��˻� 10.��ü ȸ���� 0.���� \n>> ");
			switch (scanner.next()) {
			case "1":
				user = new UserDTO();
				System.out.print("[ȸ������]\n�̸� >> ");
				user.setName(scanner.next());
				System.out.print("���̵� >> ");
				user.setUserid(scanner.next());
				System.out.print("��й�ȣ >> ");
				user.setPassword(scanner.next());
				controller.postJoin(user);
				break;
			case "2":
				user = new UserDTO();
				System.out.print("[�α���]\n���̵� >> ");
				user.setUserid(scanner.next());
				System.out.print("��й�ȣ >> ");
				user.setPassword(scanner.next());
				UserDTO loginUser = controller.postLogin(user);
				if(loginUser == null) {
					System.out.println("�α��� ����");
				}else {
					System.out.println(loginUser.toString());					
				}
				break;
			case "3":
				user = new UserDTO();
				System.out.print("[��й�ȣ ����]\n���̵� >> ");
				user.setUserid(scanner.next());
				System.out.print("������ ��й�ȣ >> ");
				user.setPassword(scanner.next());
				controller.putPassword(user);
				break;
			case "4":
				user = new UserDTO();
				System.out.print("[ȸ��Ż��]\n���̵� >> ");
				user.setUserid(scanner.next());
				System.out.print("��й�ȣ >> ");
				user.setPassword(scanner.next());
				controller.deleteUser(user);
				break;
			case "5":
				System.out.print("[���̵� �ߺ�üũ]\n���̵� >> ");
				boolean exist = controller.getExistId(scanner.next());
				if(exist) {
					System.out.println("��� ������ ���̵��Դϴ�.");
				}else {
					System.out.println("�̹� �����ϴ� ���̵��Դϴ�.");
				}
				break;
			case "6":
				user = new UserDTO();
				System.out.print("[����������]\n���̵� >> ");
				user.setUserid(scanner.next());
				System.out.print("��й�ȣ >> ");
				user.setPassword(scanner.next());
				UserDTO mypage = controller.getUser(user);
				if(mypage == null) {
					System.out.println("�������� �ʽ��ϴ�.");
				}else {
					System.out.printf("�̸�: %s ���̵�: %s ��й�ȣ: %s\n", 
							mypage.getName(), mypage.getUserid(), mypage.getPassword());
				}
				break;
			case "7":
				System.out.println("[ȸ�����]");
				UserDTO[] list = controller.getUserList();
				for(int i = 0; i < controller.getCount(); i++) {
					System.out.println(list[i].toString());
				}
				break;
			case "8":
				System.out.print("[���̵� �˻�]\n���̵� >> ");
				UserDTO idSearch = controller.getById(scanner.next());
				if(idSearch == null) {
					System.out.println("�������� �ʴ� ���̵��Դϴ�.");
				}else {
					System.out.println(idSearch.getUserid());
				}
				break;
			case "9":
				System.out.print("[�̸� �˻�]\n�̸� >> ");
				String name = scanner.next();
				UserDTO[] nameSearch = controller.getByName(name);
				if(nameSearch == null) {
					System.out.println("�������� �ʴ� �̸��Դϴ�.");
				}else {
					for(int i = 0; i < controller.getCountSameName(name); i++) {
						System.out.println(nameSearch[i].getName());
					}
				}
				break;
			case "10":
				System.out.printf("��ü ȸ������ %d���Դϴ�.\n",controller.getCount());
				break;
			case "0":
				System.out.println("�ý��� ����");
				return;
			}
			
		}
		
	}
}











