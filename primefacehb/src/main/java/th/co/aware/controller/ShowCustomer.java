package th.co.aware.controller;

import java.io.Serializable;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import th.co.aware.bo.CustomerBO;
import th.co.aware.model.Customer;





@ManagedBean
@SessionScoped
public class ShowCustomer implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value = "#{CustomerBOImpl}")
	private CustomerBO cusImpl;

	private List<Customer> cusList;
	private Customer customer;
   

	@PostConstruct
	public void init() {
		this.cusList = cusImpl.findAll();
	}
	
	public String register() {
		Customer cus=new Customer();

		
		cusImpl.register(cus);

		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("The Package "  + "Is Added Sucssfully"));
		init();
		return "";
	}
	
	public String delete() {
		try {
			cusImpl.delete(customer);
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("The Package " + e.getMessage()));
		}

		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("The Package " + "Is Deleted Sucssfully"));
		init();
		return "";
	}
	
	
	
	public CustomerBO getCusImpl() {
		return cusImpl;
	}

	public void setCusImpl(CustomerBO cusImpl) {
		this.cusImpl = cusImpl;
	}

	public List<Customer> getCusList() {
		return cusList;
	}

	public void setCusList(List<Customer> cusList) {
		this.cusList = cusList;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
