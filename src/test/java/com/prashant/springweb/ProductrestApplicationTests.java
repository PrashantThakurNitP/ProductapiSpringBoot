package com.prashant.springweb;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.prashant.springweb.entities.Product;
import static org.junit.Assert. *;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProductrestapiApplicationTests {
	
	@Value("${productrestapi.services.url}")//using this we remove hardcode url
	private String baseUrl;
	//fetch url from application.property

	@Test
	void testGetProduct() {
		RestTemplate restTemplate=new RestTemplate();
		Product product = restTemplate.getForObject(baseUrl+"1", Product.class);
		//second argument tells object that will come and we can do deserialization
		assertNotNull(product);
		assertEquals("Iphone",product.getName());
	}
	
	@Test
	void testCreateProduct() {
		RestTemplate restTemplate=new RestTemplate();
		Product product = new Product();
		product.setName("Redmi phone");
		product.setDescription("sceen quality is bad");
		product.setPrice(10000);
		Product newProduct = restTemplate.postForObject(baseUrl, product, Product.class);
		//second argument tells object that will come and we can do deserialization
		assertNotNull(newProduct);
		assertNotNull(newProduct.getId());
		assertEquals("Redmi phone",newProduct.getName());
	}
	@Test
	void testUpdateProduct() {
		RestTemplate restTemplate=new RestTemplate();
		Product product = restTemplate.getForObject(baseUrl+"1", Product.class);
		product.setPrice(15600)	;	//second argument tells object that will come and we can do deserialization
		
		restTemplate.put(baseUrl, product, Product.class);
	//	assertNotNull(product);
		//assertEquals("Iphone",product.getName());
	}
	
}
