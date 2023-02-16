package com.hariom.service.impl;

import com.hariom.model.Product;
import com.hariom.repo.ProductRepository;
import com.hariom.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductRepository repo;

    @Override
    public Integer saveProduct(Product p) {
        //JDK 10 : local variable type inference
        //Best DataType is selected by Java compiler - var
        var cost=p.getProdCost();

        var gst=cost * 12.0/100;
        var disc=cost * 20.0/100;

        p.setProdGst(gst);
        p.setProdDisc(disc);

        p=repo.save(p);
        return p.getProdId();
    }

    @Override
    public List<Product> getAllProducts() {
      List<Product> list= repo.findAll();
        return list;
    }
}
