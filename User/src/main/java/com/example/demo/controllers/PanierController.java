package com.example.demo.controllers;

import com.example.demo.models.PanierEntity;
import com.example.demo.models.ProductsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
@RequestMapping("Panier")
public class PanierController {

    @Autowired
    private RestTemplate restTemplate;

    //add panier
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createProducts(@RequestBody PanierEntity panier) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<PanierEntity> entity = new HttpEntity<>(panier,headers);

        return restTemplate.exchange(
                "http://localhost:8081/panier", HttpMethod.POST, entity, String.class).getBody();
    }

}
