package practiceAssignment;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Cust")
public class Customer {

	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "custSeq")
	@SequenceGenerator(name = "custSeq" , sequenceName = "cust_seq", allocationSize = 1)
	private long id;
	private String name;
	private int age;
	private String address;
	private String perAddress;
	
	public Customer() {
	
	}
	public Customer(String name, int age, String address, String perAddress) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
		this.perAddress = perAddress;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPerAddress() {
		return perAddress;
	}
	public void setPerAddress(String perAddress) {
		this.perAddress = perAddress;
	}
	
	
}
