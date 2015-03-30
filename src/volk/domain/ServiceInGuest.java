package volk.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "serviceinguest")
public class ServiceInGuest implements Serializable {
	private int id;
	private int idGuest;
	private int idService;
	
	public ServiceInGuest() {

	}
	
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

		
	@Column(name = "idguest")
	public int getIdGuest() {
		return idGuest;
	}

	public void setIdGuest(int idGuest) {
		this.idGuest = idGuest;
	}
	
	@Column(name = "idservice")
	public int getIdService() {
		return idService;
	}

	public void setIdService(int idService) {
		this.idService = idService;
	}

}

