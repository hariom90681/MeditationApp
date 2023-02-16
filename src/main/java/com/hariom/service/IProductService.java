package com.hariom.service;

import com.hariom.model.Product;

import java.util.List;

public interface IProductService
{
    Integer saveProduct(Product p);

    List<Product> getAllProducts();

}
