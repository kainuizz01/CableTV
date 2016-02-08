package th.co.aware.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the customers database table.
 * 
 */
@Entity
@Table(name="customers")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_card_number")
	private int idCardNumber;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="birthdate")
	private Date birthdate;

	@Column(name="description")
	private String description;
	
	@Column(name="email")
	private String email;

	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="register_date")
	private Date registerDate;

	//bi-directional many-to-one association to Installation
	@OneToMany(mappedBy="customer")
	private List<Installation> installations;

	public Customer() {
	}

	public int getIdCardNumber() {
		return this.idCardNumber;
	}

	public void setIdCardNumber(int idCardNumber) {
		this.idCardNumber = idCardNumber;
	}

	public Date getBirthdate() {
		return this.birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getRegisterDate() {
		return this.registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public List<Installation> getInstallations() {
		return this.installations;
	}

	public void setInstallations(List<Installation> installations) {
		this.installations = installations;
	}

	public Installation addInstallation(Installation installation) {
		getInstallations().add(installation);
		installation.setCustomer(this);

		return installation;
	}

	public Installation removeInstallation(Installation installation) {
		getInstallations().remove(installation);
		installation.setCustomer(null);

		return installation;
	}

}