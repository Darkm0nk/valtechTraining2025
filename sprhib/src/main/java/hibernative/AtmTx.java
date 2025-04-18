package hibernative;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue(value = "atx")
@Table(name="atmtxper")
public class AtmTx extends Tx {
	private int atm;
	

	public AtmTx(double amount, int atm) {
		super(amount);
		this.atm = atm;
	}

	public int getAtm() {
		return atm;
	}

	public void setAtm(int atm) {
		this.atm = atm;
	};
	
	
}
