package com.mobwink.percentoff.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mobwink.percentoff.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	Product findById(Long id);
	
	List<Product> findAll();
	
}
