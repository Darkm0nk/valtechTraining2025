package hibernative;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@DiscriminatorColumn(name = "disc")
//@DiscriminatorValue(value = "tx")
//@Table(name = "alltxs")
@Table(name="txper")
public class Tx {
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "txseq")
	@SequenceGenerator(name = "txseq", sequenceName = "tx_seq", allocationSize = 1)
	
	private long id;
	private double amount;
	

	public Tx() {
	}


	public Tx( double amount) {
		this.amount = amount;
	}


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
}
