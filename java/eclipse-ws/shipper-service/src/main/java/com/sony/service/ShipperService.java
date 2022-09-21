package com.sony.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sony.entity.Shipper;
import com.sony.repository.ShipperRepository;

@Service
public class ShipperService {
	@Autowired
	private ShipperRepository repo;

	public Shipper getShipperById(Integer id) {
		Optional<Shipper> op = repo.findById(id);
		if (op.isEmpty()) {
			return null;
		}
		return op.get();
	}
}
