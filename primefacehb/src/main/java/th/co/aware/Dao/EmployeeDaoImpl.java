package th.co.aware.Dao;

import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import th.co.aware.model.Employee;

@Component
public class EmployeeDaoImpl implements EmployeeDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	
	
	public SessionFactory getSessionFactory() {
		
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	//@Override
	public void register(Employee emp) {

		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(emp);
		tx.commit();
		session.clear();

	}
	@SuppressWarnings("unchecked")
	//@Override
	public List<Employee> findAll() {
		Session session = this.sessionFactory.openSession();
		List<Employee> employeeList =
				session.createCriteria(Employee.class).list();
		session.close();
		return employeeList;
	}

}
