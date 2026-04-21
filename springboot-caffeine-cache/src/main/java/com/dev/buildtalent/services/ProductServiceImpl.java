package com.dev.buildtalent.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.buildtalent.entity.Product;
import com.dev.buildtalent.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductRepository productRepository;

	@Override
	public Product saveProduct(Product product) {
		
		return productRepository.save(product);
		
	}

	@Override
	public Optional<Product> findById(Long productId) {
		return productRepository.findById(productId);
		
	}

	@Override
	public Product updateProduct(Product product, Long productId) {
		
		return null;
	}

	@Override
	public void deleteProduct(Long productId) {
		productRepository.deleteById(productId);
		
	}

	@Override
	public List<Product> findAllProduct() {
		
		return productRepository.findAll();
	}

}
