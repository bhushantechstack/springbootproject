package com.springboot.project.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.project.model.Products;
import com.springboot.project.repository.ProductRepository;
import com.springboot.project.service.ProductService;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public void registerProduct(Products product) {
        // TODO Auto-generated method stub
        productRepository.save(product);

        
    }

    @Override
    public List<Products> getAllProducts() {
        // TODO Auto-generated method stub
        return productRepository.findAll();
    }

}
