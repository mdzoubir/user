package com.example.demo.controllers;

import com.example.demo.models.ProductsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
@RequestMapping("Product")
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    private RestTemplate restTemplate;


    //get all
    @GetMapping("/allProducts")
    public String getAllProducts(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity <String> entity = new HttpEntity<>(headers);
        return restTemplate.exchange("http://localhost:8081/products/getAllProducts", HttpMethod.GET, entity, String.class).getBody();
    }


    //get product by id
    @GetMapping("/{id}")
    public ProductsEntity getProduct(@PathVariable("id") String id){
        ProductsEntity productsEntity = restTemplate.getForObject("http://localhost:8081/products/getProductById/" + id, ProductsEntity.class);
        return productsEntity;
    }


    //add product
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createProducts(@RequestBody ProductsEntity product) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<ProductsEntity> entity = new HttpEntity<>(product,headers);

        return restTemplate.exchange(
                "http://localhost:8081/products", HttpMethod.POST, entity, String.class).getBody();
    }


    //update product
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    @PreAuthorize("hasRole('ADMIN')")
    public String updateProduct(@PathVariable("id") String id, @RequestBody ProductsEntity product) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<ProductsEntity> entity = new HttpEntity<>(product,headers);

        return restTemplate.exchange(
                "http://localhost:8081/products/update/"+id, HttpMethod.PUT, entity, String.class).getBody();
    }



    //delete product
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteProduct(@PathVariable("id") String id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<ProductsEntity> entity = new HttpEntity<>(headers);

        return restTemplate.exchange(
                "http://localhost:8081/products/RemoveProd/"+id, HttpMethod.DELETE, entity, String.class).getBody();
    }

}
