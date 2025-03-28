package org.amazon.restwebservice;

import java.util.List;

import org.amazon.restwebservice.entity.Electronics_Product;
import org.amazon.restwebservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest Controller to return the response as objects/String.
 *  
 * */
@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService service;
	
	@GetMapping("/list")
    public List<Electronics_Product> getAllProducts(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public String getProduct(@PathVariable int id){
        return service.findById(id).toString();
    }

    @PostMapping("/add")
    public String addProduct(@RequestBody Electronics_Product prod){
        System.out.println("Product to be created "+prod);
        service.save(prod);
        return "Product saved Successfully";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id){
        service.deleteById(id);
        return "Product deleted successfully";
    }

    @PutMapping("/update/{id}")
    public String updateProduct(@RequestBody Electronics_Product p, @PathVariable int id){
    	Electronics_Product product = service.updateProduct(id,p);
        return product==null?"Update Failed": "Product Updated Successfully";
    }
}
