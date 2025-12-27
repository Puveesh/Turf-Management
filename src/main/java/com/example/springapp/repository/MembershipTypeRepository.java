package com.example.springapp.repository;

import com.example.springapp.model.MembershipType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MembershipTypeRepository extends JpaRepository<MembershipType, Long> {
    @Query("SELECT m FROM MembershipType m WHERE m.typeName = :name")
    List<MembershipType> findByTypeName(@Param("name") String name);

    @Query("SELECT m FROM MembershipType m WHERE m.price BETWEEN :min AND :max")
    List<MembershipType> findByPriceRange(@Param("min") Double min, @Param("max") Double max);

    @Query("SELECT m FROM MembershipType m WHERE m.durationInMonths > :duration")
    List<MembershipType> findByDurationGreaterThan(@Param("duration") Integer duration);

    @Query("SELECT m FROM MembershipType m WHERE m.price < :price")
    List<MembershipType> findByPriceLessThan(@Param("price") Double price);
}
