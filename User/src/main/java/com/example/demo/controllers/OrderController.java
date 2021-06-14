package com.example.demo.controllers;

import com.example.demo.models.OrderEntity;
import com.example.demo.models.PanierEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
@RequestMapping("/Order")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createOrder(@RequestBody OrderEntity order) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<OrderEntity> entity = new HttpEntity<>(order,headers);

        return restTemplate.exchange(
                "http://localhost:8083/order", HttpMethod.POST, entity, String.class).getBody();
    }

}
