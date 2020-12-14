package Algorithm001;

import java.util.ArrayList;
import java.util.Scanner;

public class MTest {
	
	public static void main(String[] args) {
		
		// 4���� �л� ����
		// Student class�� �����ؼ� ����
		Student st1 = new Student("������", "20200000");
		Student st2 = new Student("������", "20201111");
		Student st3 = new Student("������", "20202222");
		Student st4 = new Student("������", "20203333");
		
		// �л����� ArrayList�� ����
		
		// �л����� �־��ٰŶ� ���׸��� Student
		ArrayList<Student> list = new ArrayList<Student>();
		
		list.add(st1);
		list.add(st2);
		list.add(st3);
		list.add(st4);
		
		// ����ڷκ��� Ű �Է¹ޱ�
		Scanner sc = new Scanner(System.in);
		
		// ���ѷ��������鼭
		while(true) {
			System.out.println("��� �˻��Ͻ÷��� y / �����ϰ�����ø� n");
			// ����ڰ� �Է¹��� ���� key��� ������ ����ְ�, 
			String key = sc.next();
			
			// key�� y���
			if(key.equals("y")) {
				System.out.println("�˻��� �л��� �̸��� �����ּ���.");
				String name = sc.next();
				
				boolean flag = false;
				
				// StudentŸ���� ���� st�� list�� �ϳ��ϳ��� ����ָ� �ݺ���,
				for(Student st : list) {
					// st�� Name�� ����ڰ� �Է¹��� �л��� �̸��̶� �����ϴٸ�
					if(st.getName().equals(name)) {
						// �л� �̸��� �й� ���
						System.out.println("�ش��ϴ� �л� �̸��� : " + st.getName());
						System.out.println("�ش��ϴ� �л� �й��� : " + st.getNo());
						// flag�� true�� �������ش�.
						// ���� ã�°� ���ٸ� flag�� �״�� false
						flag = true;
					}
				}
				
				// flag�� true �� �ƴ϶�� [�л��� ���ٸ�]
				if (!flag){
					System.out.println("�ش��ϴ� �л� �̸��� �����ϴ�.");
				}
			// ����ڰ� n�� �Է��ϸ�
			} else if(key.equals("n")) {
				// ���Ṯ�� ���� break;
				System.out.println("����Ǿ����ϴ�.");
				break;
			} else {
				// �ƿ� �ٸ� Ű�� ������ ��
				System.out.println("Ű�� �߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
			}
			
		}
		
		
		
	}

}
