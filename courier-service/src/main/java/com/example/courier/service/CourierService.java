package com.example.courier.service;

import com.example.courier.entity.Courier;
import com.example.courier.repository.CourierRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourierService {

    private final CourierRepository courierRepository;

    public CourierService(CourierRepository courierRepository) {
        this.courierRepository = courierRepository;
    }

    public List<Courier> getAllCouriers() {
        return courierRepository.findAll();
    }

    public Optional<Courier> getCourierById(Long id) {
        return courierRepository.findById(id);
    }

    public Courier saveCourier(Courier courier) {
        return courierRepository.save(courier);
    }

    public void deleteCourier(Long id) {
        courierRepository.deleteById(id);
    }
}
