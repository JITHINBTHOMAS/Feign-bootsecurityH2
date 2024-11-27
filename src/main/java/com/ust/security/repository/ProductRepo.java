package com.ust.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ust.security.model.Product;
@Repository
public interface ProductRepo extends JpaRepository<Product, Long>{

}
