package th.co.aware.Dao;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import th.co.aware.model.Customer;


@Component
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	
	
	public SessionFactory getSessionFactory() {
		
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void register(Customer cus) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(cus);
		tx.commit();
		session.clear();
		
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Customer> findAll() {
		Session session = this.sessionFactory.openSession();
		List<Customer> CustomerList =
				session.createCriteria(Customer.class).list();
		session.close();
		return CustomerList;
	}

	

	public void delete(Customer cus) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(cus);
		tx.commit();
		session.clear();
		
	}


}
