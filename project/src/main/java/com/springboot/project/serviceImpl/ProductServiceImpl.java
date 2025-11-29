package com.springboot.project.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.project.costomException.MultipleProductFoundWithThisName;
import com.springboot.project.costomException.ProductIsNotAvailable;
import com.springboot.project.model.Products;
import com.springboot.project.repository.ProductRepository;
import com.springboot.project.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public void registerProduct(Products product) {
        if (product.getName().equals("Wifi")) {
            throw new ProductIsNotAvailable("Product with name 'Wifi' is not available for registration.");
        }
        productRepository.save(product);
    }

    @Override
    public List<Products> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public long updateProduct(Products product) {
        Products existingProduct = productRepository.findById(product.getId()).orElse(null);
        if (existingProduct != null) {
            existingProduct.setName(product.getName());
            existingProduct.setPrice(product.getPrice());

            return productRepository.save(existingProduct).getId();
        }
        return 0;
    }

    @Override
    public long updateProduct(Long id, String name) {
        Products existingProduct = productRepository.findById(id).orElse(null);
        if (existingProduct != null) {
            existingProduct.setName(name);
            return productRepository.save(existingProduct).getId();
        }
        return 0;
    }

    @Override
    public String deleteProduct(long id) {
        if (productRepository.findById(id).isEmpty()) {
            return "Product not found with Id: " + id;
        } else {
            productRepository.deleteById(id);
            return "Product deleted successfully with Id: " + id;
        }

    }

    @Override
    public Products getProductsByIdAndName(Long id, String name) {
        return productRepository.findByIdAndName(id, name);
    }

    @Override
    public String getProductByName(String name) {
        try {
        Products product = productRepository.findByName(name);
        if (product != null) {
            return "Product found: " + product.getName() + " with ID: " + product.getId();
        } else {
            return "Product not found with name: " + name;
        }
        } catch (Exception e) {
            throw new MultipleProductFoundWithThisName("An error occurred while retrieving the product: " + e.getMessage());
        }
    }

}
