package com.reservationapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "route")
public class Route {

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



    @OneToMany(mappedBy = "route", cascade = CascadeType.ALL)
    private List<SubRoute> subRoutes;

    @OneToOne
    @JoinColumn(name = "bus_id")
    private Bus bus;


}
