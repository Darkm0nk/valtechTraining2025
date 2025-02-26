package hibernative;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue(value = "ctx")
@Table(name="chequetxper")
public class chequeTx extends Tx {

	private int chequeNo;

	public chequeTx(double amount, int chequeNo) {
		super(amount);
		this.chequeNo = chequeNo;
	}
	public int getChequeNo() {
		return chequeNo;
	}
	public void setChequeNo(int chequeNo) {
		this.chequeNo = chequeNo;
	};
	
	
}
