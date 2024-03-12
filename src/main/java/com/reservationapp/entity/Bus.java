package com.reservationapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bus")
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @Column(name = "bus_number")
    private String busNumber;

    @Column(name = "bus_type")
    private String busType;

    @Column(name = "price")
    private double price;

    @Column(name = "total_seats")
    private int totalSeats;

    @Column(name = "available_seats")
    private int availableSeats;


    @OneToOne(mappedBy = "bus")
    private Route route;



}



