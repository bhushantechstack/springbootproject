package com.springboot.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.project.model.Products;
import com.springboot.project.service.ProductService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    public String getProduct() {
        // Implementation here
        return "Product details";
    }
    @PutMapping("/register")
    public void registerProduct(@RequestBody Products product) {
        // Implementation here
        productService.registerProduct(product);
    }
    @GetMapping("/products")
    public List<Products> getAllProducts() {
        // Implementation here
        return productService.getAllProducts();
    }
    @PutMapping("/update")
    public long updateProduct(@RequestBody Products product) {
        // Implementation here
        return productService.updateProduct(product);
    }
    @PatchMapping("/changeName")
    public long changeProductName(@PathParam("id") Long id, @PathParam("name") String name) {
        // Implementation here
    
        return productService.updateProduct(id, name);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable long id) {
        // Implementation here
        return productService.deleteProduct(id);
    }

}
