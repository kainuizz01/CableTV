package th.co.aware.bo;

import java.util.List;

import th.co.aware.model.Customer;

public interface CustomerBO {

public void register(Customer cus);
	
	public void delete(Customer cus) throws Exception;
	
	public List<Customer> findAll();
}
