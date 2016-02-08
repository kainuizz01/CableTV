package th.co.aware.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import th.co.aware.bo.EmployeeBO;
import th.co.aware.model.Employee;


@ManagedBean
@SessionScoped
public class RegisterEmployee implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{EmployeeBOImpl}")
	private EmployeeBO empImpl;

	private List<Employee> employees;
	private Employee employee = new Employee();

	@PostConstruct
	public void init() {
		this.employees = empImpl.findAll();
	}

	

	public String register() {
		empImpl.register(employee);

		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("The Employee" + this.employee.getEmpName() + "Is Registered Sucssfully"));
		init();
		return "";
	}



	public EmployeeBO getEmpImpl() {
		return empImpl;
	}



	public void setEmpImpl(EmployeeBO empImpl) {
		this.empImpl = empImpl;
	}



	public List<Employee> getEmployees() {
		return employees;
	}



	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}



	public Employee getEmployee() {
		return employee;
	}



	public void setEmployee(Employee employee) {
		employee=(Employee) empImpl.findAll();
		this.employee = employee;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

	
	
}
