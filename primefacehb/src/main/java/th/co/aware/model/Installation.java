package th.co.aware.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the installations database table.
 * 
 */
@Entity
@Table(name="installations")
@NamedQuery(name="Installation.findAll", query="SELECT i FROM Installation i")
public class Installation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="installation_id")
	private int installationId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date created;

	@Lob
	private String description;

	@Column(name="package_id")
	private int packageId;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="id_card_number")
	private Customer customer;

	//bi-directional many-to-one association to SatelliteBox
	@ManyToOne
	@JoinColumn(name="satellite_box_id")
	private SatelliteBox satelliteBox;

	public Installation() {
	}

	public int getInstallationId() {
		return this.installationId;
	}

	public void setInstallationId(int installationId) {
		this.installationId = installationId;
	}

	public Date getCreated() {
		return this.created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPackageId() {
		return this.packageId;
	}

	public void setPackageId(int packageId) {
		this.packageId = packageId;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public SatelliteBox getSatelliteBox() {
		return this.satelliteBox;
	}

	public void setSatelliteBox(SatelliteBox satelliteBox) {
		this.satelliteBox = satelliteBox;
	}

}