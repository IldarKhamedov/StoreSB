package ru.khamedov.store.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.khamedov.store.error.JsonError;
import ru.khamedov.store.model.ProductDTO;
import ru.khamedov.store.service.ProductService;
import ru.khamedov.store.model.Product;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RestController

public class ProductRestController {

	@Resource
	private ProductService productService;



	@GetMapping("/products")
	public List<Product> getProducts(@RequestParam(name="count", required=false) Integer count) {
		if(count==null || count==0){
			return Collections.EMPTY_LIST;
		}
		return productService.getProductList(count);
	}

	@GetMapping("/product/{id}")
	public ResponseEntity<?> getProduct(@PathVariable(required = false) Long id){
		try {
			Product product = productService.getProduct(id);
			return new ResponseEntity<>(product, HttpStatus.OK);
		} catch (Exception e){
			return new ResponseEntity<>(new JsonError(HttpStatus.NOT_FOUND.value(),
					"Product with id " + id + " not found"),
					HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/product/all")
	public Collection<Product> getAllProducts() {
		return productService.getAll();
	}

	@PostMapping("product/create")
	public ResponseEntity<Product> createProduct(@RequestBody ProductDTO productDTO){
		return new ResponseEntity<Product>(productService.createProduct(productDTO),HttpStatus.OK);
	}

}
