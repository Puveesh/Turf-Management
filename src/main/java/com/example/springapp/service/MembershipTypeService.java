package com.example.springapp.service;

import com.example.springapp.model.MembershipType;
import com.example.springapp.repository.MembershipTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MembershipTypeService {
    private final MembershipTypeRepository repository;

    public MembershipTypeService(MembershipTypeRepository repository) {
        this.repository = repository;
    }

    public MembershipType create(MembershipType type) {
        return repository.save(type);
    }

    public MembershipType update(Long id, MembershipType type) {
        type.setTypeId(id);
        return repository.save(type);
    }

    public List<MembershipType> getAll() {
        return repository.findAll();
    }

    public Optional<MembershipType> getById(Long id) {
        return repository.findById(id);
    }

    public List<MembershipType> getByName(String name) {
        return repository.findByTypeName(name);
    }

    public List<MembershipType> getByPriceRange(Double min, Double max) {
        return repository.findByPriceRange(min, max);
    }

    public List<MembershipType> getByDurationGreaterThan(Integer duration) {
        return repository.findByDurationGreaterThan(duration);
    }

    public List<MembershipType> getByPriceLessThan(Double price) {
        return repository.findByPriceLessThan(price);
    }
}
