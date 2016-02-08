package th.co.aware.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import th.co.aware.Dao.EmployeeDao;
import th.co.aware.model.Employee;

@Service("EmployeeBOImpl")
@Transactional(readOnly = false)
public class EmployeeBOImpl implements EmployeeBO{
	@Autowired
	private EmployeeDao emplDao;
	
	
	@Transactional(readOnly = false)
	public void register(Employee emp) {
		emplDao.register(emp);
		
	}

	@Transactional
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		
		return emplDao.findAll();
	}

}
