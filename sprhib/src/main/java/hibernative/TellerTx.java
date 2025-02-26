package hibernative;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue(value = "ttx")
@Table(name="tellertxper")
public class TellerTx extends Tx {
	private String teller;
	private String Branch;
	
	public TellerTx(double amount, String teller, String branch) {
		super(amount);
		this.teller = teller;
		Branch = branch;
	}
	
	public String getTeller() {
		return teller;
	}

	public void setTeller(String teller) {
		this.teller = teller;
	}

	public String getBranch() {
		return Branch;
	}

	public void setBranch(String branch) {
		Branch = branch;
	}
	
	
	
}
