package com.example.springapp.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @RequestMapping("/process")
    public String processPayment() {
        return "ok";
    }
}