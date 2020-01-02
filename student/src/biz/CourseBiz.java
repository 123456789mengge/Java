package biz;

import java.util.HashMap;
import java.util.Set;

import dao.*;
import entity.*;
import view.*;

public class CourseBiz {	
	CourseDao courseDao;
	private Course course;
	
	public void addCourse(
			              String courseNo,
			              String courseName,  
			              int courseGrade) {
		course = new Course();
		course.setCourseNo(courseNo);     //���γ���Ϣ����
		course.setCourseName(courseName);
		course.setCourseGrade(courseGrade);
		courseDao = CourseDao.getInstance();
		courseDao.insert(course);
		System.out.println(course.getCourseName()+"�γ�ע��ɹ���");
		save();
		MainUI2.show();
	}
	private void save() {
		CourseDao dbutil = CourseDao.getInstance();
		dbutil.update();
	}

	public Course findCourse(String courseNo) {
		courseDao = (CourseDao)CourseDao.getInstance();
		HashMap<String, IEntity> courses = new HashMap<String, IEntity>();
		courses=courseDao.getAllEntities();
		course=(Course)courses.get(courseNo);
		if(course==null) {
			System.out.println("�γ��������");
		}else {
			System.out.println("�γ̱�ţ�"+course.getCourseNo()+"  �γ����֣�"+course.getCourseName()+"  ѧ�֣�"+course.getCourseGrade());
		}
		MainUI2.show();
		return course;
	}
	public void modifyCourse(String courseNo, String oldcourseName, String newcourseName ,int newcourseGrade) {
		courseDao = CourseDao.getInstance();
		Course course2 = (Course)courseDao.getEntity(courseNo); 
		  	if(oldcourseName.equals(newcourseName)) {
		  		
		  		System.out.println("��Ҫ�޸ĵĿγ������γ�������ͬ!");
		  		System.out.println("�������Ҫѡ��ķ���: ");
			}else {
				course2.setCourseName(newcourseName);
				course2.setCourseGrade(newcourseGrade);
				courseDao.update(course2);
			}
		  	save();
		  	System.out.println("�ÿγ��޸ĳɹ�");
		  	MainUI2.show();
	}
	public void removeCourse(String courseNo, String courseName){
		 courseDao = CourseDao.getInstance();
		 Course course2 = (Course)courseDao.getEntity(courseNo);
		 if(course2!=null){
            courseDao.delete();
			 courseDao.getAllEntities().remove(courseNo);
		 }else{
			 System.out.println("�γ��������");
		 }
		 save();
		 MainUI2.show();

	   }
}
