package com.valtech.training.restapis.vos;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.valtech.training.restapis.entities.Owner;

public class OwnerVO {

	private long id;
	private String name;
	private String mobile;
	private String email;
	private Set<Long> watches;
	
	public OwnerVO() {
		
	}

	public OwnerVO( long id,String name, String mobile, String email, Set<Long> watches) {
		this.id = id;
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.watches = watches;
	}
	public static List<OwnerVO> toOwnerVO(List<Owner> owners){
		return owners.stream().map(o->OwnerVO.from(o)).collect(Collectors.toList());
	}
	
	public static OwnerVO from(Owner o) {
		
		Set<Long>watches = o.getWatches() ==null ? Set.of() :o.getWatches().stream().map(o1->o.getId()).collect(Collectors.toSet());
		return new OwnerVO(o.getId(),o.getName(),o.getMobile(),o.getEmail(),watches);
	}
	public Owner toOwner() {
		Owner o = new Owner(name,mobile,email);
		o.setId(id);
		return o;
	}
	
	public void updateOrderFromVO(Owner o) {
		o.setName(name);
		o.setMobile(mobile);
		o.setEmail(email);
	}
	
	
	
	@Override
	public String toString() {
		return "OwnerVO [id=" + id + ", name=" + name + ", mobile=" + mobile + ", email=" + email + ", watches="
				+ watches + "]";
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Long> getWatches() {
		return watches;
	}

	public void setWatches(Set<Long> watches) {
		this.watches = watches;
	}
	
	
}
