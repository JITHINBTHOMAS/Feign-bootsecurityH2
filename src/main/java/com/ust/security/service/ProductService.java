package com.ust.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.security.model.Product;
import com.ust.security.repository.ProductRepo;

@Service
public class ProductService {

	@Autowired
	private ProductRepo repo;
	
	public Product addProduct(Product prod) {
		return repo.save(prod); 
	}
}
