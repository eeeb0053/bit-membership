package viewer;

import java.util.Scanner;

import grade.GradeController;
import grade.GradeDTO;
// 1��: �̸�, �հ�: 000�� ���: 00��
public class GradeMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		GradeController controller = new GradeController();
		GradeDTO grade = null;
		
		while(true) {
			System.out.print("1. ������� 2. �������� 3. �������� 4.�����ǥ 0. ���� \n>> ");
			switch (scanner.next()) {
			case "1": 
				grade = new GradeDTO();
				System.out.print("�̸�: ");
				grade.setName(scanner.next());
				System.out.print("��������: ");
				grade.setKor(scanner.nextInt());
				System.out.print("��������: ");
				grade.setEng(scanner.nextInt());
				System.out.print("��������: ");
				grade.setMath(scanner.nextInt());
				controller.postGrade(grade);
				break;
			case "2": 
				grade = new GradeDTO();
				System.out.print("�̸�: ");
				grade.setName(scanner.next());
				System.out.print("��������: ");
				grade.setKor(scanner.nextInt());
				System.out.print("��������: ");
				grade.setEng(scanner.nextInt());
				System.out.print("��������: ");
				grade.setMath(scanner.nextInt());
				controller.putGrade(grade);
				break;
			case "3":
				grade = new GradeDTO();
				System.out.print("�̸�: ");
				grade.setName(scanner.next());
				controller.deleteGrade(grade);
				grade = new GradeDTO();
				break;
			case "4": 
				GradeDTO[] grades = controller.getGradeSort();
				for(int i = 0; i < controller.getCount(); i++) {
					System.out.println(grades[i].toString());
				}
				break;
			case "0": 
				System.out.println("�ý��� ����");
				return;
			}
		}
	}
}
