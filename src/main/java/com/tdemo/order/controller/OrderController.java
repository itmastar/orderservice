package com.tdemo.order.controller;

import com.tdemo.order.dto.OrderDTO;
import com.tdemo.order.dto.OrderDTOFromFE;
import com.tdemo.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/saveOrder")
    public ResponseEntity<OrderDTO> saveOrder(@RequestBody OrderDTOFromFE orderDTOFromFE)
    {
        OrderDTO orderDTO=orderService.saveOrder(orderDTOFromFE);
        return new ResponseEntity<>(orderDTO, HttpStatus.CREATED);
    }
}
