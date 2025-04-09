package com.valtech.training.ecommerce.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.valtech.training.ecommerce.entities.LineItem;

public interface LineItemRepo extends JpaRepository<LineItem, Long>{

}
