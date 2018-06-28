package com.vsplc.FirstApp.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vsplc.FirstApp.dao.ProductDao;
import com.vsplc.FirstApp.model.Product;
import com.vsplc.FirstApp.service.ProductService;

@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductDao dao;
	
	@Override
	public List<Product> findAllProducts() {		
		return dao.findAllProducts();
	}

	@Override
	public void saveProduct(Product product) {
		 dao.saveProduct(product);
		
	}

}
