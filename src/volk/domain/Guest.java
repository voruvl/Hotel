package volk.domain;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "guest")
public class Guest implements Serializable {
	private static final long serialVersionUID = 3853929063410516360L;
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "dateinput")
	private Date dateIn;
	@Column(name = "dateoutput")
	private Date dateOut;
	@ManyToOne
	@JoinColumn(name = "numer", referencedColumnName = "id")
	private Numer numer;

	public Guest() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateIn() {
		return dateIn;
	}

	public void setDateIn(Date dateIn) {
		this.dateIn = dateIn;
	}

	public Date getDateOut() {
		return dateOut;
	}

	public void setDateOut(Date dateOut) {
		this.dateOut = dateOut;
	}

	public Numer getNumer() {
		return numer;
	}

	public void setNumer(Numer numer) {
		this.numer = numer;
	}

	@Override
	public String toString() {
		while (name.length() < 10)
			name += " ";
		return "Guest " + id + " name " + name + " dateIn " + dateIn
				+ " dateOut " + dateOut + " numer " + numer.getId();
	}

}
