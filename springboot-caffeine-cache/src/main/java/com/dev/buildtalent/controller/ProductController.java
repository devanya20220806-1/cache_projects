package com.dev.buildtalent.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.dev.buildtalent.entity.Product;
import com.dev.buildtalent.services.ProductService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService productService;
	
	Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@PostMapping("/save")
	public Product saveProduct(@RequestBody Product product) {
		logger.info("inside controller");
		return productService.saveProduct(product);
		
	}

	@GetMapping("/findAllProducts")
	public List<Product> findAllProduct(){
		return productService.findAllProduct();
	}

	@GetMapping("/findProductById/{productId}")
	public Optional<Product> findById(@PathVariable("productId")Long productId){
		return productService.findById(productId);
	}

	@DeleteMapping("/deleteProduct/{productId}")
	public void deleteProduct(@PathVariable("productId") Long productId){
		 productService.deleteProduct(productId);
	}
	
	@PutMapping("/updateProduct/{productId}")
	public Product updateProduct(@RequestBody Product product, @PathVariable("productId") Long productId){
		Optional<Product> productBeforeUpdate = productService.findById(productId);
		Product productBeforeUpdate1 = null;
		if(productBeforeUpdate.isPresent()) {
			productBeforeUpdate1 = productBeforeUpdate.get();

			productBeforeUpdate1.setName(product.getName());
			productBeforeUpdate1.setType(product.getType());
			productBeforeUpdate1.setCode(product.getCode());
			return productService.saveProduct(productBeforeUpdate1);
		}
		return  null;
	}
}
