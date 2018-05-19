package dao;

import org.hibernate.Session;

import dto.User;
import util.HibernateUtil;

public class UserDao {
	public User login(String userName,String password){
		Session session =HibernateUtil.currentSession();
		User u = (User)session.createQuery("from User u where u.username=? and u.password=?")
				.setParameter(0, userName)
				.setParameter(1, password)
				.uniqueResult();
		HibernateUtil.closeSession();
		//HibernateUtil.closeSessionFactory();
		return u;
	}
}
