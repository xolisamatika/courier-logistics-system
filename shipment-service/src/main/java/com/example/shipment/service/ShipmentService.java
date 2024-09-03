package com.example.shipment.service;

import com.example.shipment.entity.Shipment;
import com.example.shipment.repository.ShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShipmentService {

    private final ShipmentRepository shipmentRepository;

    public ShipmentService(ShipmentRepository shipmentRepository) {
        this.shipmentRepository = shipmentRepository;
    }

    public Shipment createShipment(Shipment shipment) {
        shipment.setStatus("Created");
        return shipmentRepository.save(shipment);
    }

    public Optional<Shipment> getShipmentById(Long id) {
        return shipmentRepository.findById(id);
    }

    public List<Shipment> getAllShipments() {
        return shipmentRepository.findAll();
    }

    public Shipment updateShipment(Long id, Shipment updatedShipment) {
        return shipmentRepository.findById(id).map(shipment -> {
            shipment.setSender(updatedShipment.getSender());
            shipment.setReceiver(updatedShipment.getReceiver());
            shipment.setOrigin(updatedShipment.getOrigin());
            shipment.setDestination(updatedShipment.getDestination());
            shipment.setCurrentLocation(updatedShipment.getCurrentLocation());
            shipment.setStatus(updatedShipment.getStatus());
            shipment.setUpdateTime(updatedShipment.getUpdateTime());
            return shipmentRepository.save(shipment);
        }).orElseThrow(() -> new RuntimeException("Shipment not found with id " + id));
    }

    public void deleteShipment(Long id) {
        shipmentRepository.deleteById(id);
    }
}