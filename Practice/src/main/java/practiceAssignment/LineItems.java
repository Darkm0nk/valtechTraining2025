package practiceAssignment;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.criteria.Order;


@Entity
public class LineItems {

	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lineItemSeq")
	@SequenceGenerator(name = "lineItemSeq",sequenceName = "lineItem_seq ", allocationSize = 1)
	private long id;
	private int quantity;
	@ManyToOne(targetEntity = Orders.class , cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "order_id",referencedColumnName = "id")
	private Orders orders;
	@ManyToOne(targetEntity = Item.class  ,fetch = FetchType.EAGER)
	@JoinColumn(name = "item_id", referencedColumnName = "id")
	private Item items;
	public LineItems() {
		super();
	}
	public LineItems(int quantity) {
		super();
		this.quantity = quantity;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Orders getOrder() {
		return orders;
	}
	public void setOrder(Orders order) {
		this.orders = order;
	}
	public Item getItem() {
		return items;
	}
	public void setItem(Item item) {
		this.items = item;
	}
	
	
}
