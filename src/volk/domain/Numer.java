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
@Table(name = "numer")
public class Numer implements Serializable {
	

	private static final long serialVersionUID = 7773176703595149295L;
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "id")
	private int id;
	@Column(name = "stars")
	private int stars;
	@Column(name = "price")
	private int price;
	@Column(name = "capacity")
	private int capacity;
	@ManyToOne
	@JoinColumn(name = "state", referencedColumnName = "id")
	private StateNumer state;

	public Numer() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public StateNumer getState() {
		return state;
	}

	public void setState(StateNumer state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Numer " + id + ", stars " + stars + ", price " + price
				+ ", capacity " + capacity + " state " + state.getNameState();
	}

}
