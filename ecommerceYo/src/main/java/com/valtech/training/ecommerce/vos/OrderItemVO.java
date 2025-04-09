package com.valtech.training.ecommerce.vos;

public class OrderItemVO {
	
	private long ids;
	private int qty;
	
	public long getIds() {
		return ids;
	}
	public void setIds(long ids) {
		this.ids = ids;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	@Override
	public String toString() {
		return "OrderItemVO [ids=" + ids + ", qty=" + qty + "]";
	}

}
