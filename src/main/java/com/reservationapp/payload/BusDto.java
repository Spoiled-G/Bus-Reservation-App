package com.reservationapp.payload;

import com.reservationapp.entity.Driver;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusDto {
    private String busNumber;
    private String busType;
    private double price;
    private int totalSeats;
    private int availableSeats;
    private RouteDto route;
    private List<SubRouteDto> subRoutes;
}

