package practiceAssignment;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Orders {
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orderSeq")
	@SequenceGenerator(name = "orderSeq" ,sequenceName = "order_seq" , allocationSize = 1)	
	private long id;
	@Enumerated(EnumType.STRING)
	private Status status;
	@ManyToOne(targetEntity = Customer.class ,cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id",referencedColumnName = "id")
	private Customer customer;
	@OneToMany(mappedBy = "orders",targetEntity = LineItems.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<LineItems> lineItems;
	public enum Status{
		ORDERED, PACKED , SHIPPED, DELIVERED
	}

	public Orders() {
		
	}

	public Orders( Status status) {
		this.status = status;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Set<LineItems> getLineItems() {
		return lineItems;
	}

	public void setLineItems(Set<LineItems> lineItems) {
		this.lineItems = lineItems;
	}
	
	
	
	
}
