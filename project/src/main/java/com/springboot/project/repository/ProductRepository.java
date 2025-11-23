package com.springboot.project.repository;
import com.springboot.project.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ProductRepository extends JpaRepository<Products, Long> {

}
