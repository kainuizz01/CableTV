package th.co.aware.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class IndexController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String moveToIndex() {
		return "index";
	}

	public String moveToAddPackage() {
		return "addPackage";
	}

	public String moveToCustomer() {
		return "customer";
	}
	
	public String moveToCalculateCustomer() {
		return "calculateCustomer";
	}

}
