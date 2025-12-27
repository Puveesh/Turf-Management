package com.example.springapp.controller;

import com.example.springapp.model.MembershipType;
import com.example.springapp.service.MembershipTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/membership-types")
public class MembershipTypeController {
    private final MembershipTypeService service;

    public MembershipTypeController(MembershipTypeService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<MembershipType> create(@RequestBody MembershipType type) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(type));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MembershipType> update(@PathVariable Long id, @RequestBody MembershipType type) {
        return ResponseEntity.ok(service.update(id, type));
    }

    @GetMapping
    public ResponseEntity<List<MembershipType>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MembershipType> getById(@PathVariable Long id) {
        return service.getById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<?> getByName(@PathVariable String name) {
        List<MembershipType> types = service.getByName(name);
        return types.isEmpty() ? ResponseEntity.status(HttpStatus.NO_CONTENT).body("No membership types found") : ResponseEntity.ok(types);
    }

    @GetMapping("/price")
    public ResponseEntity<List<MembershipType>> getByPriceRange(@RequestParam Double min, @RequestParam Double max) {
        return ResponseEntity.ok(service.getByPriceRange(min, max));
    }

    @GetMapping("/duration-greater/{duration}")
    public ResponseEntity<?> getByDurationGreaterThan(@PathVariable Integer duration) {
        List<MembershipType> types = service.getByDurationGreaterThan(duration);
        return types.isEmpty() ? ResponseEntity.status(HttpStatus.NO_CONTENT).body("No membership types found with duration greater than " + duration) : ResponseEntity.ok(types);
    }

    @GetMapping("/price-less/{price}")
    public ResponseEntity<?> getByPriceLessThan(@PathVariable Double price) {
        List<MembershipType> types = service.getByPriceLessThan(price);
        return types.isEmpty() ? ResponseEntity.status(HttpStatus.NO_CONTENT).body("No membership types found") : ResponseEntity.ok(types);
    }

    @RequestMapping("/type/{typeId}")
    public String getType(@PathVariable int typeId) {
        return "ok";
    }
}