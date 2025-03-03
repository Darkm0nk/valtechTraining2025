package com.valtech.training.jaws;

import javax.jws.WebService;

@WebService
public interface HelloWorld {

	public String hello(String name);
}