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
			System.out.println("Menu: 1.ȸ������ 2.�α��� 3.��й�ȣ ���� 4.ȸ��Ż�� 5.���̵� �ߺ�üũ "
					+ "6.���������� 7.ȸ����� 8.���̵�˻� 9.�̸��˻� 10.��ü ȸ���� 0.���� \n>> ");
			switch (scanner.next()) {
			case "1":
				System.out.print("�̸� >> ");
				user.setName(scanner.next());
				System.out.print("���̵� >> ");
				user.setUserid(scanner.next());
				System.out.print("��й�ȣ >> ");
				user.setPassword(scanner.next());
				controller.postJoin(user);
				break;
			case "2":
				System.out.print("���̵� >> ");
				user.setUserid(scanner.next());
				System.out.print("��й�ȣ >> ");
				user.setPassword(scanner.next());
				controller.postLogin(user);
				break;
			case "3":
				System.out.print("���̵� >> ");
				user.setUserid(scanner.next());
				System.out.print("������ ��й�ȣ >> ");
				user.setPassword(scanner.next());
				controller.putPassword(user);
				break;
			case "4":
				System.out.print("���̵� >> ");
				user.setUserid(scanner.next());
				System.out.print("��й�ȣ >> ");
				user.setPassword(scanner.next());
				controller.deleteUser(user);
				break;
			case "5":
				System.out.print("���̵� >> ");
				boolean exist = controller.getExistId(scanner.next());
				break;
			case "6":
				System.out.print("���̵� >> ");
				user.setUserid(scanner.next());
				System.out.print("��й�ȣ >> ");
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
				System.out.println("�ý��� ����");
				return;
			}
			
		}
		
	}
}











