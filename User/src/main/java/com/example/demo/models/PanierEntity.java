package com.example.demo.models;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


public class PanierEntity {

    private Long idpanier;

    private List<ProductsEntity> productsEntityList;

    public Long getIdpanier() {
        return idpanier;
    }

    public void setIdpanier(Long idpanier) {
        this.idpanier = idpanier;
    }

    public List<ProductsEntity> getProductsEntityList() {
        return productsEntityList;
    }

    public void setProductsEntityList(List<ProductsEntity> productsEntityList) {
        this.productsEntityList = productsEntityList;
    }
}
