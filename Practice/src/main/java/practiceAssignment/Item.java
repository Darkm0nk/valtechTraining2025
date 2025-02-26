package practiceAssignment;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Item {
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "itemSeq")
	@SequenceGenerator(name = "itemSeq", sequenceName = "item_seq" , allocationSize = 1)
	private long id;
	private String description;
	private int currQuantity;
	private int reOrderQuantity;
	private int maxQuantity;
	
	public Item() {
		
	}

	public Item( String description, int currQuantity, int reOrderQuantity, int maxQuantity) {

		this.description = description;
		this.currQuantity = currQuantity;
		this.reOrderQuantity = reOrderQuantity;
		this.maxQuantity = maxQuantity;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDesc() {
		return description;
	}

	public void setDesc(String desc) {
		description = desc;
	}

	public int getCurrQuantity() {
		return currQuantity;
	}

	public void setCurrQuantity(int currQuantity) {
		this.currQuantity = currQuantity;
	}

	public int getReOrderQuantity() {
		return reOrderQuantity;
	}

	public void setReOrderQuantity(int reOrderQuantity) {
		this.reOrderQuantity = reOrderQuantity;
	}

	public int getMaxQuantity() {
		return maxQuantity;
	}

	public void setMaxQuantity(int maxQuantity) {
		this.maxQuantity = maxQuantity;
	}
	
	
	
	
}
