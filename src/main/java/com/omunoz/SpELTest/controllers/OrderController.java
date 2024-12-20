package com.omunoz.SpELTest.controllers;

import com.omunoz.SpELTest.services.DiscountService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class OrderController {

    private final DiscountService discountService;

    @PostMapping("/")
    private String getDiscount(@RequestBody Order order) {
        double discount = this.discountService.calculateDiscount(order);
        return "Total discount: " + discount;
    }

}
