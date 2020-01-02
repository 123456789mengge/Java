package view;

import java.util.Scanner;

import biz.CourseBiz;


public class CourseAddUI {
	public static void show(){
	    Scanner scanner = new Scanner(System.in);
		System.out.println("请输入课程的编号：");
		String courseNo = scanner.nextLine();
		System.out.println("请输入课程的名字：");
		String courseName = scanner.nextLine();
		System.out.println("请输入课程学分: ");
		int courseGrade = scanner.nextInt();
		CourseBiz sc1 = new CourseBiz();
		sc1.addCourse(courseNo, courseName, courseGrade);
	}
}
