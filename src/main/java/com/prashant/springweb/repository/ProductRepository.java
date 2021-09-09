package com.prashant.springweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prashant.springweb.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
