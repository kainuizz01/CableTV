package th.co.aware.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the satellite_boxs database table.
 * 
 */
@Entity
@Table(name="satellite_boxs")
@NamedQuery(name="SatelliteBox.findAll", query="SELECT s FROM SatelliteBox s")
public class SatelliteBox implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="satellite_box_id")
	private int satelliteBoxId;

	@Lob
	private String description;

	private String model;

	private String serial;

	private String status;

	//bi-directional many-to-one association to Installation
	@OneToMany(mappedBy="satelliteBox")
	private List<Installation> installations;

	public SatelliteBox() {
	}

	public int getSatelliteBoxId() {
		return this.satelliteBoxId;
	}

	public void setSatelliteBoxId(int satelliteBoxId) {
		this.satelliteBoxId = satelliteBoxId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getSerial() {
		return this.serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Installation> getInstallations() {
		return this.installations;
	}

	public void setInstallations(List<Installation> installations) {
		this.installations = installations;
	}

	public Installation addInstallation(Installation installation) {
		getInstallations().add(installation);
		installation.setSatelliteBox(this);

		return installation;
	}

	public Installation removeInstallation(Installation installation) {
		getInstallations().remove(installation);
		installation.setSatelliteBox(null);

		return installation;
	}

}