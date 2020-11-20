package viewer;

import java.util.Scanner;

import grade.GradeController;
import grade.GradeDTO;
// 1등: 이름, 합계: 000점 평균: 00점
public class GradeMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		GradeController controller = new GradeController();
		GradeDTO grade = null;
		
		while(true) {
			System.out.print("1. 성적등록 2. 성적수정 3. 성적삭제 4.등수발표 0. 종료 \n>> ");
			switch (scanner.next()) {
			case "1": 
				grade = new GradeDTO();
				System.out.print("이름: ");
				grade.setName(scanner.next());
				System.out.print("국어점수: ");
				grade.setKor(scanner.nextInt());
				System.out.print("영어점수: ");
				grade.setEng(scanner.nextInt());
				System.out.print("수학점수: ");
				grade.setMath(scanner.nextInt());
				controller.postGrade(grade);
				break;
			case "2": 
				grade = new GradeDTO();
				System.out.print("이름: ");
				grade.setName(scanner.next());
				System.out.print("국어점수: ");
				grade.setKor(scanner.nextInt());
				System.out.print("영어점수: ");
				grade.setEng(scanner.nextInt());
				System.out.print("수학점수: ");
				grade.setMath(scanner.nextInt());
				controller.putGrade(grade);
				break;
			case "3":
				grade = new GradeDTO();
				System.out.print("이름: ");
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
				System.out.println("시스템 종료");
				return;
			}
		}
	}
}
