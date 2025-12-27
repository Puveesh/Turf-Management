package com.example.springapp.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {

    @RequestMapping("/view/{id}")
    public String getAttendance(@PathVariable int id) {
        return "ok";
    }
}