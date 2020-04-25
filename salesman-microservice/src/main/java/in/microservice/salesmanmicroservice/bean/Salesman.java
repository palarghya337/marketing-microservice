package in.microservice.salesmanmicroservice.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "salesman")
public class Salesman {

	@Id
	@SequenceGenerator(initialValue = 1001,
		name = "salesman_sequence_generator")
	@GeneratedValue(strategy = GenerationType.AUTO,
		generator = "salesman_sequence_generator")
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "salesman_name")
	private String name;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "commission")
	private double commission;
	
	public Salesman() {
		
	}
	public Salesman(String name) {
		this.name = name;
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public double getCommission() {
		return commission;
	}
	public void setCommission(double commission) {
		this.commission = commission;
	}
	@Override
	public String toString() {
		return "Salesman [id=" + id + ", name=" + name + ", city=" + city + ", commission=" + commission + "]";
	}
}
