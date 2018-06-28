package com.vsplc.FirstApp.service;

import java.util.List;

import com.vsplc.FirstApp.model.Product;

public interface ProductService {
	 List<Product> findAllProducts();

	void saveProduct(Product product);
}
