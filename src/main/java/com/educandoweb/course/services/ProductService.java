package com.educandoweb.course.services;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.entities.Product;
import com.educandoweb.course.repositories.CategoryRepository;
import com.educandoweb.course.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;

	@Transactional(readOnly = true)
	public List<Product> findAll() {
		List<Product> list = repository.findAll();
		list.forEach(p -> p.getCategories().size());
		return list;

	}
	
	@Transactional(readOnly = true)
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		Product product = obj.get();
		product.getCategories().size();
		return product;
	}
	
	
	
	
	
}
