package org.amazon.restwebservice.service;

import java.util.List;

import org.amazon.restwebservice.entity.Electronics_Product;
import org.amazon.restwebservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	@Autowired
    ProductRepository repository;

    public void save(Electronics_Product product){
        repository.save(product);
    }

    public List<Electronics_Product> findAll(){
        return repository.findAll();
    }

    public Electronics_Product findById(int id){
        return repository.getReferenceById(id);
    }

    public void deleteById(int id){
        repository.deleteById(id);
    }
    
    public Electronics_Product updateProduct(Integer id, Electronics_Product updateProduct) {
		System.out.println("Product to be updated with details: " + updateProduct);
		return repository.findById(id).map(product -> {
		    product.setName(updateProduct.getName());
		    product.setPrice(updateProduct.getPrice());
		    System.out.println(product);
		    repository.save(product);
		    return product;
		}).orElse(null);
    }
}
