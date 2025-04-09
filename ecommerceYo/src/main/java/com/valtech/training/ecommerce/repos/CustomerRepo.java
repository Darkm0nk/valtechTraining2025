package com.valtech.training.ecommerce.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.valtech.training.ecommerce.entities.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Long>{

}
