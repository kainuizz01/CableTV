package th.co.aware.Dao;

import java.util.List;

import th.co.aware.model.Employee;

public interface EmployeeDao {
	public void register(Employee emp);

	public List<Employee> findAll();
}
