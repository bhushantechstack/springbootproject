package com.springboot.project.repository;
import com.springboot.project.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface ProductRepository extends JpaRepository<Products, Long> {
    // Custom query method to find product by id and name
    Products findByIdAndName(Long id, String name);

    // Custom query method to find product by name
    @Query(value = "SELECT * FROM Products p WHERE p.name = :name", nativeQuery = true)
    Products findByName(String name);

}
