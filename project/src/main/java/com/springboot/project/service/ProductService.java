package com.springboot.project.service;

import java.util.List;

import com.springboot.project.model.Products;

public interface ProductService {

    void registerProduct(Products product);

    List<Products> getAllProducts();

}
