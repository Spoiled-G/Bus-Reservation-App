package com.reservationapp.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;
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
    private Long subRouteId;

    private String fromLocation;
    private String toLocation;
    private String toDate;
    private String fromDate;
    private String fromTime;
    private String toTime;
    private String totalDuration;
    @Column(name = "route_id",nullable = false)
    private long routeId;
    private long busId;

//    @ManyToOne
//    @JoinColumn(name = "route_id")
//    private Route route;
}
