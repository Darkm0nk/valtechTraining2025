package com.valtech.training.loanservice.config;

import java.lang.reflect.Proxy;

import javax.xml.namespace.QName;

import org.apache.cxf.Bus;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import com.valtech.training.loanservice.webservices.LoanServiceWS;

@Configuration
public class LoanServiceClientConfig {
 
	@Bean
	public LoanServiceWS createLoanService() {
		JaxWsProxyFactoryBean proxy = new JaxWsProxyFactoryBean();
		proxy.setServiceClass(LoanServiceWS.class);
		proxy.setServiceName(new QName("http://webservices.loan-service.training.valtech.com/","LoanServiceWSImplService"));
		proxy.setAddress("http://localhost:8080/services/loanService");
		return proxy.create(LoanServiceWS.class);
	}
	
}
