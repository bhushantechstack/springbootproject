package com.springboot.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.springboot.project.model.Products;
import com.springboot.project.service.ProductService;

import jakarta.websocket.server.PathParam;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private final WebClient webClient;

    public ProductController(WebClient webClient) {
        this.webClient = webClient;
    }

    @GetMapping("/product")
    public String getProduct() {
        return "Product details";
    }

    @PutMapping("/register")
    public void registerProduct(@RequestBody Products product) {
        productService.registerProduct(product);
    }

    @GetMapping("/products")
    public List<Products> getAllProducts() {
        return productService.getAllProducts();
    }

    @PutMapping("/update")
    public long updateProduct(@RequestBody Products product) {
        return productService.updateProduct(product);
    }
    // used Query String parameters to update product name
    @PatchMapping("/changeName")
    public long changeProductName(@PathParam("id") Long id, @PathParam("name") String name) {
        return productService.updateProduct(id, name);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable long id) {
        return productService.deleteProduct(id);
    }
    @GetMapping("/thirdparty/products")
    public Flux<String> getProductList() {
        System.out.println("Fetching product list from third party service");
        return webClient.get().uri("/list").retrieve().bodyToFlux(String.class);
    }
    @GetMapping("/product/{id}/{name}")
    public ResponseEntity<Products> getProductByIdAndName(@PathVariable Long id, @PathVariable String name) {
        Products product = productService.getProductsByIdAndName(id, name);
        return new ResponseEntity<Products>(product, HttpStatus.OK);
    }
    // Calling costom query via this method
    @GetMapping("/product/name/{name}")
    public String getProductByName(@PathVariable String name) {
        return productService.getProductByName(name);
    }

}
