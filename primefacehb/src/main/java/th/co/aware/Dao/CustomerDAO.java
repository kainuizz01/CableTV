package th.co.aware.Dao;

import java.util.List;

import th.co.aware.model.Customer;



public interface CustomerDAO {
	
	public void register(Customer cus);
	
	public void delete(Customer cus);

	public List<Customer> findAll();
	
}
