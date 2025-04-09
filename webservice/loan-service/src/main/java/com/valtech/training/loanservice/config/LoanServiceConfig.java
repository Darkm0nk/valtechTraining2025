package com.valtech.training.loanservice.config;

import javax.xml.namespace.QName;
import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.valtech.training.loanservice.services.LoanService;
import com.valtech.training.loanservice.webservices.LoanServiceWS;
import com.valtech.training.loanservice.webservices.LoanServiceWSImpl;


@Configuration
public class LoanServiceConfig {

	@Autowired
	private Bus bus;
	
	@Bean
	public Endpoint LoanServiceWS(LoanService service) {
		EndpointImpl endpoint = new EndpointImpl(bus, new LoanServiceWSImpl(service));
		endpoint.setAddress("/loanService");
		endpoint.publish();
		return endpoint;
	}
}
