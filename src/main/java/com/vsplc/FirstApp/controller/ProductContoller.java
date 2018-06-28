package com.vsplc.FirstApp.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.vsplc.FirstApp.model.Product;
import com.vsplc.FirstApp.service.ProductService;

@Controller
public class ProductContoller {
	@Autowired
	ProductService productService;

	@Autowired
    ServletContext servletContext;
	
	@RequestMapping(value = "/list-product", method = RequestMethod.GET)
	public String getAllProductList(ModelMap model) {
		List<Product> products = productService.findAllProducts();
		model.addAttribute("products", products);
		return "productList";
	}

	@RequestMapping(value = "/new-product", method = RequestMethod.GET)
	public String newProduct(ModelMap model) {
		Product product = new Product();
		model.addAttribute("product", product);
		model.addAttribute("edit", false);
		return "product";
	}

	/**
	 * This method will be called on form submission, handling POST request for
	 * saving user in database. It also validates the user input
	 */
	// Save the uploaded file to this folder

	@RequestMapping(value = { "/new-product" }, method = RequestMethod.POST)
	public String saveUser(@Valid Product product, BindingResult result, ModelMap model,
			@RequestParam("file") MultipartFile file) {

		if (result.hasErrors()) {
			System.out.println(result.getAllErrors());
			return "product";
		}

		if (file.isEmpty()) {
			return "product";
		}
		String webappRoot = servletContext.getRealPath("/");
		String relativeFolder = File.separator + "static" + File.separator + "images" + File.separator + "product"
				+ File.separator;
		String filename = webappRoot + relativeFolder + file.getOriginalFilename();
		System.out.println("filename" + filename);
		try {

			// Get the file and save it somewhere
			byte[] bytes = file.getBytes();
			Path path = Paths.get(filename);
			Files.write(path, bytes);
		} catch (IOException e) {
			e.printStackTrace();
		}
	    productService.saveProduct(product);

		model.addAttribute("success",
				"Product added successfully");
		// return "success";
		return "product";
	}
}
