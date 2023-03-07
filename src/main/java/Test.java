import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Test {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		if (sessionFactory != null) {
			Session session = sessionFactory.openSession();
			Transaction tran = session.beginTransaction();
			// Person s1 = new Person(1L,"Nguyen Van A", new
			// Date(System.currentTimeMillis()), null);
			// session.save(s1);
			Person s1 = session.find(Person.class, 1L);
			Person s2 = new Person(2L, "Nguyen Van A", new Date(System.currentTimeMillis()), s1);
			session.save(s2);
			s1.setBourse(s2);
			session.saveOrUpdate(s1);
			String sql = "SELECT p.name, p.spouse.name FROM Person p";
			List<Object[]> results = session.createQuery(sql).list();
			for (Object[] rs : results) {
				String name = rs[0] + "";
				String spouseName = rs[2] + "";
			}

			tran.commit();
			session.close();
		}
	}
}
