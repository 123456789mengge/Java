package view;

import java.util.Scanner;
import biz.*;

public class MainUI2 {
	public static void show() {
		System.out.println("1-�γ����ӣ�2-�γ�ɾ����3-�γ��޸ģ�4-�γ̲�ѯ��0-�˳�");
		Scanner scanner = new Scanner(System.in);
		String option1 = scanner.nextLine();
		switch (option1) {
		case "1":
			CourseAddUI.show();
			break;
		case "2":
			CourseRemoveUI.show();
			break;
		case "3":
			CourseModifyUI.show();
			break;
		case "4":
			CourseFindUI.show();
			break;
		case "0":
			MainUI.show();
		}
			
	}
}
