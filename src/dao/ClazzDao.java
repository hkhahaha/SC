package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dto.Clazz;
import util.HibernateUtil;

public class ClazzDao {
	public boolean addClazz(Clazz clazz){
			Session session = HibernateUtil.currentSession();
			Transaction tx = session.beginTransaction();
			Integer result =(Integer) session.save(clazz);
			System.out.println(123);
			tx.commit();
			HibernateUtil.closeSession();
			if(result>0){
				return true;
			}
			else{
				return false;
			}
	}
	
	public List<Clazz> showClazz() {
			Session session = HibernateUtil.currentSession();
			Transaction tx = session.beginTransaction();
			List<Clazz> clazzs = session.createQuery("select c from Clazz c").list();
			tx.commit();
			HibernateUtil.closeSession();
			if(clazzs!=null){
				System.out.println(clazzs);
				return clazzs;
			}else{
				return null;
			}
	}
	
	//�޸����
	public void modifiClazz(Clazz clazz){
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		System.out.println(clazz);
		Clazz clazzs = (Clazz)session.load(Clazz.class, clazz.getId());
		clazzs.setName(clazz.getName());
		clazzs.setType(clazz.getType());
		clazzs.setTeacher(clazz.getTeacher());
        session.update(clazzs);
		tx.commit();
		HibernateUtil.closeSession();
	}

	public static Clazz getClazzByID(int id) {
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		Clazz clazz = (Clazz)session.createQuery("select c from Clazz c where c.id=?").setParameter(0, id).uniqueResult();
		tx.commit();
		HibernateUtil.closeSession();
		// TODO Auto-generated method stub
		return clazz;
	}


	public void DeleteClazz(int id) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		Clazz clazz = (Clazz)session.createQuery("select c from Clazz c where c.id=?").setParameter(0, id).uniqueResult();
		System.out.println(99999);
		System.out.println(clazz);
		session.delete(clazz);
		tx.commit();
		HibernateUtil.closeSession();
	}
	
     public Clazz studentClazz(String name){
    	 Session session = HibernateUtil.currentSession();
    	 Transaction tx = session.beginTransaction();
    	 Clazz clazz = (Clazz)session.createQuery("select c from Clazz c where c.name=?").setParameter(0, name).uniqueResult();
    	 tx.commit();
    	 HibernateUtil.closeSession();
    	 return clazz;
	}
	
     public Clazz findstudentClazz(Integer id){
    	 Session session = HibernateUtil.currentSession();
    	 Transaction tx = session.beginTransaction();
    	 Clazz clazz2 = (Clazz)session.createQuery("select c from Clazz c where c.id=?").setParameter(0, id);
    	 tx.commit();
    	HibernateUtil.closeSession();
    	return clazz2;
     }
     
}
