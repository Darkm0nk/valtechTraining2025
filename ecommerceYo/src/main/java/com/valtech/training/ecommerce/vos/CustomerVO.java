package com.valtech.training.ecommerce.vos;

import com.valtech.training.ecommerce.entities.Customer;
import com.valtech.training.ecommerce.entities.Customer.CustomerStatus;

public record CustomerVO(long id,String name,int age,String address,String permanentAddress){
	
	public static CustomerVO from(Customer c) {
//		String cs = c.getCustStatus().name();
		return new CustomerVO(c.getId(),c.getName(),c.getAge(),c.getAddress(),c.getPermanentAddress());
	}
	
	public Customer to() {
//		CustomerStatus customerStatus = CustomerStatus.valueOf("Enable");
		return new Customer(name,age,address,permanentAddress,CustomerStatus.ENABLED);
	}

}
