package action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionContext;

import dao.ClazzDao;
import dao.StudentDao;
import dto.Clazz;
import dto.Student;
import util.HibernateUtil;



public class StudentAction {
	private Student student;
	private String name; 
	private File upimg;
	private String upimgFileName;
	private String upimgContentType;
	private String savePath;
	private Integer sid;
	private String sno;
	
	
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public File getUpimg() {
		return upimg;
	}
	public void setUpimg(File upimg) {
		this.upimg = upimg;
	}
	public String getUpimgFileName() {
		return upimgFileName;
	}
	public void setUpimgFileName(String upimgFileName) {
		this.upimgFileName = upimgFileName;
	}
	public String getUpimgContentType() {
		return upimgContentType;
	}
	public void setUpimgContentType(String upimgContentType) {
		this.upimgContentType = upimgContentType;
	}
	public String getSavePath() {
		return ServletActionContext.getServletContext().getRealPath(savePath);
	}
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	
	
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String addStudent() throws Exception{
		FileOutputStream fos = new FileOutputStream(getSavePath()+"\\"+getUpimgFileName());
		FileInputStream fis = new FileInputStream(getUpimg());
		byte[] buffer = new byte[1024];
		int len = 0;
		while ((len = fis.read(buffer))>0){
			fos.write(buffer, 0, len);
		}
		fis.close();
		fos.close();
		StudentDao studentDao = new StudentDao();
		ClazzDao clazzDao = new ClazzDao();
		Clazz clazz = clazzDao.studentClazz(name);
		student.setClazz(clazz);
		student.setUpimg("uploadFiles"+"\\"+getUpimgFileName());
		boolean result = studentDao.addStudent(student);
		if(result){
			return "addStudentSuccess";
		}
		else{
			return "addStudentError";
		}
	}
	
	public String showStudnet() throws Exception{
		System.out.println("���������Ҷ���");
		StudentDao studentDao = new StudentDao();
		List<Student> students = studentDao.showStudent(student);
		ActionContext.getContext().getSession().put("students", students);
		if(students!=null){
			return "showStudentSuccess";
		}
		else{
			return "showStudentError";
		}
	}
	
	public String checkStudent() throws Exception{
		Student student = StudentDao.getStudentById(sid);
		ActionContext.getContext().getSession().put("student", student);
		System.out.println(student+"456");
		return "getStusuccess";
	}
	
	public String modifyStudent() throws Exception{
		System.out.println("1233" + getSavePath()+"\\"+getUpimgFileName());
		System.out.println("123223" + getUpimg());
		FileOutputStream fos = new FileOutputStream(getSavePath()+"\\"+getUpimgFileName());
		FileInputStream fis = new FileInputStream(getUpimg());
		byte[] buffer = new byte[1024];
		int len = 0;
		while ((len = fis.read(buffer))>0){
			fos.write(buffer, 0, len);
		}
		fis.close();
		fos.close();
		StudentDao studentDao = new StudentDao();
		ClazzDao clazzDao = new ClazzDao();
		Clazz clazz = clazzDao.studentClazz(name);
		student.setClazz(clazz);
		student.setUpimg("uploadFiles"+"\\"+getUpimgFileName());
		boolean result = studentDao.modifiStudent(student);;
		if(result){
			return "modifyStudentSuccess";
		}
		else{
			return "modifyStudentError";
		}
	}	
	
	public String DeleteStudentAction() throws Exception{
		StudentDao studentDao = new StudentDao();
		studentDao.DeleteStudent(sid);
		ClazzAction c = new ClazzAction();
		c.showClazz();
		return "deleteStudentsuccess";
	}
	
	public String search(){
		StudentDao studentDao = new StudentDao();
		Student student2 = studentDao.searchStudent(sno);
		System.out.println(sno+"������ְ�");
		ActionContext.getContext().getSession().put("student2", student2);
		return "search";
	}
	
}
