package com.example.demo.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;


public class ProductsEntity {

    private Long idProd;
    private String NameProd;
    private  String DescProd;
    private float price;
    private int quantity;

    private float buyingprice;

    private CategoriesEntity categoriesEntity;

    private List<PicturesEntity> pictures;

    private List<PanierEntity> panierEntities;

    public Long getIdProd() {
        return idProd;
    }

    public void setIdProd(Long idProd) {
        this.idProd = idProd;
    }

    public String getNameProd() {
        return NameProd;
    }

    public void setNameProd(String nameProd) {
        NameProd = nameProd;
    }

    public String getDescProd() {
        return DescProd;
    }

    public void setDescProd(String descProd) {
        DescProd = descProd;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getBuyingprice() {
        return buyingprice;
    }

    public void setBuyingprice(float buyingprice) {
        this.buyingprice = buyingprice;
    }

    public CategoriesEntity getCategoriesEntity() {
        return categoriesEntity;
    }

    public void setCategoriesEntity(CategoriesEntity categoriesEntity) {
        this.categoriesEntity = categoriesEntity;
    }

    public List<PicturesEntity> getPictures() {
        return pictures;
    }

    public void setPictures(List<PicturesEntity> pictures) {
        this.pictures = pictures;
    }

    public List<PanierEntity> getPanierEntities() {
        return panierEntities;
    }

    public void setPanierEntities(List<PanierEntity> panierEntities) {
        this.panierEntities = panierEntities;
    }
}
