package com.codegym.repository.impl;

import com.codegym.model.Product;
import com.codegym.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {
    @Autowired
    private static List<Product> products;
//    private static List<Product> products = new ArrayList<>();
    static{
        products.add(new Product(0,"Iphone7", 350.00, "Apple"));
        products.add(new Product(1, "Iphone8", 400.00, "Apple"));
        products.add(new Product(2, "Mi Mix 2S", 300.00, "Xiaomi"));
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void add(Product product) {
        products.add(product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public void save(Product product) {
        products.get(product.getId()).setNameProduct(product.getNameProduct());
        products.get(product.getId()).setPriceProduct(product.getPriceProduct());
        products.get(product.getId()).setProducer(product.getProducer());
    }
}
