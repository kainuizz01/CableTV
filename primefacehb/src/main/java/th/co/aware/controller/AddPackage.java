package th.co.aware.controller;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import th.co.aware.bo.PackageBO;
import th.co.aware.model.PackageService;



@ManagedBean
@SessionScoped
public class AddPackage implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value = "#{PackageBOImpl}")
	private PackageBO packImpl;

	private List<PackageService> packList;
	private PackageService packageService;
    
	private int packageId;
	private String code;
	private String description;
	private Date startDate;
	private Date endDate;
	private String name;
	private double price;
	

	@PostConstruct
	public void init() {
		this.packList = packImpl.findAll();
	}
	
	public String register() {
		PackageService pack=new PackageService();
		pack.setCode(this.code);
		pack.setName(this.name);
		pack.setPrice(this.price);
		pack.setStartDate(startDate);
		pack.setEndDate(this.endDate);
		
		packImpl.register(pack);

		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("The Package " + this.packageService.getName() + "Is Added Sucssfully"));
		init();
		return "";
	}
	
	public String delete() {
		try {
			packImpl.delete(packageService);
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("The Package " + e.getMessage()));
		}

		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("The Package " + this.packageService.getName() + "Is Deleted Sucssfully"));
		init();
		return "";
	}
	
	
	public int getPackageId() {
		return packageId;
	}

	public void setPackageId(int packageId) {
		this.packageId = packageId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public PackageService getPackageService() {
		return packageService;
	}

	public void setPackageService(PackageService packageService) {
		this.packageService = packageService;
	}

	public PackageBO getPackImpl() {
		return packImpl;
	}

	public void setPackImpl(PackageBO packImpl) {
		this.packImpl = packImpl;
	}

	public List<PackageService> getPackList() {
		return packList;
	}

	public void setPackList(List<PackageService> packList) {
		this.packList = packList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
