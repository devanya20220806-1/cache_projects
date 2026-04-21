package com.dev.buildtalent.services;

import java.util.List;
import java.util.Optional;

import com.dev.buildtalent.entity.Product;

public interface ProductService {
	
	public Product saveProduct(Product product);
	public Optional<Product> findById(Long productId);
	public Product updateProduct(Product product, Long productId);
	public void deleteProduct(Long productId);
	public List<Product> findAllProduct();
	

}
