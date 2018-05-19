package util;

import org.hibernate.*;
import org.hibernate.cfg.*;
import org.hibernate.service.*;
import org.hibernate.boot.registry.*;

public class HibernateUtil
{
	public static final SessionFactory sessionFactory;

	static
	{
		try
		{
			// ʹ��Ĭ�ϵ�hibernate.cfg.xml�����ļ�����Configurationʵ��
			Configuration cfg = new Configuration()
				.configure();
			// ��Configurationʵ��������SessionFactoryʵ��
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure()
				.build();
			sessionFactory = cfg.buildSessionFactory(serviceRegistry);
		}
		catch (Throwable ex)
		{
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	// ThreadLocal���Ը������̵߳���ݹ��?��˲�����Ҫ���߳�ͬ��
	public static final ThreadLocal<Session> session
		= new ThreadLocal<Session>();

	public static Session currentSession()
		throws HibernateException
	{
		Session s = session.get();
		// �����̻߳�û��Session,�򴴽�һ���µ�Session
		if (s == null)
		{
			s = sessionFactory.openSession();
			// ����õ�Session�����洢��ThreadLocal����session��
			session.set(s);
		}
		return s;
	}

	public static void closeSession()
		throws HibernateException
	{
		Session s = session.get();
		if (s != null)
			s.close();
		session.set(null);
	}
}