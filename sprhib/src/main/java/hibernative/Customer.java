package hibernative;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.Target;

@Entity
public class Customer {
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "custseq")
	@SequenceGenerator(name="custseq", sequenceName = "cust_seq", allocationSize = 1)
	private long id;
	private String name;
	private int age;
	private boolean gender;
	//Mappedby is the field on the child where the join column definition is declared
	@OneToOne(targetEntity = Address.class, mappedBy = "customer")
	private Address address;
	
	public Customer() {
		
	}
	
	
	
	public Customer( String name, int age, boolean gender) {

		this.name = name;
		this.age = age;
		this.gender = gender;
	}


	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
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
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	
	
}
