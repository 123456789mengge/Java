package dao;
import entity.Course;
import entity.IEntity;
import entity.Student;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Scanner;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Set;
import biz.*;
public class CourseDao implements IDao {
	
	CourseDao coursedao;
	private static CourseDao instance;
	private HashMap<String, IEntity> courses;
	private Course course;
	private  FileInputStream cfs;
	public FileOutputStream cfos;
	private HashMap<String, IEntity> cs;
	Scanner in = new Scanner(System.in);
	
	private CourseDao() {
		courses = new HashMap<String, IEntity>();
		course = new Course();
		getCoursesFromInputStream("course.txt");
	}
	
	private void getCoursesFromInputStream(String isName) {
		try {
		    cfs = new FileInputStream(isName);
			byte[] content = new byte[1024];
			int i=0;
			int conInteger = 0;
			while(true) {
				try {
					conInteger = cfs.read();
				} catch(IOException e) {
					e.printStackTrace();
				}
				if(-1 == conInteger) {
					break;
				}else if('\r' == (char)conInteger || '\n' == (char)conInteger) {
					try {
						this.processCourseString(new String(content,"GBK").trim());
						i=0;
					} catch(UnsupportedEncodingException e) {
						e.printStackTrace();
					}
					continue;
				}else {
					content[i] = (byte)conInteger;
					i++;
				  }
			     }
		     } catch(Exception e) {
				e.printStackTrace();
		 }
      }
	
	public void processCourseString(String userString) {
		String [] userFields = userString.split(",");
		Course cs = new Course();
		cs.setCourseNo(userFields[0]);
		cs.setCourseName(userFields[1]);
		cs.setCourseGrade(Integer.parseInt(userFields[2]));
		
		courses.put(cs.getCourseNo(), cs);
	}	

	@Override
	public void insert(IEntity entity) {
		// TODO Auto-generated method stub
		Course cs = (Course)entity;
		courses.put(cs.getCourseNo(), cs);
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
				System.out.println("请输入你要删除的课程编号");
				Scanner str=new Scanner(System.in);
				String courseNo=str.nextLine();
				Course course = (Course)getEntity(courseNo);
				if(course == null){
					System.out.println("该课程不存在");
				}else{
					courses.remove(course);
					System.out.println("该课程已经移除");
				}

	}

	public void update() {
		// TODO Auto-generated method stub
		Set<String> csSet = courses.keySet();
		StringBuffer uStringBuffer = new StringBuffer();
		for(String courseNo:csSet) {
			Course cs = (Course)courses.get(courseNo);
			
			String uString = cs.getCourseNo() + ","
					+ cs.getCourseName() + ","
					+ cs.getCourseGrade() + "\r\n";
			uStringBuffer.append(uString);
		}
		putCoursesToFile(uStringBuffer.toString(),"course.txt");
	}
	
	private void putCoursesToFile(String uString,String osName) {
		try {
			cfos = new FileOutputStream(osName);
			try {
				cfos.write(uString.getBytes("GBK"));
			}catch(UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static CourseDao getInstance() {
		if(instance == null) {
			synchronized(CourseDao.class) {
				if(instance == null) {
					instance = new CourseDao();
					return instance;
				}
			}
		}
		return instance;
	}
	
	private void save() {
		CourseDao cs = CourseDao.getInstance();
		cs.update();
	}
	
	@Override
	public HashMap<String, entity.IEntity> getAllEntities() {
		// TODO Auto-generated method stub
		return courses;
	}

	@Override
	public IEntity getEntity(String Id) {
		// TODO Auto-generated method stub
		return courses.get(Id);
	}

	@Override
	public void update(IEntity entity) {
		// TODO Auto-generated method stub
		
	}

}
