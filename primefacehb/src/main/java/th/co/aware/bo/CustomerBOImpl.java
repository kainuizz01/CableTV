package th.co.aware.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import th.co.aware.Dao.CustomerDAO;
import th.co.aware.model.Customer;

@Service("CustomerBOImpl")
@Transactional(readOnly = false)
public class CustomerBOImpl implements CustomerBO {

	@Autowired
	private CustomerDAO cusDAO;

	@Transactional
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		return cusDAO.findAll();
	}

	@Transactional
	public void register(Customer cus) {
		// TODO Auto-generated method stub

	}

	public void delete(Customer cus) throws Exception {
		if (cus == null || cus.getIdCardNumber() == 0) {
			throw new Exception("Not value id");
		} else {
			cusDAO.delete(cus);

		}

	}
}
