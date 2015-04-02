package volk.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "serviceinguest")
public class ServiceInGuest implements Serializable {

	
	private static final long serialVersionUID = -8269100404331490304L;
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "id")
	private int id;
	@ManyToOne
	@JoinColumn(name = "idguest", referencedColumnName = "id")
	private Guest idGuest;
	@ManyToOne
	@JoinColumn(name = "idservice", referencedColumnName = "id")
	private Service idService;

	public ServiceInGuest() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Guest getIdGuest() {
		return idGuest;
	}

	public void setIdGuest(Guest idGuest) {
		this.idGuest = idGuest;
	}

	public Service getIdService() {
		return idService;
	}

	public void setIdService(Service idService) {
		this.idService = idService;
	}

	@Override
	public String toString() {
		return "Guest " + idGuest.getName() +" numer " + idGuest.getNumer().getId() + ", Service "
				+ idService.getNameService()+" price "+idService.getPrice();
	}

}
