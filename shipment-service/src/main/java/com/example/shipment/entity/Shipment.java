package com.example.shipment.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "shipments")
public class Shipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sender;
    private String receiver;
    private String origin;
    private String destination;
    private String currentLocation;
    private String status; // e.g., Created, Picked Up, In Transit, Delivered
    private LocalDateTime creationTime;
    private LocalDateTime updateTime;
}