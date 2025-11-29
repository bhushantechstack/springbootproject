package com.springboot.project.service;

import java.util.List;

import com.springboot.project.model.Products;

public interface ProductService {

    void registerProduct(Products product);

    List<Products> getAllProducts();

    long updateProduct(Products product);

    long updateProduct(Long id, String name);

    String deleteProduct(long id);

    Products getProductsByIdAndName(Long id, String name);

    String getProductByName(String name);

}
