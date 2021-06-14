package com.example.demo.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

public class CategoriesEntity implements Serializable {

    private static long serialVersionUID;

    private Long idCat;

    private String NameCat;

    private String Picture;

    public CategoriesEntity()
    {

    }

    public CategoriesEntity(String nameCat, String picture) {
        NameCat = nameCat;
        Picture = picture;

    }

    public Long getIdCat() {
        return idCat;
    }

    public void setIdCat(Long idCat) {
        this.idCat = idCat;
    }

    public String getNameCat() {
        return NameCat;
    }

    public void setNameCat(String nameCat) {
        NameCat = nameCat;
    }

    public String getPicture() {
        return Picture;
    }

    public void setPicture(String picture) {
        Picture = picture;
    }

}
