package com.mobwink.percentoff.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobwink.percentoff.model.Product;
import com.mobwink.percentoff.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public Product findById(Long id){
		return productRepository.findById(id);
	}
	
	public List<Product> findAll(){
		return productRepository.findAll();
	}
	
}
