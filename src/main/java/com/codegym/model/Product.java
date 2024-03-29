package com.codegym.model;

public class Product {
    private int id;
    private String nameProduct;
    private Double priceProduct;
    private String producer;

    public Product() {
    }

    public Product(int id, String nameProduct, Double priceProduct, String producer) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
        this.producer = producer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public Double getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(Double priceProduct) {
        this.priceProduct = priceProduct;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}
