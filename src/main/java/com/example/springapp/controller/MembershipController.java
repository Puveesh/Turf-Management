package com.example.springapp.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/membership")
public class MembershipController {

    @RequestMapping("/details/{id}")
    public String getMembership(@PathVariable int id) {
        return "ok";
    }
}