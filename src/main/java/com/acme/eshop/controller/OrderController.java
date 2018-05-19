package com.acme.eshop.controller;

import com.acme.eshop.domain.Order;
import com.acme.eshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    //generally we use @Request params

    @GetMapping(value = "/orders")
    public ResponseEntity<Page<Order>> getAllOrder(Long userId, Pageable pageable) {
        //check is user has an open season and he is admin
        return ResponseEntity.ok()
                .body(orderService.getAllOrder(userId, pageable));
    }

    @GetMapping(value = "/orders/{userId}")
    public ResponseEntity<Page<Order>> getAllByUser(@PathVariable(name = "userId") Long userId, Pageable pageable) {
        //check if user has an open season if not 401
        return ResponseEntity.ok()
                .body(orderService.getAllByUser(userId, pageable));
    }
}
