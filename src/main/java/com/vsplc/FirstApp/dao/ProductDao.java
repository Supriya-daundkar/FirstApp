package com.vsplc.FirstApp.dao;

import java.util.List;

import com.vsplc.FirstApp.model.Product;


public interface ProductDao {
	 List<Product> findAllProducts();

	 void saveProduct(Product product);
}
