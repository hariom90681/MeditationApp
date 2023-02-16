package com.hariom.controller;

import com.hariom.model.Product;
import com.hariom.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductRestController {

    @Autowired
    private IProductService service; //here service is the interface reference variable at runtime it will choose the implementation class.

    @PostMapping
    public ResponseEntity<String> saveProduct(
            @RequestBody Product product)
    {
        //not understand properly
        Integer id=service.saveProduct(product);
        return new ResponseEntity<String>("Product saved "+id, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Product>> getAllProducts()
    {
      List<Product> list= service.getAllProducts();
        return new ResponseEntity<List<Product>>(list,HttpStatus.OK);

    }




}