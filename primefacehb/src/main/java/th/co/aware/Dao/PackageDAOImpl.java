package th.co.aware.Dao;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import th.co.aware.model.PackageService;
@Component
public class PackageDAOImpl implements PackageDAO {

	@Autowired
	private SessionFactory sessionFactory;

	
	
	public SessionFactory getSessionFactory() {
		
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void register(PackageService pack) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(pack);
		tx.commit();
		session.clear();

	}
	@SuppressWarnings("unchecked")
	public List<PackageService> findAll() {
		Session session = this.sessionFactory.openSession();
		List<PackageService> PackageList =
				session.createCriteria(PackageService.class).list();
		session.close();
		return PackageList;
	}

	public void delete(PackageService pack) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(pack);
		tx.commit();
		session.clear();
	}

}
