package com.reservationapp.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sub_route")
public class SubRoute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fromLocation;
    private String toLocation;
    private String toDate;
    private String fromDate;
    private String fromTime;
    private String toTime;
    private String totalDuration;

    @ManyToOne
    @JoinColumn(name = "route_id")
    private Route route;
}
