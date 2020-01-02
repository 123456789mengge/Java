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
		course.setCourseNo(courseNo);     //将课程信息存入
		course.setCourseName(courseName);
		course.setCourseGrade(courseGrade);
		courseDao = CourseDao.getInstance();
		courseDao.insert(course);
		System.out.println(course.getCourseName()+"课程注册成功！");
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
			System.out.println("课程输入错误");
		}else {
			System.out.println("课程编号："+course.getCourseNo()+"  课程名字："+course.getCourseName()+"  学分："+course.getCourseGrade());
		}
		MainUI2.show();
		return course;
	}
	public void modifyCourse(String courseNo, String oldcourseName, String newcourseName ,int newcourseGrade) {
		courseDao = CourseDao.getInstance();
		Course course2 = (Course)courseDao.getEntity(courseNo); 
		  	if(oldcourseName.equals(newcourseName)) {
		  		
		  		System.out.println("你要修改的课程与来课程名称相同!");
		  		System.out.println("请继续你要选择的服务: ");
			}else {
				course2.setCourseName(newcourseName);
				course2.setCourseGrade(newcourseGrade);
				courseDao.update(course2);
			}
		  	save();
		  	System.out.println("该课程修改成功");
		  	MainUI2.show();
	}
	public void removeCourse(String courseNo, String courseName){
		 courseDao = CourseDao.getInstance();
		 Course course2 = (Course)courseDao.getEntity(courseNo);
		 if(course2!=null){
            courseDao.delete();
			 courseDao.getAllEntities().remove(courseNo);
		 }else{
			 System.out.println("课程输入错误");
		 }
		 save();
		 MainUI2.show();

	   }
}
