package com.prashant.springweb.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.prashant.springweb.entities.Product;
import com.prashant.springweb.repository.ProductRepository;

@RestController//to make this RestController we mark with Rest controller Annotation
public class ProductRestController {
	//inject product Repository
	//for this mark this with autowired
	@Autowired
	ProductRepository repository;
	
	private static final Logger LOGGER=LoggerFactory.getLogger(ProductRestController.class);

	@RequestMapping(value="/products",method=RequestMethod.GET)//mapping it with URI
	public List<Product>getProducts(){
		LOGGER.info("log all product ");
		
		return repository.findAll();
		
	}
	@RequestMapping(value="/products/{id}",method=RequestMethod.GET)//mapping it with URI
	public Product getProduct(@PathVariable("id") int id) {
		//capture path var1able and once captured bind it to parameter
		LOGGER.info("log Find product by id ",id);
		return repository.findById(id).get();
	}
	
	@RequestMapping(value="/products",method=RequestMethod.POST)//mapping it with URI
	public Product createProduct(@RequestBody Product product) {
		//capture request body and and once captured bind it to product object
		LOGGER.info("Create product");
		return repository.save(product);
	}
	
	@RequestMapping(value="/products",method=RequestMethod.PUT)//mapping it with URI
	public Product updateProduct(@RequestBody Product product) {
		//capture request body and and once captured bind it to product object
		LOGGER.info("Update product");
		return repository.save(product);//when we invoke repository.save will check whether product has id in it
		//if id exist it will only update in database
		//if id donot exist then it will insrt row in database
	}
	
	@RequestMapping(value="/products/{id}",method=RequestMethod.DELETE)//mapping it with URI
	public void deleteProduct(@PathVariable("id") int id) {
		//capture path var1able and once captured bind it to parameter
		LOGGER.info("Delete product");
		repository.deleteById(id);
	}
	
	
}
