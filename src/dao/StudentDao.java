package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dto.Clazz;
import dto.Student;
import util.HibernateUtil;

public class StudentDao {
	public boolean addStudent(Student student){
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		Integer result = (Integer)session.save(student);
		if(result>0){
			return true;
		}
		else{
			return false;
		}
	}
	
	public List<Student> showStudent(Student student){
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		List<Student> students = session.createQuery("select s from Student s").list();
		System.out.println(students);
		tx.commit();
		HibernateUtil.closeSession();
		if(students!=null){
			return students;
		}else{
			return null;
		}
	}

	public static Student getStudentById(Integer sid) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		System.out.println(sid+"abcd");
		Student student = (Student)session.createQuery("select s from Student s where s.sid=?").setParameter(0, sid).uniqueResult();
		System.out.println(99999);
		System.out.println(student);
		tx.commit();
		HibernateUtil.closeSession();
		return student;
	}
	
	//�޸����
		public boolean modifiStudent(Student student){
			Session session = HibernateUtil.currentSession();
			Transaction tx = session.beginTransaction();
			System.out.println(student);
			Student students = (Student)session.load(Student.class, student.getSid());
			students.setSno(student.getSno());
			students.setSname(student.getSname());
			students.setBirth(student.getBirth());
			students.setTel(student.getTel());
			students.setSex(student.getSex());
			students.setUpimg(student.getUpimg());
	        Student student2 = (Student) session.merge(students);
			tx.commit();
			HibernateUtil.closeSession();
			if(student2!=null){
				return true;
			}
			else{
				return false;
			}
			
		}

		public void DeleteStudent(Integer sid) {
			// TODO Auto-generated method stub
			Session session = HibernateUtil.currentSession();
			Transaction tx = session.beginTransaction();
			Student student = (Student)session.createQuery("select s from Student s where s.sid=?").setParameter(0, sid).uniqueResult();
			System.out.println(99999);
			System.out.println(student);
			session.delete(student);
			tx.commit();
			HibernateUtil.closeSession();
		}

		public Student searchStudent(String sno) {
			// TODO Auto-generated method stub
			Session session = HibernateUtil.currentSession();
			Transaction tx = session.beginTransaction();
			Student student = (Student)session.createQuery("select s from Student s where s.sno=?").setParameter(0, sno).uniqueResult();
			System.out.println(student+"���������кò���");
			tx.commit();
			return student;
		}
	
}
