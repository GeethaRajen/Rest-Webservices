package org.amazon.restwebservice.repository;

import org.amazon.restwebservice.entity.Electronics_Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Electronics_Product, Integer>{

}
