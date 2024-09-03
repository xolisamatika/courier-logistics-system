package com.example.courier.controller;

import com.example.courier.entity.Courier;
import com.example.courier.service.CourierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/couriers")
public class CourierController {

    private final CourierService courierService;

    public CourierController(CourierService courierService) {
        this.courierService = courierService;
    }

    @GetMapping
    public List<Courier> getAllCouriers() {
        return courierService.getAllCouriers();
    }

    @GetMapping("/{id}")
    public Optional<Courier> getCourierById(@PathVariable Long id) {
        return courierService.getCourierById(id);
    }

    @PostMapping
    public Courier createCourier(@RequestBody Courier courier) {
        return courierService.saveCourier(courier);
    }

    @PutMapping("/{id}")
    public Courier updateCourier(@PathVariable Long id, @RequestBody Courier courier) {
        courier.setId(id);
        return courierService.saveCourier(courier);
    }

    @DeleteMapping("/{id}")
    public void deleteCourier(@PathVariable Long id) {
        courierService.deleteCourier(id);
    }
}
