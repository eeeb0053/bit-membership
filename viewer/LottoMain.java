package viewer;

import java.util.Scanner;

import lotto.LottoDTO;

public class LottoMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		LottoDTO instance = new LottoDTO();
		System.out.println("�����ѵ� ����");
		instance.setCountLimit(scanner.nextInt());
		System.out.printf("������ �����ѵ� %d ��\n", instance.getCountLimit());
		while(true) {
			System.out.println("0.���� 1.�ζǱ���");
			switch(scanner.nextInt()) {
			case 0: 
				System.out.println("����"); 
				return;
			case 1: 
				System.out.println("�ζǱ���\n");
				buyLottos(instance,scanner);
				break;
			}
			
		}
	}
	public static void buyLottos(LottoDTO instance,Scanner scanner) {
		System.out.println("��ġ�� �����մϱ�? ");
		System.out.printf("�ζ� %d���� �߱��մϴ�\n");
		int[][] lottos = instance.getLottos();
		for(int i=0; i< lottos.length;i++) {
			for(int j=0; j < lottos[i].length; j++) {
				System.out.print(lottos[i][j]+"\t");
			}
			System.out.println();
		}
		
	}
}
