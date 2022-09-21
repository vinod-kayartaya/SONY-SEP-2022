package com.sony.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sony.entity.Shipper;

public interface ShipperRepository extends JpaRepository<Shipper, Integer> {

}
