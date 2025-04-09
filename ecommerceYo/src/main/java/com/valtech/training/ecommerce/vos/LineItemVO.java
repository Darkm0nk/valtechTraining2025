package com.valtech.training.ecommerce.vos;

import com.valtech.training.ecommerce.entities.LineItem;

public record LineItemVO(long id,long orderId,int qty,long itemId) {

	public static LineItemVO from(LineItem lt) {
		long order = lt.getOrder().getId();
		long item = lt.getItem().getId();
		return new LineItemVO(lt.getId(),order,lt.getQty(),item);
	}
	
	public LineItem to() {
		return new LineItem(qty);
	}
}
