package com.example.transportmanagement.model;

import jakarta.persistence.*;
import lombok.*;
@Getter
@Setter

@Entity
@Table(name = "bus")
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "plate_number")
    private String number;

    @Column(name = "model")
    private String model;

    @Column(name = "capacity")
    private int capacity;
}

